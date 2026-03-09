package bad;

// fat controller: der controller enthaelt zu viel logik
// code smell: klasse die zu viel weiss und zu viel macht
import java.sql.*;
public class UserController {
    private Connection conn;

    public UserController(Connection conn) { this.conn = conn; }

    // problem: validierung + datenbankzugriff + passwort-hashing + email direkt im controller
    public String register(String username, String password) {
        // validierung gehoert in einen validator
        if (username == null || username.length() < 3) return "fehler: name zu kurz";
        if (password == null || password.length() < 6) return "fehler: passwort zu kurz";

        // hashing gehoert in einen security-service
        String hashed = password + "_hashed";

        // db-zugriff gehoert ins repository
        try {
            var stmt = conn.prepareStatement("INSERT INTO users VALUES (?,?)");
            stmt.setString(1, username);
            stmt.setString(2, hashed);
            stmt.executeUpdate();
        } catch (SQLException e) { return "db fehler"; }

        // email gehoert in emailservice
        System.out.println("email gesendet an " + username);
        return "ok";
    }
}
