package bad;

// VORHER: verletzung des srp – diese klasse macht zu viel
// srp: eine klasse soll nur einen grund haben sich zu aendern
// hier: authentifizierung + datenbankzugriff + email-versand in einer klasse
public class UserManager {
    // problem 1: direkte datenbankverbindung in der business-klasse
    private java.sql.Connection conn;

    public UserManager(java.sql.Connection conn) {
        this.conn = conn;
    }

    // problem 2: login-logik + db-zugriff gemischt
    public boolean login(String username, String password) {
        try {
            var stmt = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                // problem 3: email-versand gehoert hier nicht rein
                sendWelcomeEmail(username);
                return true;
            }
        } catch (Exception e) {
            // problem 4: logging direkt in der klasse
            System.err.println("db fehler: " + e.getMessage());
        }
        return false;
    }

    // grund 1 fuer aenderung: email-inhalt aendert sich
    private void sendWelcomeEmail(String username) {
        System.out.println("sende email an: " + username);
    }

    // grund 2 fuer aenderung: db-schema aendert sich
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
