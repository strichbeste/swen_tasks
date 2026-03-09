// interface fuer datenbankzugriff
public interface DatabaseService {
    String getUserById(int id);
    boolean saveUser(String username);
}
