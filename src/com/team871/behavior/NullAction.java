package com.team871.behavior;

/**
 * Is a dummy action that donts
 *  @author Team871-TPfaffe
 */
public class NullAction implements IAction {
    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public void abort() {
    }

    @Override
    public void execute() {
    }

    @Override
    public void init() {
    }

    @Override
    public void halt() {
    }

    @Override
    public String toString() {
        return "{ Nothing }";
    }
}
