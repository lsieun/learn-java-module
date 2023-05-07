package sample;

//import lsieun.core.child.GoodChild;
//import lsieun.utils.ChildUtils;
//import lsieun.utils.DateUtils;


//import java.lang.instrument.Instrumentation;
import java.lang.module.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) throws Exception {
//        String date = DateUtils.getDate();
//        System.out.println(date);
//        GoodChild child = ChildUtils.getChild();
//        System.out.println(child);

//        Class<?> clazz = Instrumentation.class;
//        Module module = clazz.getModule();
//        System.out.println(module);
//        System.out.println(module.isNamed());
//        ModuleLayer layer = module.getLayer();
//        System.out.println(layer);
//        ModuleDescriptor descriptor = module.getDescriptor();
//        System.out.println(descriptor);

//        Set<Module> importing = new HashSet<>(), exporting = new HashSet<>();
//        ModuleLayer.boot().modules().forEach(module -> {
//            if (module.getDescriptor().isAutomatic()) {
//                importing.add(module);
//            } else if (!module.getDescriptor().isOpen()) {
//                exporting.add(module);
//            }
//        });
//
//        System.out.println(importing);
//
//        System.out.println(exporting);

//        GoodChild child = ChildUtils.getChild();
//        System.out.println(child);

        Class<?> clazz = Class.forName("lsieun.utils.PrintUtils");
        System.out.println(clazz.getName());
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        for (Method m : declaredMethods) {
//            m.setAccessible(true);
//            m.invoke(null);
            String methodName = m.getName();
            System.out.println(methodName);
        }
    }
}
