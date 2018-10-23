package com.team871.hid.joystick;

import com.team871.hid.ButtonID;

/**
 * Maps all the physical buttons on the XBox 360 controller to thier button
 * numbers in software.
 * 
 * @author Jack Langhorn
 *
 */
public enum XBoxButtons implements ButtonID{
    /**
     * The A button.
     */
    A(1),
    /**
     * The B button.
     */
    B(2),
    /**
     * The X button.
     */
    X(3),
    /**
     * The Y button.
     */
    Y(4),
    /**
     * The left bumper located on the back of the controller.
     */
    LBUMPER(5),
    /**
     * The right bumper located on the back of the controller.
     */
    RBUMPER(6),
    /**
     * The "Back" button located on the front of the controller.
     */
    BACK(7),
    /**
     * The "Start" button located on the front of the controller.
     */
    START(8),
    /**
     * The button which is activated by pushing the left stick down into the
     * controller.
     */
    LEFTSTICK(9),
    /**
     * The button which is activated by pushing the right stick down into the
     * controller.
     */
    RIGHTSTICK(10);

    /**
     * the value
     */
    private int value;

    private XBoxButtons(int num) {
        value = num;
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
