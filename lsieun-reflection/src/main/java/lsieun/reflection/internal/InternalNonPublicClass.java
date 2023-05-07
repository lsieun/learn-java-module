package lsieun.reflection.internal;

class InternalNonPublicClass {
    public static void testPublicStaticMethod() {
        System.out.println("OK");
    }

    private static void testPrivateStaticMethod() {
        System.out.println("OK");
    }
}
