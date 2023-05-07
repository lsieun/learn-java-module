package sample;

import lsieun.intermedium.exported.OpenUtils;
import java.lang.reflect.Method;

public class Main {
    private static final System.Logger logger = System.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        Module currentModule = Main.class.getModule();

        OpenUtils.addOpens(Main.class);

        Class<?> clazz = Class.forName("lsieun.reflection.internal.InternalNonPublicClass");
        Module targetModule = clazz.getModule();

        Method method = clazz.getDeclaredMethod("testPrivateStaticMethod");
        method.setAccessible(true);
        method.invoke(null);

    }
}