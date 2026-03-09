import java.sql.*;
import java.util.*;

// vollstaendige crud-anwendung fuer die tasks-tabelle
// verbindet sich zur containerisierten postgres-datenbank
public class TaskCrudApp {

    // verbindungsparameter passend zum docker-compose.yml
    private static final String URL  = "jdbc:postgresql://localhost:5432/tasksdb";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("verbindung erfolgreich!");

            // CREATE – zwei tasks einfuegen
            int id1 = createTask(conn, "praesentationen vorbereiten", "alle 5 tasks");
            int id2 = createTask(conn, "unit tests schreiben", "minimum 20");
            System.out.println("erstellt: id " + id1 + " und " + id2);

            // READ – alle tasks ausgeben
            System.out.println("\nalle tasks:");
            readAllTasks(conn);

            // UPDATE – ersten task als erledigt markieren
            updateTask(conn, id1, true);
            System.out.println("\nnach update:");
            readAllTasks(conn);

            // DELETE – zweiten task loeschen
            deleteTask(conn, id2);
            System.out.println("\nnach delete:");
            readAllTasks(conn);

        } catch (SQLException e) {
            // verbindungsfehler abfangen und erklaeren
            System.err.println("verbindungsfehler: " + e.getMessage());
            System.err.println("sqlstate: " + e.getSQLState());
            System.err.println("tipp: ist docker container gestartet? -> docker-compose up -d");
        }
    }

    static int createTask(Connection conn, String title, String desc) throws SQLException {
        // prepared statement verhindert sql-injection
        String sql = "INSERT INTO tasks (title, description) VALUES (?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, desc);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("id");
        }
    }

    static void readAllTasks(Connection conn) throws SQLException {
        String sql = "SELECT id, title, done, created_at FROM tasks ORDER BY id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("[%d] %s | erledigt: %s | erstellt: %s%n",
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getBoolean("done"),
                    rs.getTimestamp("created_at")
                );
            }
        }
    }

    static void updateTask(Connection conn, int id, boolean done) throws SQLException {
        String sql = "UPDATE tasks SET done = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, done);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    static void deleteTask(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
