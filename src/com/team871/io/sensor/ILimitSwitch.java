package com.team871.io.sensor;


/**
 * Applied to all limit switches
 * @author Team871
 *
 */
public interface ILimitSwitch {

    /**
     *
     * @return If limit has been reached
     */
    boolean isAtLimit();
}
