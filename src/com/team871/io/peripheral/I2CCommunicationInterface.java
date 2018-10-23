package com.team871.io.peripheral;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class I2CCommunicationInterface implements ICommunicationsInterface {

    I2C port;

    public I2CCommunicationInterface() {
        port = new I2C(Port.kMXP, 0);
    }

    @Override
    public void send(int addr, IPacket packet) {
        port.writeBulk(packet.serialize());
    }

    @Override
    public void read(int addr, IPacket emptyPacket) {
        byte[] buf = new byte[emptyPacket.getSize()];
        if(!port.read(addr, buf.length, buf)) {
            emptyPacket.deserialize(buf);
        }
    }

}
