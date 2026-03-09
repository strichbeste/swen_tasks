package tasks2.task4_fat_controller.bad;

// FAT CONTROLLER – code smell: zu viel logik im controller
import java.sql.*;
public class UserController {
    private Connection conn;
    public UserController(Connection conn) { this.conn = conn; }

    public String register(String username, String password) {
        // validierung gehoert in validator
        if (username == null || username.length() < 3) return "name zu kurz";
        if (password == null || password.length() < 6) return "passwort zu kurz";
        // hashing gehoert in security-service
        String hashed = password + "_hashed";
        // db-zugriff gehoert ins repository
        try {
            var stmt = conn.prepareStatement("INSERT INTO users VALUES (?,?)");
            stmt.setString(1, username); stmt.setString(2, hashed);
            stmt.executeUpdate();
        } catch (SQLException e) { return "db fehler"; }
        // email gehoert in emailservice
        System.out.println("email gesendet an " + username);
        return "ok";
    }
}
