package com.team871.io.actuator;


import com.team871.io.sensor.ILimitSwitch;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * This class is able to control the motor with the use of limit switches
 * @author Team871
 */
public class LimitedSpeedController implements SpeedController {
    private SpeedController motor;

    private ILimitSwitch positive;
    private ILimitSwitch negative;
    
    /**
     * yolo mode
     */
    private boolean ignoreLimits = false;
    
    /**
     * @param motor The speed controller being limited
     * @param upper The upper limit switch
     * @param lower The lower limit switch
     * @param inverted Determines if the speed controller output should be negated
     */
    public LimitedSpeedController(SpeedController motor, ILimitSwitch upper, ILimitSwitch lower, boolean inverted) {
        this.motor = motor;
        this.positive = upper;
        this.negative = lower;
        
        motor.setInverted(inverted);
    }

    /**
     * The motor is not inverted by default
     * @param motor The speed controller being limited
     * @param positive The upper limit switch
     * @param negative The lower limit switch
     */
    public LimitedSpeedController(SpeedController motor, ILimitSwitch positive, ILimitSwitch negative) {
        this.motor = motor;
        this.positive = positive;
        this.negative = negative;

        motor.setInverted(false);
    }

    @Override
    public void pidWrite(double output) {
        set(output);
    }

    @Override
    public double get() {
        return motor.get();
    }

    @Override
    public void set(double speed) {
        if ((positive.isAtLimit() && (speed > 0.0)) || (negative.isAtLimit() && (speed < 0.0))) {
            motor.set(0.0);
        } else {
            motor.set(speed);
        }
    }

    @Override
    public void setInverted(boolean isInverted) {
        motor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return motor.getInverted();
    }

    @Override
    public void disable() {
        motor.disable();
    }

    @Override
    public void stopMotor() {
        motor.stopMotor();
    }
    
    /**
     * @return returns the upper limit
     */
    public ILimitSwitch getPositiveLimit() {
        return positive;
    }
    
    /**
     * @return returns the lower limit
     */
    public ILimitSwitch getNegativeLimit() {
        return negative;
    }
    
    /**
     * Are limits disabled?
     */
    public boolean isYoloMode() {
        return ignoreLimits;
    }

    /**
     * Enable or disable all limits -- Hence YOLO mode.
     */
    public void setYoloMode(boolean shouldYolo) {
        ignoreLimits = shouldYolo;
    }
    
}