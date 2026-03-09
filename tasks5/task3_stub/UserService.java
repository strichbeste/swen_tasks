// service der datenbank benutzt
public class UserService {
    private DatabaseService db;

    public UserService(DatabaseService db) { this.db = db; }

    public String getDisplayName(int id) {
        String name = db.getUserById(id);
        return name != null ? "user: " + name : "unbekannt";
    }

    public boolean register(String username) {
        if (username == null || username.length() < 3) return false;
        return db.saveUser(username);
    }
}
