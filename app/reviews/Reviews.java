// BookNova - reviews service (Java)
// A tiny HTTP service that returns book reviews as JSON.

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Reviews {

    // Set via env var so we can run v1 (no ratings), v2, v3 later.
    static final String VERSION = System.getenv().getOrDefault("SERVICE_VERSION", "v1");

    static final String REVIEWS_JSON =
        "{\"id\":\"1\",\"reviews\":["
        + "{\"reviewer\":\"Reviewer1\",\"text\":\"An unbelievable masterpiece!\"},"
        + "{\"reviewer\":\"Reviewer2\",\"text\":\"Absolutely fun and entertaining.\"}"
        + "],\"version\":\"" + VERSION + "\"}";

    public static void main(String[] args) throws Exception {
        int port = 9080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/health", exchange -> respond(exchange, "{\"status\":\"ok\"}"));
        server.createContext("/reviews", exchange -> respond(exchange, REVIEWS_JSON));

        server.setExecutor(null);
        System.out.println("reviews service (" + VERSION + ") listening on " + port);
        server.start();
    }

    static void respond(com.sun.net.httpserver.HttpExchange exchange, String body) throws java.io.IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        byte[] bytes = body.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
