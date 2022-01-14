package com.team871.hid;

import edu.wpi.first.util.sendable.SendableBuilder;

public class ConstantAxis implements MappableAxis {

    double val;
    private double scaling = 1;
    private double translation = 0;

    public ConstantAxis(double val){

        this.val = val;

    }

    @Override
    public double getRaw(){
        return val;
    }

    @Override
    public double getValue() {
        return (val * scaling) + translation;
    }

    @Override
    public void setInputRange(double min, double max) {

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
