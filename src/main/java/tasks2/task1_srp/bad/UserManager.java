package tasks2.task1_srp.bad;

// SRP VERLETZUNG: eine klasse macht zu viel
// verantwortungen: db-zugriff + auth-logik + email-versand
public class UserManager {
    private java.sql.Connection conn;

    public UserManager(java.sql.Connection conn) { this.conn = conn; }

    public boolean login(String username, String password) {
        try {
            var stmt = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            if (stmt.executeQuery().next()) {
                sendWelcomeEmail(username); // email gehoert nicht hierher
                return true;
            }
        } catch (Exception e) {
            System.err.println("db fehler: " + e.getMessage());
        }
        return false;
    }

    // grund 1 fuer aenderung: email-inhalt
    private void sendWelcomeEmail(String username) {
        System.out.println("sende email an: " + username);
    }

    // grund 2 fuer aenderung: db-schema
    public void saveUser(String username, String password) {
        try {
            var stmt = conn.prepareStatement("INSERT INTO users VALUES (?,?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("db fehler: " + e.getMessage());
        }
    }
}
