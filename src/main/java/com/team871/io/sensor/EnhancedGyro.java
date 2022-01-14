package com.team871.io.sensor;


import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C.Port;

//TODO: make a more generic gyro interface
public class EnhancedGyro extends AHRS{

    public EnhancedGyro(Port i2c_port_id) {
        super(i2c_port_id);
        // TODO Auto-generated constructor stub
    }

    @Override public float getYaw() {
        return super.getYaw() % 360;
    }
}
