package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class Testing {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection =databaseConnection.getConnection();
    }
}
