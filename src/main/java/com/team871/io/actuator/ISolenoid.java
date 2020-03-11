package com.team871.io.actuator;

public interface ISolenoid {
    enum Value {
        On, 
        Off,
        Forward, 
        Reverse;
    }

    /**
     * Set the current value of the solenoid
     */
    void set(Value val);

    /**
     * Get the current value of the solenoid
     */
    Value get();
}