package com.team871.io.peripheral;

public class I2CEndPoint implements EndPoint {

    final byte addr;

    public I2CEndPoint(final byte address){
        this.addr = address;
    }

    public byte getAddress(){
        return addr;
    }

}
