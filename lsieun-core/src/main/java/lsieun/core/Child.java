package lsieun.core;

import lsieun.core.internal.SmartChild;

public interface Child {
    String getName();

    public static Child getSmartChild() {
        return new SmartChild("Tom", 10);
    }
}
