package tasks3.task3_file_io;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileIODemo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        System.out.println("zeilen eingeben (leere zeile beendet):");
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            lines.add(line);
        }

        Files.write(Path.of("inputs.txt"), lines);
        System.out.println(lines.size() + " zeilen in inputs.txt gespeichert");
    }
}
