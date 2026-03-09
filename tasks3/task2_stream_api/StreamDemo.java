import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

// demo: stream api – datei lesen, filtern, sortieren, ausgeben
public class StreamDemo {
    public static void main(String[] args) throws Exception {
        // beispiel-textdatei erstellen
        Path path = Path.of("sample.txt");
        Files.writeString(path,
            "java is free software\n" +
            "this line has nothing\n" +
            "free and open source\n" +
            "spring is not free to support\n" +
            "hello world\n" +
            "free beer does not exist\n" +
            "free time is rare\n" +
            "test line\n"
        );

        // alle zeilen lesen und stream-api anwenden
        List<String> result = Files.lines(path)          // stream aus datei
            .filter(line -> line.contains("free"))       // nur zeilen mit "free"
            .sorted()                                    // alphabetisch sortieren
            .limit(5)                                    // erste 5
            .collect(Collectors.toList());               // in liste sammeln

        System.out.println("zeilen mit 'free' (sortiert, max 5):");
        result.forEach(System.out::println);
    }
}
