package com.team871.hid;

import edu.wpi.first.wpilibj.Joystick;

public class CompoundAxis extends HIDAxis {

    private HIDAxis posAxis, negAxis;

    CompoundAxis(AxisID id, HIDAxis posAxis, HIDAxis negAxis, Joystick stickjoy) {
        super(id, stickjoy);
        this.posAxis = posAxis;
        this.negAxis = negAxis;
    }

    @Override
    public double getRaw() {
        return posAxis.getRaw() - negAxis.getRaw();
    }

}
