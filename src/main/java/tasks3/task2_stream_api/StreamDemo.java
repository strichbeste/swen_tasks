package tasks3.task2_stream_api;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("sample.txt");
        Files.writeString(path,
            "java is free software\n" +
            "this line has nothing\n" +
            "free and open source\n" +
            "spring is not free to support\n" +
            "hello world\n" +
            "free beer does not exist\n" +
            "free time is rare\n"
        );

        // stream: lesen -> filtern -> sortieren -> limit -> ausgeben
        Files.lines(path)
            .filter(line -> line.contains("free"))
            .sorted()
            .limit(5)
            .forEach(System.out::println);
    }
}
