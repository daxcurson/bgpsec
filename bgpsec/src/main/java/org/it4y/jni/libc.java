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
package org.it4y.jni;

import org.it4y.jni.linux.socket;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;

public final class libc {

    /* i'm on little endian ? */
    static final boolean isLittleEndian=ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);

    /*
     * this class wraps libc in_addr (ipv4 address) from C lib
     *
     */

    public static int ntohi(final int address) {
        final int[] ab=new int[4];
        if (isLittleEndian) {
            ab[0] = address >> 24 & 0x00ff;
            ab[1] = address >> 16 & 0x00ff;
            ab[2] = address >> 8 & 0x00ff;
            ab[3] = address & 0x00ff;
            return (ab[3]<<24)+(ab[2]<<16)+(ab[1]<<8)+ ab[0];
        } else {
           return address;
        }
    }

    public static int htoni(final int address) {
        final int[] ab=new int[4];
        if (isLittleEndian) {
            ab[0] = address >> 24 & 0x00ff;
            ab[1] = address >> 16 & 0x00ff;
            ab[2] = address >> 8 & 0x00ff;
            ab[3] = address & 0x00ff;
            return (ab[3]<<24)+(ab[2]<<16)+(ab[1]<<8)+ ab[0];
        } else {
            return address;
        }
    }

    public static short ntohs(final short x) {
        final int[] ab=new int[2];
        if (isLittleEndian) {
            ab[0] = x >> 8 & 0x00ff;
            ab[1] = x & 0x00ff;
            return (short) (((short)(ab[1]<<8)|(short)ab[0]) & 0xffff);
        } else {
            return x;
        }
    }
    public static short ntohs(final byte h, final byte l) {
        if (isLittleEndian) {
            return (short) ((short)(h<<8)|((short)l) &0xff);
        } else {
            return (short) (((short)(l<<8)|(short)h) & 0xffff);
        }
    }

    public static short htons(final short x) {
        final int[] ab=new int[2];
        if (isLittleEndian) {
            ab[0] = x >> 8 & 0x00ff;
            ab[1] = x & 0x00ff;
            return (short) (((short)(ab[1]<<8)|(short)ab[0]) & 0xffff);
        } else {
            return x;
        }
    }

    public static long ntohl(final long address) {
        final long[] ab= new long[8];
        if (isLittleEndian) {
            ab[0] = address >> 56 & 0x00ff;
            ab[1] = address >> 48 & 0x00ff;
            ab[2] = address >> 40  & 0x00ff;
            ab[3] = address >> 32 & 0x00ff;
            ab[4] = address >> 24 & 0x00ff;
            ab[5] = address >> 16 & 0x00ff;
            ab[6] = address >> 8  & 0x00ff;
            ab[7] = address       & 0x00ff;
            return (ab[6]<<52)+(ab[6]<<48)+(ab[5]<<40)+(ab[4]<<32)+(ab[3]<<24)+(ab[2]<<16)+(ab[1]<<8)+ ab[0];
        } else {
            return address;
        }
    }

    public static long htonl(final long address) {
        final long[] ab= new long[8];
        if (isLittleEndian) {
            ab[0] = address >> 56 & 0x00ff;
            ab[1] = address >> 48 & 0x00ff;
            ab[2] = address >> 40  & 0x00ff;
            ab[3] = address >> 32 & 0x00ff;
            ab[4] = address >> 24 & 0x00ff;
            ab[5] = address >> 16 & 0x00ff;
            ab[6] = address >> 8  & 0x00ff;
            ab[7] = address       & 0x00ff;
            return (ab[6]<<52)+(ab[6]<<48)+(ab[5]<<40)+(ab[4]<<32)+(ab[3]<<24)+(ab[2]<<16)+(ab[1]<<8)+ ab[0];
        } else {
            return address;
        }
    }

    public static InetAddress toInetAddress(final int address) {
        InetAddress x = null;
        final byte[] ab = new byte[4];
        ab[0] = (byte) (address >> 24 & 0x00ff);
        ab[1] = (byte) (address >> 16 & 0x00ff);
        ab[2] = (byte) (address >> 8 & 0x00ff);
        ab[3] = (byte) (address & 0x00ff);
        //Why throw this will it is not going to happen ?
        try {
            x = Inet4Address.getByAddress(ab);
        } catch (final UnknownHostException ignore) {
        }
        return x;
    }

    public static class in_addr {
        public int address;
        private InetAddress cached_address;

        public in_addr() {
        }

        public in_addr(final int address) {
            this.address = address;
        }

        public InetAddress toInetAddress() {
            if (cached_address == null) {
                synchronized (this) {
                    if (cached_address == null) {
                        /* ok java uses shitty constructions so we need to hack here */
                        /* Inet4Address.getByAddress() will do reverse of this. */
                        /* a private constructor(int address,int port) exist but it is private */
                        cached_address = libc.toInetAddress(address);
                    }
                }
            }
            return cached_address;
        }

        public String toString() {
            return String.format("0x%08x", (long)address & 0xffffffffL);
        }
    }

    /*
     * this class wraps libc sockaddr_in structure from C lib
     *
     */
    public static class sockaddr_in {
        public static final int sockaddr_in_size=16;
        //Note : storage is based on libc structure !!!
        public short family;
        public short port;
        public int address;

        //cache this result as it is expensive
        private InetAddress cached_address;

        //Used by jni code
        private sockaddr_in() {}

        public sockaddr_in(final int address, final short port, final short family) {
            this.address = address;
            this.port = port;
            this.family = family;
        }

        /**
         * Use this Constuctor when receiving data from kernel in network order.
         * the constructor takes care of converting network -> host order
         * @param sockaddr
         */
        public sockaddr_in(final byte[] sockaddr) {
            address = ((0xFF & sockaddr[4]) << 24) | ((0xFF & sockaddr[5]) << 16) |
                            ((0xFF & sockaddr[6]) << 8)  |  (0xFF & sockaddr[7]);
            port = ntohs(sockaddr[3],sockaddr[2]);
            family = ntohs(sockaddr[1],sockaddr[0]);
        }

        public sockaddr_in(final byte[] sockaddr, final boolean ntohs) {
            address = ((0xFF & sockaddr[4]) << 24) | ((0xFF & sockaddr[5]) << 16) |
                    ((0xFF & sockaddr[6]) << 8)  |  (0xFF & sockaddr[7]);
            if (ntohs) {
                port = ntohs(sockaddr[2], sockaddr[3]);
                family = ntohs(sockaddr[0], sockaddr[1]);
            } else {
                port = ntohs(sockaddr[3], sockaddr[2]);
                family = ntohs(sockaddr[1], sockaddr[0]);
            }

        }

        public sockaddr_in(final InetAddress ipv4) {
            final byte[]addr= ipv4.getAddress();
            address = ((0xFF & addr[0]) << 24) | ((0xFF & addr[1]) << 16) |
                           ((0xFF & addr[2]) << 8)  |  (0xFF & addr[3]);
            family = socket.AF_INET;
            port =0;
        }

        public sockaddr_in(final InetSocketAddress ipv4) {
            final byte[]addr= ipv4.getAddress().getAddress();
            address = ((0xFF & addr[0]) << 24) | ((0xFF & addr[1]) << 16) |
                           ((0xFF & addr[2]) << 8)  |  (0xFF & addr[3]);
            family = socket.AF_INET;
            port = (short) ipv4.getPort();
        }

        public InetAddress toInetAddress() {
            if (cached_address == null) {
                synchronized (this) {
                    if (cached_address == null) {
                        /* ok java uses shitty constructions so we need to hack here */
                        /* Inet4Address.getByAddress() will do reverse of this. */
                        /* a private constructor(int address,int port) exist but it is private */
                        cached_address = libc.toInetAddress(address);
                    }
                }
            }
            return cached_address;
        }

        public InetSocketAddress toInetSocketAddress() {
            return new InetSocketAddress(toInetAddress(),(int)port&0xffff);
        }

        /**
         * Use this function to provide sockaddr_in as byte[]
         * this method also takes care of host->network order fixes
         * @return
         */
        public byte[] array(final boolean htons) {
            final ByteBuffer bb = ByteBuffer.allocate(sockaddr_in_size);
            if (htons) {
                bb.putShort(htons(family));
                bb.putShort(htons(port));
            } else {
                bb.putShort(family);
                bb.putShort(port);
            }
            bb.putInt(address);
            return bb.array();
        }
        /**
         * Use this function to provide sockaddr_in as byte[]
         * this method also takes care of host->network order fixes
         * @return
         */
        public byte[] array() {
            return array(false);
        }

        public String toString() {
            return String.format("0x%08x:%d", (long)address & 0xffffffffL,(int)port&0xffff);
        }


    }

    /* convert to java Date */
    public static Date Timeval2Date(final int tv_sec, final int tv_usec) {
          return new Date(((long)tv_sec&0xffffffff)*1000L + (((long)tv_usec&0xffffffff)/1000L)); //java only has msec
    }

    /* based on kernel 3.12 */
    public static class tcp_info {
        public static final int struct_size_latest = 104; //check this in 2.6 kernels

        public byte tcpi_state;        //u8
        public byte tcpi_ca_state;     //u8
        public byte tcpi_retransmits;  //u8
        public byte tcpi_probes;       //u8
        public byte tcpi_backoff;      //u8
        public byte tcpi_options;      //u8
        public byte tcpi_snd_wscale;   //u8
        public byte tcpi_rcv_wscale;   //u8

        public int tcpi_rto;          //u32
        public int tcpi_ato;          //u32
        public int tcpi_snd_mss;      //u32
        public int tcpi_rcv_mss;      //u32
        public int tcpi_unacked;      //u32
        public int tcpi_sacked;       //u32
        public int tcpi_lost;         //u32
        public int tcpi_retrans;      //u32
        public int tcpi_fackets;      //u32

        /* Times. */
        public int tcpi_last_data_sent;     //u32
        public int tcpi_last_ack_sent;      //u32
        public int tcpi_last_data_recv;     //u32
        public int tcpi_last_ack_recv;      //u32

        /* Metrics. */
        public int tcpi_pmtu;             //u32
        public int tcpi_rcv_ssthresh;     //u32
        public int tcpi_rtt;              //u32
        public int tcpi_rttvar;           //u32
        public int tcpi_snd_ssthresh;     //u32
        public int tcpi_snd_cwnd;         //u32
        public int tcpi_advmss;           //u32
        public int tcpi_reordering;       //u32
        public int tcpi_rcv_rtt;          //u32
        public int tcpi_rcv_space;         //u32

        /* counters */
        int tcpi_total_retrans;           //u32

        /* this method is called by jni code to set data */
        /*            Signature: (BBBBBBBBIIIIIIIIIIIIIIIIIIIIIIII)V */

        public void setdata(
                final byte tcpi_state,
                final byte tcpi_ca_state,
                final byte tcpi_retransmits,
                final byte tcpi_probes,
                final byte tcpi_backoff,
                final byte tcpi_options,
                final byte tcpi_snd_wscale,
                final byte tcpi_rcv_wscale,
                final int tcpi_rto,
                final int tcpi_ato,
                final int tcpi_snd_mss,
                final int tcpi_rcv_mss,
                final int tcpi_unacked,
                final int tcpi_sacked,
                final int tcpi_lost,
                final int tcpi_retrans,
                final int tcpi_fackets,
                final int tcpi_last_data_sent,
                final int tcpi_last_ack_sent,
                final int tcpi_last_data_recv,
                final int tcpi_last_ack_recv,
                final int tcpi_pmtu,
                final int tcpi_rcv_ssthresh,
                final int tcpi_rtt,
                final int tcpi_rttvar,
                final int tcpi_snd_ssthresh,
                final int tcpi_snd_cwnd,
                final int tcpi_advmss,
                final int tcpi_reordering,
                final int tcpi_rcv_rtt,
                final int tcpi_rcv_space,
                final int tcpi_total_retrans
        ) {
            //System.out.print("setData");
            this.tcpi_state = tcpi_state;
            this.tcpi_ca_state = tcpi_ca_state;
            this.tcpi_retransmits = tcpi_retransmits;
            this.tcpi_probes = tcpi_probes;
            this.tcpi_backoff = tcpi_backoff;
            this.tcpi_options = tcpi_options;
            this.tcpi_snd_wscale = tcpi_snd_wscale;
            this.tcpi_rcv_wscale = tcpi_rcv_wscale;
            this.tcpi_rto = tcpi_rto;         //usec
            this.tcpi_ato = tcpi_ato;         //usec ack timeout
            this.tcpi_snd_mss = tcpi_snd_mss;
            this.tcpi_rcv_mss = tcpi_rcv_mss;
            this.tcpi_unacked = tcpi_unacked;
            this.tcpi_sacked = tcpi_sacked;
            this.tcpi_lost = tcpi_lost;
            this.tcpi_retrans = tcpi_retrans;
            this.tcpi_fackets = tcpi_fackets;
            this.tcpi_last_data_sent = tcpi_last_data_sent;   //msec since start
            this.tcpi_last_ack_sent = tcpi_last_ack_sent;     //
            this.tcpi_last_data_recv = tcpi_last_data_recv;   //msec
            this.tcpi_last_ack_recv = tcpi_last_ack_recv;     //msec
            this.tcpi_pmtu = tcpi_pmtu;
            this.tcpi_rcv_ssthresh = tcpi_rcv_ssthresh;
            this.tcpi_rtt = tcpi_rtt;    //usec
            this.tcpi_rttvar = tcpi_rttvar;    //usec
            this.tcpi_snd_ssthresh = tcpi_snd_ssthresh;
            this.tcpi_snd_cwnd = tcpi_snd_cwnd;
            this.tcpi_advmss = tcpi_advmss;
            this.tcpi_reordering = tcpi_reordering;
            this.tcpi_rcv_rtt = tcpi_rcv_rtt;       //usec
            this.tcpi_rcv_space = tcpi_rcv_space;
            this.tcpi_total_retrans = tcpi_total_retrans;  //total retransmits

        }

        public String toString() {
            final StringBuilder s = new StringBuilder(1024);
            s.append("state:").append((short)tcpi_state & (short)0xff).append(' ');
            s.append("ca_state:").append((short)tcpi_ca_state & (short)0xff).append("\n ");
            s.append("retransmits:").append((short)tcpi_retransmits & (short)0xff).append(' ');
            s.append("probes:").append((short)tcpi_probes & (short)0xff).append(' ');
            s.append("backoff:").append((short)tcpi_backoff & (short)0xff).append(' ');
            s.append("options:").append((short)tcpi_options & (short)0xff).append("\n ");
            s.append("snd_wscale:").append((short)tcpi_snd_wscale & (short)0xff).append(' ');
            s.append("rcv_wscale:").append((short)tcpi_rcv_wscale & (short)0xff).append(' ');
            s.append("rto:").append((long)tcpi_rto & 0xffffffffL).append(' ');
            s.append("ato:").append((long)tcpi_ato & 0xffffffffL).append(' ');
            s.append("snd_mss:").append((long)tcpi_snd_mss & 0xffffffffL).append(' ');
            s.append("rcv_mss:").append((long)tcpi_rcv_mss & 0xffffffffL).append("\n ");
            s.append("unacked:").append((long)tcpi_unacked & 0xffffffffL).append(' ');
            s.append("sacked:").append((long)tcpi_sacked & 0xffffffffL).append(' ');
            s.append("lost:").append((long)tcpi_lost & 0xffffffffL).append(' ');
            s.append("retrans:").append((long)tcpi_retrans & 0xffffffffL).append(' ');
            s.append("fackets:").append((long)tcpi_fackets & 0xffffffffL).append("\n ");
            s.append("last_data_sent:").append((long)tcpi_last_data_sent & 0xffffffffL).append(' ');
            s.append("last_ack_sent:").append((long)tcpi_last_ack_sent & 0xffffffffL).append("\n ");
            s.append("last_data_recv:").append((long)tcpi_last_data_recv & 0xffffffffL).append(' ');
            s.append("last_ack_recv:").append((long)tcpi_last_ack_recv & 0xffffffffL).append("\n ");
            s.append("pmtu:").append((long)tcpi_pmtu & 0xffffffffL).append(' ');
            s.append("rcv_ssthresh:").append((long)tcpi_rcv_ssthresh & 0xffffffffL).append(' ');
            s.append("rtt:").append((long)tcpi_rtt & 0xffffffffL).append(' ');
            s.append("rttvar:").append((long)tcpi_rttvar & 0xffffffffL).append(' ');
            s.append("snd_ssthresh:").append((long)tcpi_snd_ssthresh & 0xffffffffL).append(' ');
            s.append("snd_cwnd:").append((long)tcpi_snd_cwnd & 0xffffffffL).append(' ');
            s.append("advmss:").append((long)tcpi_advmss & 0xffffffffL).append("\n ");
            s.append("reordering:").append((long)tcpi_reordering & 0xffffffffL).append(' ');
            s.append("rcv_rtt:").append((long)tcpi_rcv_rtt & 0xffffffffL).append(' ');
            s.append("rcv_space:").append((long)tcpi_rcv_space & 0xffffffffL).append("\n ");
            s.append("total_retrans:").append((long)tcpi_total_retrans & 0xffffffffL);
            return s.toString();
        }
    }

    /*
     * Throw errno results with exceptions
     */
    public static class ErrnoException extends Exception {

        private final int errno;

        public ErrnoException(final int errno) {
            this.errno = errno;
        }

        public ErrnoException(final String message, final int errno) {
            super(message);
            this.errno = errno;
        }

        public int getErrno() {
            return errno;
        }

        public String toString() {
            final StringBuilder s= new StringBuilder(100);
            s.append(getMessage()).append(" errno: ").append(errno);
            return s.toString();
        }
    }

}
