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

package org.it4y.net.netlink;

import org.it4y.jni.linux.if_link;

import java.nio.ByteBuffer;

/**
 * Created by luc on 1/2/14.
 */
public class InterfaceRTAMessages extends RTAMessage {

    public InterfaceRTAMessages(final int pos, final ByteBuffer buffer) {
        super(pos, buffer);
    }

    public String getRTAName() {
        return if_link.IFLA_NAMES.get((int)type&0xffff);
    }
}