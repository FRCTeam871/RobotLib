package com.team871.hid;

public class ConstantButton implements IButton {

    final boolean val;
    private ButtonTypes mode;

    public ConstantButton(boolean val){
        this.val = val;
    }

    public ConstantButton(){
        this(false);
    }

    @Override
    public boolean getRaw(){
        return val;
    }

    /**
     * This modifies the value based upon the mode, acting as if the button is held in a constant state.
     * If the mode is RISING or FALLING it will modify the value to be false.
     * If the mode is MOMENTARY or TOGGLE it will return the value.
     *
     * @return the value as modified by the button mode.
     */
    @Override
    public boolean getValue() {
        return (mode == ButtonTypes.RISING || mode == ButtonTypes.FALLING)? false: val;
    }

    @Override
    public void setMode(ButtonTypes mode) {
        this.mode = mode;
    }

    @Override
    public ButtonTypes getMode() {
        return mode;
    }

}
