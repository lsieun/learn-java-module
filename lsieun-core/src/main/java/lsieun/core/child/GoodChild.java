package lsieun.core.child;

public class GoodChild {
    public final String name;
    public final int age;

    public GoodChild(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("GoodChild{name=%s, age=%d}", name, age);
    }
}
