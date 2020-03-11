/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.team871.io.actuator;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class DoubleSolenoid871 implements ISolenoid {
    private final DoubleSolenoid solenoid;

    public DoubleSolenoid871(int fwdChannel, int revChannel) {        
        this.solenoid = new DoubleSolenoid(fwdChannel, revChannel);
    }

    @Override
    public void set(Value val) {
        switch(val) {
            case On:
            case Forward:
            solenoid.set(DoubleSolenoid.Value.kForward);
            break;

            case Off:
            solenoid.set(DoubleSolenoid.Value.kOff);
            break;

            case Reverse:
            solenoid.set(DoubleSolenoid.Value.kReverse);
            break;
        }
    }

    @Override
    public Value get() {
        switch(solenoid.get()) {
            case kOff:
            return Value.Off;

            case kForward:
            return Value.Forward;

            case kReverse:
            return Value.Reverse;
        }

        return null;
    }

}
