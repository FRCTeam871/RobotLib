package com.team871.hid;

public class AxisButton extends HIDButton {

    HIDAxis axis;
    float threshold;
    boolean invert = false;

    public AxisButton(HIDAxis axis, float activateThreshold){
        this(axis, activateThreshold, false);
    }

    public AxisButton(HIDAxis axis, float activateThreshold, boolean invert){
        super(new ButtonID() {
            @Override
            public String getName() {
                return axis.getId().getName() + "Button";
            }

            @Override
            public int getId() {
                return 0;
            }
        }, null);
        this.axis = axis;
        this.invert = invert;
        this.threshold = activateThreshold;
    }

    @Override
    public boolean getRaw(){
        return invert ? axis.getValue() < threshold : axis.getValue() > threshold;
    }

}
