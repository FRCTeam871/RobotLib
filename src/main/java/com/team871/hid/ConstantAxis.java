package com.team871.hid;

public class ConstantHIDAxis implements IAxis {

    double val;
    AxisID id;

    public ConstantHIDAxis(double val){

        this.val = val;

        id = new AxisID() {
            @Override
            public String getName() {
                return "ConstantAxis=" + val;
            }

            @Override
            public int getId() {
                return 0;
            }
        };

    }

    @Override
    public double getRaw(){
        return val;
    }

    @Override
    public double getValue() {
        return val;
    }

    @Override
    public AxisID getId() {
        return id;
    }

}
