package com.team871.hid.joystick;

import com.team871.hid.ButtonID;

/**
 * Maps all the physical buttons on the XBox 360 controller to thier button
 * numbers in software.
 * 
 * @author Dave
 *
 */
public enum SaitekButtons implements ButtonID{

    TRIGGER_1(1),

    FIRE(2),

    A(3),

    B(4),

    C(5),

    LOW_TRIGGER(6),

    /**
     * The I button.
     */
    I(31),
    /**
     * The E button.
     */
    E(8),
    /**
     * The D button.
     */
    D(7),
    /**
     * The Mouse button.
     */
    MOUSE(16),
    /**
     * The function button.
     */
    FUNCTION(32),
    /**
     * The hat down button.
     */
    HAT_DOWN(26),
    /**
     * The hat up button.
     */
    HAT_UP(24),
    /**
     * The hat left button.
     */
    HAT_LEFT(27),
    /**
     * The hat right button.
     */
    HAT_RIGHT(25),
    SOUND_L_UP(9),
    SOUND_L_DOWN(10),
    SOUND_M_UP(11),
    SOUND_M_DOWN(12),
    SOUND_R_UP(13),
    SOUND_R_DOWN(14);
    
    /**
     * the value
     */
    private int value;

    SaitekButtons(int num) {
        value = num;
    }

    /**
     * Returns the mapping to the button number in software.
     * 
     * @return int containing the button number
     */
    int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public int getId() {
        return value;
    }
}
