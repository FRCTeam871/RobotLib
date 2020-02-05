package com.team871.hid;

public class AxisButton extends HIDButton {

    HIDAxis axis;
    float threshold;

    public AxisButton(HIDAxis axis, float activateThreshold){
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
        this.threshold = activateThreshold;
    }

    @Override
    public boolean getRaw(){
        return axis.getValue() > threshold;
    }

}
