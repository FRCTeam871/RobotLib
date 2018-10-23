package com.team871.io.peripheral;

public interface ICommunicationsInterface {

    void send(int addr, IPacket packet);

    default void send(IPacket packet) {
        send(0, packet);
    }

    default void read(IPacket emptyPacket) {
        read(0, emptyPacket);
    }

    void read(int addr, IPacket emptyPacket);

}
