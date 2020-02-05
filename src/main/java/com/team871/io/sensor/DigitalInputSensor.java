package com.team871.io.sensor;

import edu.wpi.first.wpilibj.DigitalInput;

public class DigitalInputSensor extends DigitalInput implements DigitalSensor {

    public DigitalInputSensor(int port){
        super(port);
    }

    @Override
    public boolean get() {
        return super.get();
    }
}
