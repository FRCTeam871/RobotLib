package com.team871.hid;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Joystick;

public class HIDAxis implements MappableAxis {

    private double deadband = 0.0;
    private double scaling = 1;
    private double translation = 0;

    private final AxisID id;
    private final Joystick stickJoy;

    HIDAxis(AxisID id, Joystick stickjoy) {
        this.id = id;
        this.stickJoy = stickjoy;
    }

    /**
     * @param dead the new deadband value. Must be in the range [0,1].
     */
    public void setDeadband(double dead) {
        if(dead < 0 || dead > 1) {
            throw new IllegalArgumentException("Axis deadband must be in the range [0,1]!");
        }

        deadband = dead;
    }
    
    /**
     * @return double between 0 and 1 containing the raw value of the axis.
     */
    public double getRaw() {
        return stickJoy.getRawAxis(id.getId());
    }
    
    /**
     * Reads the value of the specified axis after deadbanding and mapping. The deadbanded
     * values are linearly mapped to new values such that at the deadband, the
     * value is 0, but at full power the value is 1. This prevents jerky
     * readings when the raw value hovers around the deadband.
     * If a mapping is provided the return value will be mapped accordingly.
     * <p>
     * If Trigger is read, the value returned will be the result from
     * subtracting the value of the left trigger from the right trigger. This
     * emulates both triggers affecting the same axis.
     *
     * @return Double containing the value of the axis.
     */
    public double getValue() {
        /*
         * Gets the value of the joystick axis after deadbanding. Uses the
         * following equation to create a linear graph mapping deadbanded
         * joystick data to output: y=((x-1)/(1-d))+1. This means that if the
         * axis is at or below the deadband, it will return 0.0, but after that
         * it begins increasing from 0.0, but with a steeper sloping line so
         * that at the deadband it is 0.0, but at full forward it is 1.0. This
         * prevents the robot from jerking and gives the driver more control.
         * The following may be used for parabolic mapping:
         * y=(((x-d)^2)/((1-d)^2)).
         */
        final double raw = getRaw();
        double outputValue;

        if (deadband == 0.0) {
            outputValue = raw;
        }else if ((raw > -deadband) && (raw < deadband)) {
            outputValue = 0.0;
        }else if (raw <= 0) {
            outputValue = (1 / (1 - deadband)) * raw + (deadband / (1 - deadband));
        }else {
            outputValue = (1 / (1 - deadband)) * raw - (deadband / (1 - deadband));
        }

        // (((output - iMin) / (iMax-iMin)) * (oMax - oMin)) + oMin
        return (outputValue * scaling) + translation;
    }

    public AxisID getId() {
        return id;
    }

    public double getDeadband() {
        return deadband;
    }

    @Override
    public void setInputRange(double min, double max) {
        //no
    }

    @Override
    public void setOutputRange(double min, double max) {
        scaling = (max - min) / (1 - (-1));
        translation = max - scaling;
    }

    @Override
    public void initSendable(SendableBuilder builder) {

    }
}
