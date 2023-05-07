package lsieun.reflection.open;

class OpenedNonPublicClass {
    public static void testPublicStaticMethod() {
        System.out.println("OK");
    }

    private static void testPrivateStaticMethod() {
        System.out.println("OK");
    }
}
