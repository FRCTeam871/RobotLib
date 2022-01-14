package com.team871.io.actuator;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import java.util.Collection;

public class CombinedMotorController implements MotorController {

    private Collection<MotorController> motors;

    public CombinedMotorController(Collection<MotorController> motors){
        this.motors = motors;
    }

    @Override
    public void set(double speed) {
        motors.stream().forEach(MotorController -> MotorController.set(speed));
    }

    @Override
    public double get() {
        return motors.iterator().next().get();
    }

    @Override
    public void setInverted(boolean isInverted) {
        motors.stream().forEach(MotorController -> MotorController.setInverted(isInverted));
    }

    @Override
    public boolean getInverted() {
        return motors.iterator().next().getInverted();
    }

    @Override
    public void disable() {
        motors.stream().forEach(MotorController -> MotorController.disable());
    }

    @Override
    public void stopMotor() {
        motors.stream().forEach(MotorController -> MotorController.stopMotor());
    }
}
