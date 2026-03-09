import java.io.*;
import java.nio.file.*;
import java.util.*;

// demo: user-eingaben lesen bis leere zeile, in datei schreiben
public class FileIODemo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        System.out.println("zeilen eingeben (leere zeile zum beenden):");

        // einlesen bis leere zeile
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break; // leere zeile = abbruch
            lines.add(line);
        }

        // in datei schreiben
        Path output = Path.of("inputs.txt");
        Files.write(output, lines);

        System.out.println(lines.size() + " zeilen in inputs.txt gespeichert");
    }
}
