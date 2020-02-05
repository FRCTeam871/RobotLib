package com.team871.io.sensor;


import com.team871.navigation.Coordinate;
import com.team871.navigation.DistanceUnit;

/**
 * Interface for a sesnsor that measure robots displacement from initialization
 *  @author Team871-TPfaffe
 */
public interface IDisplacementSensor {

    /**
     * @param unit of measure requested for displacement
     * @return total displacement in the unit requested.
     */
    Coordinate getDisplacement(DistanceUnit unit);


    /**
     * @param unit of measure requested for displacement
     * @return velocity in unit/s
     */
    Coordinate getVelocity(DistanceUnit unit);

    /**
     * rests total displacement sensor back to 0
     */
    void resetSensor();
}
