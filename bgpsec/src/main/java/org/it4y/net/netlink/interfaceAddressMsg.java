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

import org.it4y.jni.linux.if_address;

import java.nio.ByteBuffer;

/**
 * Created by luc on 1/2/14.
 */
public class interfaceAddressMsg extends NlMessage {
    final byte ifa_family;
    final byte ifa_prefixlen;  /* The prefix length            */
    final byte ifa_flags;      /* Flags                        */
    final byte ifa_scope;      /* Address scope                */
    final byte ifa_index;      /* Link index                   */

    public interfaceAddressMsg(final ByteBuffer msg) {
        super(msg);
        //dummy
        ifa_family = msg.get();
        ifa_prefixlen = msg.get();
        ifa_flags = msg.get();
        ifa_scope = msg.get();
        ifa_index = msg.get();
        //padding
        msg.get();
        msg.get();
        msg.get();
        parseRTAMessages(msg);
    }

    @Override
    public int getRTAIndex(final String name) {
        for (final int key :  if_address.IFA_NAMES.keySet()) {
            if (name.equals(if_address.IFA_NAMES.get(key))) {
                return key;
            }
        }
        return -1;
    }

    @Override
    public RTAMessage createRTAMessage(final int position, final ByteBuffer msg) {
        return new AddressRTAMessages(position, msg);
    }

    @Override
    public String toString() {
        final StringBuilder s = new StringBuilder(128);
        s.append(super.toString());
        s.append("fam: ").append(ifa_family);
        s.append(" flags:0x").append(Integer.toHexString((int) ifa_flags & 0xff));
        s.append(" idx:").append(ifa_index);
        s.append(" scope:0x").append(Integer.toHexString((int) ifa_scope & 0xff));
        s.append(" prefixlen:").append(ifa_prefixlen);
        s.append('\n');
        //dump rta messages
        for (final RTAMessage r : rtaMessages.values()) {
            if (r.getType() == if_address.IFA_LABEL) {
                s.append(' ').append(r.toString()).append(' ').append(r.getString()).append('\n');
            } else if (r.getType() == if_address.IFA_BROADCAST) {
                s.append(' ').append(r.toString()).append(' ').append(r.getInetAddress()).append('\n');
            } else if (r.getType() == if_address.IFA_ADDRESS) {
                s.append(' ').append(r.toString()).append(' ').append(r.getInetAddress()).append('\n');
            } else {
                s.append(' ').append(r.toString()).append('\n');
            }
        }
        return s.toString();
    }

    public byte getAddresFamily() {
        return ifa_family;
    }

    public byte getAddressPrefixlen() {
        return ifa_prefixlen;
    }

    public byte getAddressFlags() {
        return ifa_flags;
    }

    public byte getAddressScope() {
        return ifa_scope;
    }

    public byte getInterfaceIndex() {
        return ifa_index;
    }

}
