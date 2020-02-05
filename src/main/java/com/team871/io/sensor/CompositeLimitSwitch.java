package com.team871.io.sensor;

import java.util.Arrays;
import java.util.List;

public class CompositeLimitSwitch implements ILimitSwitch {

    private List<ILimitSwitch> limits;

    public CompositeLimitSwitch(List<ILimitSwitch> limits) {
        this.limits = limits;
    }

    public CompositeLimitSwitch(ILimitSwitch... limits) {
        this.limits = Arrays.asList(limits);
    }

    @Override
    public boolean isAtLimit() {
        return limits.stream().anyMatch(ILimitSwitch::isAtLimit);
    }

    @Override
    public boolean get() {
        return limits.stream().anyMatch(ILimitSwitch::get);
    }
}
