package lsieun.unnamed;

//import sun.misc.Unsafe;

import lsieun.reflection.export.ExportedPublicClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UnNamedRun {

    public static void main(String[] args) throws Throwable {
        Class<?> clazz = ExportedPublicClass.class;
        Method method = clazz.getDeclaredMethod("testPublicStaticMethod");
        method.setAccessible(true);
        method.invoke(null);

//        ExportedPublicClass.testPublicStaticMethod();
    }

    private static void printModule(Object obj) {
        Class<?> clazz = obj.getClass();
        Module module = clazz.getModule();
        System.out.println(obj + ": " + module);
    }

    private static void getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field f = clazz.getDeclaredField(fieldName);
        f.setAccessible(true);
        Object value = f.get(obj);
        System.out.println(value);
    }

//    public static void disableWarning() {
//        try {
//            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafeField.setAccessible(true);
//            Unsafe theUnsafe = (Unsafe) theUnsafeField.get(null);
//
//            Class<?> clazz = Class.forName("jdk.internal.module.IllegalAccessLogger");
//            Field loggerField = clazz.getDeclaredField("logger");
//            theUnsafe.putObjectVolatile(clazz, theUnsafe.staticFieldOffset(loggerField), null);
//        } catch (Exception ignored) {
//        }
//    }
}
