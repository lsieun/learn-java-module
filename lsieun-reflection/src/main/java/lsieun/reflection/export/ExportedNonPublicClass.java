package lsieun.reflection.export;

class ExportedNonPublicClass {
    public static void testPublicStaticMethod() {
        System.out.println("OK");
    }

    private static void testPrivateStaticMethod() {
        System.out.println("OK");
    }
}
