package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection databaseConnection;
    private Connection connection;

    /**
     * for make DatabaseConnection class as a singleton class, we need to keep construct as private.
     * then we can ensure that there are no more classes than one.
     */
    private DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String password = "";
            String username = "ruwan";
            String url = "jdbc:mysql://localhost:3306/school";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
        }
    }

    /**
     * this method used to provide the database connection for outside the class
     * @return
     */
    private Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException{
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }else if (databaseConnection.getConnection().isClosed()) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }
}
