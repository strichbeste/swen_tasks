package tasks1.task2_datatypes;

public class DatatypesDemo {
    public static void main(String[] args) {

        // primitive datentypen – in java fixe groessen (plattformunabhaengig)
        byte   b = 127;
        short  s = 32000;
        int    i = 2_000_000;      // underscore seit java 7 erlaubt
        long   l = 9_000_000_000L; // L suffix pflicht
        float  f = 3.14f;          // f suffix pflicht
        double d = 3.141592653;
        boolean flag = true;       // kein int wie in c++
        char   c = 'A';            // 16 bit unicode (c++: 8 bit ascii)

        // implizites casting: kleiner -> groesser (kein datenverlust)
        double fromInt = i;

        // explizites casting: groesser -> kleiner (datenverlust moeglich!)
        int fromDouble = (int) 9.99; // 9 – nachkommastellen abgeschnitten, kein runden!
        System.out.println("cast double->int: " + fromDouble);

        // autoboxing: primitive -> wrapper-objekt
        Integer boxed = 42;   // int -> Integer automatisch
        int unboxed = boxed;  // Integer -> int automatisch

        // wrapper erlaubt null – primitive nicht!
        Integer nullVal = null;
        // int crash = nullVal; // -> nullpointerexception!

        // format-strings
        String name = "Brenner";
        int age = 21;
        double gpa = 1.5;
        System.out.println(String.format("name: %s, alter: %d, gpa: %.2f", name, age, gpa));
        System.out.printf("kompakt: %s ist %d jahre alt%n", name, age);

        // string konvertierung
        int parsed = Integer.parseInt("42");
        String back = String.valueOf(parsed);

        // typfalle: integer division
        System.out.println("5/2 als int: " + (5 / 2));          // 2
        System.out.println("5/2 als double: " + (5.0 / 2));     // 2.5
    }
}
