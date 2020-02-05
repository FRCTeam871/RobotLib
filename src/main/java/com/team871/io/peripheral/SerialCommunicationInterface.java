package com.team871.io.peripheral;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class SerialCommunicationInterface implements ICommunicationsInterface {

    final SerialPort port;

    public SerialCommunicationInterface() {
        this(9600, Port.kMXP);
    }

    public SerialCommunicationInterface(int baud, Port port) {
        this.port = new SerialPort(baud, port);
    }

    public void send(EndPoint addr, IPacket packet) {
        byte[] data = packet.serialize();
        port.write(data, data.length);
        port.flush();
    }

    public void read(EndPoint addr, int read, IPacket emptyPacket) {
        emptyPacket.deserialize(port.read(read));
    }

    @Override
    public int numAvailable(EndPoint addr) {
        return port.getBytesReceived();
    }

    @Override
    public boolean numAvailableSupported() {
        return true;
    }

}
