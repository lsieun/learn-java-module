package lsieun.utils;

import java.lang.annotation.Annotation;
import java.lang.module.ModuleDescriptor;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModuleUtils {
    public static String describe(Module module) {
        ModuleDescriptor md = module.getDescriptor();
        if (md == null) {
            return "UNNAMED module {}";
        }

        String annotations = Arrays
                .stream(module.getDeclaredAnnotations())
                .map(Annotation::annotationType)
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("@[%s]%n", annotations);
        fm.format("%s module %s @ %s%n", md.modifiers(), md.name(), toString(md.rawVersion()));
        fm.format("{%n");
        fm.format("    requires %s%n", md.requires());
        fm.format("    exports  %s%n", md.exports());
        fm.format("    opens    %s%n", md.opens());
        fm.format("    contains %s%n", md.packages());
        fm.format("    main     %s%n", toString(md.mainClass()));
        fm.format("}");

        return sb.toString();
    }

    private static String toString(Optional<?> optional) {
        return optional.isPresent() ? optional.get().toString() : "[]";
    }

    public static String describe(ModuleLayer layer) {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);

        Set<Module> modules = layer.modules();
        for (Module m : modules) {
            fm.format("%s%n%n", describe(m));
        }
        return sb.toString();
    }

    public static boolean isModulePresent(String moduleName) {
        return searchRootModuleLayer()
                .findModule(moduleName)
                .isPresent();
    }

    private static ModuleLayer searchRootModuleLayer() {
        return getCallerClass().getModule().getLayer();
    }

    private static Class<?> getCallerClass() {
        return StackWalker
                .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(stack -> stack.filter(
                        frame -> frame.getDeclaringClass() != ModuleUtils.class)
                        .findFirst()
                        .map(StackWalker.StackFrame::getDeclaringClass)
                        .orElseThrow(IllegalStateException::new)
                );
    }
}
