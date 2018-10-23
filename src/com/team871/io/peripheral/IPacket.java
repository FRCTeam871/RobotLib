package com.team871.io.peripheral;

public interface IPacket {
    
    byte[] serialize();
    void deserialize(byte[] data);
    
    int getSize();
    
}
