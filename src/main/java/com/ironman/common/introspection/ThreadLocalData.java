package com.ironman.common.introspection;

/**
 * Subclass of ThreadLocal so we can set initialValue() here instead of
 * in an anonymous class. An anonymous class is ok the thread-specific
 * data is initialized in a single place, however this class is intended
 * to support containers (such as controller data and others) and thus
 * the proper place to initialize the thread local data is here, not in
 * controllers or elsewhere.
 *
 * @author jsingh on 6/7/13 at 3:26 PM
 */
public class ThreadLocalData extends ThreadLocal<ThreadContext> {

    @Override
    protected ThreadContext initialValue() {
        return new ThreadContext();
    }

    /**
     * Convenience method, to avoid callers go through the extra get()
     *
     * @return
     */
    public ControllerData getControllerData() {
        return get().getControllerData();
    }
}