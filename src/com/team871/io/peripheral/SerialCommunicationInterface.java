package com.team871.io.peripheral;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class SerialCommunicationInterface implements ICommunicationsInterface {

    SerialPort port;

    public SerialCommunicationInterface() {
        this(9600, Port.kMXP);
    }

    public SerialCommunicationInterface(int baud, Port port) {
        this.port = new SerialPort(baud, port);
    }

    @Override
    public void send(int addr, IPacket packet) {
        byte[] data = packet.serialize();
        port.write(data, data.length);
        port.flush();
    }

    @Override
    public void read(int addr, IPacket emptyPacket) {
        emptyPacket.deserialize(port.read(emptyPacket.getSize()));
    }

}
