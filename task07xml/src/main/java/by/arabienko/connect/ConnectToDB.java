package by.arabienko.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectToDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("property.database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
