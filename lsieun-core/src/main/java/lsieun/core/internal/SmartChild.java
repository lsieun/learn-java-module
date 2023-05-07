package lsieun.core.internal;

import lsieun.core.Child;

public class SmartChild implements Child {
    private final String name;
    private final int age;

    public SmartChild(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
