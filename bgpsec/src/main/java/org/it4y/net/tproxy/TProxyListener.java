/*
 * Copyright 2014 Luc Willems (T.M.M.)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.it4y.net.tproxy;

import org.it4y.jni.libc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * TProxyListener is single threaded listener that will handle TProxy redirected connections
 * A listening socket is created with TProxy enabled, and accept all TCP connection send to this socket
 *
 * users should implement newClient() and onIOError() to handle the connections
 *
 * Created by luc on 12/27/13.
 */
public abstract class TProxyListener extends Thread {

    private final Logger log = LoggerFactory.getLogger(TProxyListener.class);

    /***
     * local port of listening socket
     */
    private final int port;

    /***
     * backlog of socket
     */
    private int backlog = 100;

    /***
     * address to bind the socket
     */
    private final InetAddress bind;

    /***
     * our TProxy socket
     */
    private TProxyServerSocket socket;

    /***
     * Listener activated and running
     */
    private boolean running;

    /***
     * Listener halt requested
     */
    private boolean halted;

    private boolean init;

    /***
     * Create a TProxy enabled Listener
     * @param bind : ip address to bind to
     * @param port : port to use
     * @param backlog : socket backlog
     */
    public TProxyListener(final InetAddress bind, final int port, final int backlog) {
        this.port = port;
        this.backlog = backlog;
        this.bind = bind;
        setDaemon(true);
        setName("TProxy-listener-"+bind.toString()+ ':' +port);
    }

    /***
     * listener thread initialized and running
     * @return
     */
    public boolean isRunning() {
        return running;
    }

    /***
     * Gently stop listener thread
     */
    public void halt() {
        log.info("stop listener...");
        halted=true;
        //close socket, this will causes the running thread to stop
        try {
            socket.close();
        } catch (final IOException ignore) {}
    }
    /***
     * Gently stop listener thread
     */
    public boolean isHalted() {
        return halted;
    }


    public ServerSocket getSocket() {
        return socket;
    }

    /***
     * internal initialization of server
     * @throws libc.ErrnoException
     * @throws IOException
     */
    public void initServer() throws libc.ErrnoException,IOException {
        //Init TProxy socket
        log.info("init tproxy listener: {}:{}",bind,port);
        socket = new TProxyServerSocket();
        socket.initTProxy(bind, port, backlog);
        init=true;
    }

    /***
     * Thread run method
     */
    public void run() {
        if (!init) {
            throw new RuntimeException("Must call initServer() first!!!");
        }
       //set some important socket options
       log.info("tproxy listener started...");

       //we are running until halted is signalled
       running = true;
       while (!halted) {
          try {
                  //don't trust my users ;-)
                  final TProxyInterceptedSocket client = socket.accepProxy();
                  log.debug("accepted client: {}", client);
                  newClient(client);
                } catch (final IOException io) {
                    if (!halted) {
                      onIOError(io);
                    }
                } catch (final libc.ErrnoException errno) {
                    log.error("libc IO error:",errno);
                } catch (final Throwable oeps) {
                  log.error("Unexpected error:", oeps);
                }
       }
       //close server socket
       if (socket != null && !socket.isClosed()) {
           try {
               socket.close();
           } catch (final IOException ignore) {}
       }
       socket=null;
       running = false;
       halted=false;
       log.info("TProxy listener halted");
    }

    /***
     * Method called when new connection is accepted, this must be implemented by our users
     * @param client
     * @throws IOException
     */
    public abstract void newClient(TProxyInterceptedSocket client) throws IOException;

    /***
     * Method called when Listener loop see a IOException
     * @param io
     */
    public abstract void onIOError(IOException io);
}
