package sample;

import lsieun.reflection.export.ExportedPublicClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelloWorld {
    public static void main(String[] args) {

    }

    public void test1() throws Exception {
        Module currentModule = Main.class.getModule();
        System.out.println("Current Module: " + currentModule.getName());

        Class<?> clazz = ExportedPublicClass.class;
        Module targetModule = clazz.getModule();
        System.out.println("Target  Module: " + targetModule.getName());

        Method method = clazz.getDeclaredMethod("testPrivateStaticMethod");
        method.invoke(null);
    }

    public void test2() throws Exception {
        Module currentModule = Main.class.getModule();
        System.out.println("Current Module: " + currentModule.getName());

        Class<?> clazz = ExportedPublicClass.class;
        Module targetModule = clazz.getModule();
        System.out.println("Target  Module: " + targetModule.getName());

        Method method = clazz.getDeclaredMethod("testPrivateStaticMethod");
        method.setAccessible(true);
        method.invoke(null);
    }

    public void test3() throws Exception {
        Module currentModule = Main.class.getModule();
        System.out.println("Current Module: " + currentModule.getName());

        String str = String.valueOf("100");
        Module targetModule = String.class.getModule();
        System.out.println("Target  Module: " + targetModule.getName());

        getFieldValue(str, "coder");
        getFieldValue(str, "hash");
        getFieldValue(str, "serialVersionUID");
    }

    private static void getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field f = clazz.getDeclaredField(fieldName);
        f.setAccessible(true);
        Object value = f.get(obj);
        System.out.println(value);
    }
}
