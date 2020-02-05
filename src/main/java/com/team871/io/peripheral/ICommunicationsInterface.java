package com.team871.io.peripheral;

public interface ICommunicationsInterface {

    void send(EndPoint addr, IPacket packet);

    void read(EndPoint addr, int read, IPacket emptyPacket);

    int numAvailable(EndPoint addr);

    boolean numAvailableSupported();
}
