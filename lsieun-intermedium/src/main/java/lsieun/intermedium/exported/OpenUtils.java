package lsieun.intermedium.exported;

import lsieun.reflection.export.ExportedPublicClass;

import java.lang.module.ModuleDescriptor;
import java.util.Formatter;
import java.util.Set;

public class OpenUtils {
    public static void addOpens(Class<?> clazz) {
        Module currentModule = OpenUtils.class.getModule();
        Module srcModule = ExportedPublicClass.class.getModule();
        Module targetModule = clazz.getModule();

        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("current module: %s%n", currentModule.getName());
        fm.format("source  module: %s%n", srcModule.getName());
        fm.format("target  module: %s%n", targetModule.getName());
        System.out.println(sb);

        srcModule.addOpens("lsieun.reflection.internal", targetModule);
        System.out.println("addOpens Complete");
        Set<ModuleDescriptor.Opens> opens = srcModule.getDescriptor().opens();
        System.out.println("opens: " + opens);
    }
}
