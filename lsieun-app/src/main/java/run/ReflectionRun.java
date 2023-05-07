package run;

//import lsieun.reflection.export.ExportedPublicClass;
import sample.HelloWorld;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public class ReflectionRun {
    public static void main(String[] args) throws Exception {
//        String className = "sample.HelloWorld";
//        String methodName = "testCallerClass";
//        invokeMethod(className, methodName, false);

//        Class<?> clazz = ExportedPublicClass.class;
//        Module module = clazz.getModule();
//        Set<String> packages = module.getPackages();
//        System.out.println(packages);

    }

    private static void invokeMethod(String className, String methodName, boolean flag) throws Exception {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName);
        if (flag) {
            method.setAccessible(flag);
        }
        method.invoke(null);
    }

    @SuppressWarnings("unchecked")
    public static void disableAccessWarnings() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception ignored) {
        }
    }
}
