package com.ironman.common.introspection;

/**
 * @author jsingh on 6/7/13 at 3:25 PM
 */
public class ThreadContext extends ThreadLocal {

    private ControllerData controllerData = new ControllerData();

    //add here other containers


    public ControllerData getControllerData() {
        return controllerData;
    }

    public void setControllerData(ControllerData controllerData) {
        this.controllerData = controllerData;
    }
}
