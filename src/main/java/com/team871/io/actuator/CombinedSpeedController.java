package com.team871.io.actuator;

import edu.wpi.first.wpilibj.SpeedController;
import java.util.Collection;
import java.util.function.Consumer;

public class CombinedSpeedController implements SpeedController {

    private Collection<SpeedController> motors;

    public CombinedSpeedController(Collection<SpeedController> motors){
        this.motors = motors;
    }

    @Override
    public void set(double speed) {
        motors.stream().forEach(speedController -> speedController.set(speed));
    }

    @Override
    public double get() {
        return motors.iterator().next().get();
    }

    @Override
    public void setInverted(boolean isInverted) {
        motors.stream().forEach(speedController -> speedController.setInverted(isInverted));
    }

    @Override
    public boolean getInverted() {
        return motors.iterator().next().getInverted();
    }

    @Override
    public void disable() {
        motors.stream().forEach(speedController -> speedController.disable());
    }

    @Override
    public void stopMotor() {
        motors.stream().forEach(speedController -> speedController.stopMotor());
    }

    @Override
    public void pidWrite(double output) {
        motors.stream().forEach(speedController -> speedController.pidWrite(output));
    }
}
