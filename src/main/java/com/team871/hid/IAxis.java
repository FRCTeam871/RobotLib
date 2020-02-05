package com.team871.hid;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

// TODO: make this abstract class
public interface IAxis extends PIDSource, Sendable {

    /**
     * @return double containing the raw value of the axis.
     */
    double getRaw();

    /**
     *
     * @return Double containing the value of the axis.
     */
    double getValue();

    /**
     * By default, calls to this method are ignored.<br>
     * Implementations may override this if they want to add functionality.
     */
    @Override
    @Deprecated
    default void setPIDSourceType(PIDSourceType pidSource) {
        //ignore
    }

    /**
     * Returns PIDSourceType.kDisplacement by default.<br>
     * Implementations may override this if they want to use PIDSourceType.kRate
     */
    @Override
    default PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
    }

    @Override
    default double pidGet() {
        return getValue();
    }


    @Override
    default String getName() {
        return "IAxis " + hashCode();
    }

    @Override
    default void setName(String name) {
        // no
    }

    @Override
    default String getSubsystem() {
        return "IAxis";
    }

    @Override
    default void setSubsystem(String subsystem) {
        // no
    }

    @Override
    default void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("raw", this::getRaw, value -> {});
        builder.addDoubleProperty("value", this::getValue, value -> {});
    }
}