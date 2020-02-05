package com.team871.hid;

import edu.wpi.first.wpilibj.Joystick;

/**
 * @author not Jack Langhorn
 */
public class HIDButton implements IButton{

    private boolean prevRaw;
    private boolean curEmulated; //TODO: better name

    private ButtonTypes mode;

    private final ButtonID id;
    private final Joystick stickJoy;

    HIDButton(ButtonID id, Joystick stickjoy) {
        this.id = id;
        this.stickJoy = stickjoy;
    }

    public boolean getRaw() {
        return stickJoy.getRawButton(id.getId());
    }

    //TODO: add debouncing over time
    public boolean getValue() {
        final boolean curVal = getRaw();
        
        switch (getMode()) {
            case TOGGLE:
                if (curVal && (curVal != prevRaw)) {
                    curEmulated = !curEmulated;
                }
                break;
            case RISING:
                curEmulated = curVal && (curVal != prevRaw);
                break;
            case FALLING:
                curEmulated = !curVal && (curVal != prevRaw);
                break;
            case MOMENTARY:
                // use raw
                break;
        }
        
        prevRaw = curVal;

        return curEmulated;
    }

    public ButtonTypes getMode() {
        return mode;
    }

    public void setMode(ButtonTypes mode) {
        this.mode = mode;
    }

    public ButtonID getId() {
        return id;
    }

}


//public class GenericJoystick<TB extends ButtonType, TA extends AxisType>
