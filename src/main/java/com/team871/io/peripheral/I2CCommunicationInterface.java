package com.team871.io.peripheral;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

import java.nio.ByteBuffer;

public class I2CCommunicationInterface implements ICommunicationsInterface {

    final I2C port;
    final int address;

    public I2CCommunicationInterface(int address) {
        port = new I2C(Port.kMXP, address);
        this.address = address;
    }

    @Override
    public void send(EndPoint addr, IPacket packet) {
        final ByteBuffer byteBuffer = ByteBuffer.allocate(packet.getSize() + 1);
        byteBuffer.put(((I2CEndPoint)addr).getAddress());
        byteBuffer.put(packet.serialize());
        port.writeBulk(byteBuffer.array());
    }

    @Override
    public void read(EndPoint addr, int size, IPacket emptyPacket) {
        byte[] buf = new byte[emptyPacket.getSize()];
        //inverted because read() returns false on success
        if(!port.read(((I2CEndPoint)addr).getAddress(), buf.length, buf)) {
            emptyPacket.deserialize(buf);
        }
    }

    @Override
    public int numAvailable(EndPoint addr) {
        return 0;
    }

    @Override
    public boolean numAvailableSupported() {
        return false;
    }

}
