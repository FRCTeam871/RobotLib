package com.team871.hid;

import edu.wpi.first.util.sendable.Sendable;

// TODO: make this abstract class
public interface IAxis extends Sendable {

    /**
     * @return double containing the raw value of the axis.
     */
    double getRaw();

    /**
     *
     * @return Double containing the value of the axis.
     */
    double getValue();
}