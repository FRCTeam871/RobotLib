package com.team871.hid;

public class StaticHIDButton extends HIDButton {

    final boolean val;

    public StaticHIDButton(boolean val){
        super(new ButtonID() {
            @Override
            public String getName() {
                return "StaticHIDButton:" + val;
            }

            @Override
            public int getId() {
                return 0;
            }
        }, null);
        this.val = val;
    }

    public StaticHIDButton(){
        this(false);
    }

    @Override
    public boolean getRaw(){
        return val;
    }

}
