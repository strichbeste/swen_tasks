package tasks4;

import java.sql.*;

// crud-demo mit postgres in docker
public class TaskCrudApp {
    private static final String URL  = "jdbc:postgresql://localhost:5432/tasksdb";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("verbindung ok!");

            int id1 = create(conn, "praesentationen vorbereiten", "alle 5 tasks");
            int id2 = create(conn, "unit tests schreiben", "minimum 20");

            System.out.println("\n--- alle tasks ---");
            readAll(conn);

            update(conn, id1, true);
            System.out.println("\n--- nach update ---");
            readAll(conn);

            delete(conn, id2);
            System.out.println("\n--- nach delete ---");
            readAll(conn);

        } catch (SQLException e) {
            System.err.println("fehler: " + e.getMessage());
            System.err.println("tipp: docker-compose up -d in tasks4/ ausfuehren");
        }
    }

    static int create(Connection c, String title, String desc) throws SQLException {
        var stmt = c.prepareStatement("INSERT INTO tasks(title,description) VALUES(?,?) RETURNING id");
        stmt.setString(1, title); stmt.setString(2, desc);
        var rs = stmt.executeQuery(); rs.next();
        return rs.getInt("id");
    }

    static void readAll(Connection c) throws SQLException {
        var rs = c.createStatement().executeQuery("SELECT id,title,done FROM tasks ORDER BY id");
        while (rs.next())
            System.out.printf("[%d] %s | done: %s%n", rs.getInt(1), rs.getString(2), rs.getBoolean(3));
    }

    static void update(Connection c, int id, boolean done) throws SQLException {
        var stmt = c.prepareStatement("UPDATE tasks SET done=? WHERE id=?");
        stmt.setBoolean(1, done); stmt.setInt(2, id); stmt.executeUpdate();
    }

    static void delete(Connection c, int id) throws SQLException {
        var stmt = c.prepareStatement("DELETE FROM tasks WHERE id=?");
        stmt.setInt(1, id); stmt.executeUpdate();
    }
}
