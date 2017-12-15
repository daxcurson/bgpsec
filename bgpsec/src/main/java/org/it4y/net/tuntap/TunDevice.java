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

package org.it4y.net.tuntap;

import org.it4y.jni.libc;
import org.it4y.jni.tuntap;

public class TunDevice extends tuntap {

    public TunDevice() {
    }

    public TunDevice(final String device) {
        this.device = device;
    }

    public void open() throws libc.ErrnoException {
        //open on name or let kernel chouse
        if (device != null) {
            openTunDevice(device);
        } else {
            openTun();
        }
    }

    public String getDevice() {
        return device;
    }
    public int getFd() {return fd;}

}
