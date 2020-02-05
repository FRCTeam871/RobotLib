package com.team871.hid;

public interface IButton {
    /**
     *
     * @return gets raw value of a button.
     */
    boolean getRaw();

    /**
     * @return the value of the button according to the {@link ButtonTypes ButtonType}.
     * @see ButtonTypes
     */
    boolean getValue();

    void setMode(ButtonTypes mode);

    ButtonTypes getMode();
}
