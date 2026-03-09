// demo: primitive vs. komplexe datentypen, boxing, casting, format-strings
public class DatatypesDemo {

    public static void main(String[] args) {

        // --- primitive datentypen (simple types) ---
        // in c++ wuerde man direkt auf hardware-groesse setzen, in java fixe groessen garantiert
        byte  b  = 127;          // 8 bit, -128 bis 127
        short s  = 32000;        // 16 bit
        int   i  = 2_000_000;   // 32 bit – underscore erlaubt seit java 7 (lesbarkeit)
        long  l  = 9_000_000_000L; // 64 bit, L suffix noetig!
        float f  = 3.14f;        // 32 bit floating point, f suffix noetig
        double d = 3.141592653;  // 64 bit – standard fuer dezimalzahlen
        boolean flag = true;     // kein int wie in c++, nur true/false
        char c  = 'A';           // 16 bit unicode – in c++ nur 8 bit ascii

        // --- casting (typumwandlung) ---
        // implizit: kleiner -> groesser (kein datenverlust)
        double fromInt = i;  // int -> double automatisch

        // explizit: groesser -> kleiner (datenverlust moeglich!)
        int fromDouble = (int) 9.99; // ergebnis: 9 – nachkommastellen abgeschnitten, kein runden!
        System.out.println("cast double->int: " + fromDouble); // 9

        // --- autoboxing / unboxing ---
        // boxing: primitive -> wrapper-objekt (automatisch)
        Integer boxed = 42;         // autoboxing: int -> Integer
        int unboxed = boxed;        // unboxing: Integer -> int

        // wichtig: wrapper-klassen ermoeglichen null und methoden
        Integer nullVal = null;     // int kann nicht null sein, Integer schon!
        // int crash = nullVal;     // -> nullpointerexception beim unboxing!

        // wrapper in collections noetig (generics brauchen objekte)
        java.util.List<Integer> list = new java.util.ArrayList<>();
        list.add(10);  // autoboxing passiert hier automatisch

        // --- string-formatierung ---
        String name = "Brenner";
        int age = 21;
        double gpa = 1.5;

        // format-string mit String.format – aehnlich wie printf in c
        String formatted = String.format("name: %s, alter: %d, gpa: %.2f", name, age, gpa);
        System.out.println(formatted);

        // alternativ: printf direkt (kein newline bei %s)
        System.out.printf("kompakt: %s ist %d jahre alt%n", name, age);

        // string-konvertierung
        String numStr = "42";
        int parsed = Integer.parseInt(numStr);   // string -> int
        String backToString = String.valueOf(parsed); // int -> string
        System.out.println("geparst: " + parsed + ", zurueck: " + backToString);

        // --- rechenbeispiel mit typfallen ---
        int a = 5, x = 2;
        System.out.println("int/int: " + (a / x));          // 2 – integer division!
        System.out.println("double/int: " + ((double)a / x)); // 2.5 – cast noetig
    }
}
