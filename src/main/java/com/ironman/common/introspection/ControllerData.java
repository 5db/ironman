package com.ironman.common.introspection;

/**
 * @author jsingh on 6/7/13 at 3:25 PM
 */
public class ControllerData {

    /**
     * Used for timing controller methods, stores timestamp
     * at the start of an operation.
     */
    private long startTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
