import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

// einfacher echo-service auf port 9988
// gibt die erste zeile des requests mit prefix "ECHO: " zurueck
// dasselbe pattern wie im mrp-projekt verwendet!
public class EchoServer {
    public static void main(String[] args) throws Exception {
        // http-server erstellen – gleiche api wie im mrp-projekt
        HttpServer server = HttpServer.create(new InetSocketAddress(9988), 0);

        server.createContext("/", exchange -> {
            // kompletten request zur konsole ausgeben
            System.out.println("--- request ---");
            System.out.println("methode: " + exchange.getRequestMethod());
            System.out.println("uri: " + exchange.getRequestURI());
            System.out.println("headers: " + exchange.getRequestHeaders().entrySet());

            // request-body lesen
            String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            System.out.println("body: " + body);

            // erste zeile des body extrahieren und echo-prefix anhaengen
            String firstLine = body.lines().findFirst().orElse("(leer)");
            String response = "ECHO: " + firstLine;

            // antwort senden
            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        });

        server.start();
        System.out.println("echo server laeuft auf http://localhost:9988");
    }
}
