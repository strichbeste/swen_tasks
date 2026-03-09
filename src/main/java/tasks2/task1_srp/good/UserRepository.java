package tasks2.task1_srp.good;

import java.sql.*;

// SRP eingehalten: nur datenbankzugriff
public class UserRepository {
    private Connection conn;
    public UserRepository(Connection conn) { this.conn = conn; }

    public boolean exists(String username, String password) throws SQLException {
        var stmt = conn.prepareStatement("SELECT 1 FROM users WHERE username=? AND password=?");
        stmt.setString(1, username);
        stmt.setString(2, password);
        return stmt.executeQuery().next();
    }

    public void save(String username, String password) throws SQLException {
        var stmt = conn.prepareStatement("INSERT INTO users(username,password) VALUES(?,?)");
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.executeUpdate();
    }
}
