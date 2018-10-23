package com.team871.hid;

import edu.wpi.first.wpilibj.Joystick;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * An extension of Joystick which provides
 * additional functionality including individual axis deadbanding, mapped
 * deadbands, and button type emulation for all buttons.
 * 
 * @author not Jack Langhorn
 * 
 */
public class GenericJoystick<ButtonIDType extends ButtonID, AxisIDType extends AxisID> extends Joystick {
    Map<ButtonID, HIDButton> buttons;
    Map<AxisID, HIDAxis> axes;
    
    int[] POVs; // Each element is a POV (joypad) on the controller.
    
    /**
     * Creates a new Enhanced Controller on the specified port.
     * @param port the port number of the controller
     */
    public GenericJoystick(int port, Collection<ButtonIDType> buttonIDs, Collection<AxisIDType> axisIDs) {
        super(port);
        
        buttons = buttonIDs.stream().map(id -> new HIDButton(id, this)).collect(Collectors.toMap(HIDButton::getId, Function.identity()));
        axes     = axisIDs.stream().map(id -> new HIDAxis(id, this)).collect(Collectors.toMap(HIDAxis::getId, Function.identity()));
    }
    
    public HIDButton getButton(ButtonIDType id) {
        return buttons.get(id);
    }
    
    public HIDAxis getAxis(AxisIDType id) {
        return axes.get(id);
    }

    /*
     * Getters (Overloaded)
     */

    /**
     * @deprecated Use getEnhancedPOV.
     */
    public int getPOV(int pov) {
        return super.getPOV();
    }

    /**
     * @deprecated Use getEnhancedPOV.
     */
    public int getPOV() {
        return super.getPOV(0);
    }
    
    public POVDirections getEnhancedPOV() {
        return getEnhancedPOV(0);
    }
    
    public POVDirections getEnhancedPOV(int pov) {
        POVDirections dir = POVDirections.NEUTRAL;

        switch(super.getPOV(pov)) {
            case 0:
                dir = POVDirections.UP;
                break;
            case 45:
                dir = POVDirections.UP_RIGHT;
                break;
            case 90:
                dir = POVDirections.RIGHT;
                break;
            case 135:
                dir = POVDirections.DOWN_RIGHT;
                break;
            case 180:
                dir = POVDirections.DOWN;
                break;
            case 225:
                dir = POVDirections.DOWN_LEFT;
                break;
            case 270:
                dir = POVDirections.LEFT;
                break;
            case 315:
                dir = POVDirections.UP_LEFT;
                break;
            case -1:
                dir = POVDirections.NEUTRAL;
                break;
        }
        return dir;

    }

}
