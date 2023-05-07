package lsieun.utils;

class PrintUtils {
    private static final int data = 10;

    private PrintUtils() {
    }

    static void sayPackageOnly() {
        System.out.println("Package Only");
    }

    private static void sayPrivate() {
        System.out.println("Private");
    }
}
