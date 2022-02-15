import java.sql.SQLException;

public class TypeScrollInsensitive {

    public static void main(String[] args) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        connection.Insensitive();
    }
}
