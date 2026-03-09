package tasks3.task6_echo_server;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

// echo-service auf port 9988 – gleiche api wie im mrp-projekt
public class EchoServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9988), 0);

        server.createContext("/", exchange -> {
            // request zur konsole ausgeben
            System.out.println("methode: " + exchange.getRequestMethod());
            System.out.println("uri:     " + exchange.getRequestURI());

            String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            System.out.println("body:    " + body);

            // erste zeile mit echo-prefix zurueckgeben
            String firstLine = body.lines().findFirst().orElse("(leer)");
            String response  = "ECHO: " + firstLine;

            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) { os.write(bytes); }
        });

        server.start();
        System.out.println("echo server laeuft auf http://localhost:9988");
    }
}
