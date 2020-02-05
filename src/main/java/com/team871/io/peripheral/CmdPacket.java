package com.team871.io.peripheral;

import java.nio.ByteBuffer;

public class CmdPacket implements IPacket {

    int id;
    int size;

    @Override
    public byte[] serialize() {
        ByteBuffer buf = ByteBuffer.wrap(new byte[8]);
        buf.putInt(id);
        buf.putInt(size);
        return buf.array();
    }

    @Override
    public void deserialize(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data);
        id = buf.getInt();
        size = buf.getInt();
    }

    @Override
    public int getSize() {
        return 8;
    }

    public int getCommandId() {
        return id;
    }

    public int getPayloadSize() {
        return size;
    }

}
