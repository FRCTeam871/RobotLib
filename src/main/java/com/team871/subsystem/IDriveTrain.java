package com.team871.subsystem;

public interface IDriveTrain {

    void setHeadingHoldEnabled(boolean enabled);

    boolean getHeadingHoldEnabled();

    void setHeadingHold(double heading);

    //TODO: look at how the PID from WPILib does this
    void setHeadingTolerance(double tolerance);

    boolean isAtHeading();

    void drive(double speed, double heading);

    //TODO: add brake modes
    void stop();

}
