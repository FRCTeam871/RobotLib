package com.team871.io.peripheral;

public class StringPacket implements IPacket{

    String payload;
    int length;

    public StringPacket(int length) {
        this.length = length;
    }

    public StringPacket(String payload) {
        this.payload = payload;
    }

    @Override
    public byte[] serialize() {
        return payload.getBytes();
    }

    @Override
    public void deserialize(byte[] data) {
        payload = new String(data);
    }

    @Override
    public int getSize() {
        return payload == null ? length : payload.length();
    }

}
