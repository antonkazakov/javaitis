package factories;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class ConnectionFactory {

    private Properties properties;

    private static ConnectionFactory connectionFactory;

    private Connection connection;

    static {
        connectionFactory = new ConnectionFactory();
    }


    private ConnectionFactory() {

        properties = new Properties();

        try {
            properties.load(new FileInputStream(""));

            String driver = properties.getProperty("database.driver");
            String url = properties.getProperty("database.url");
            String name = properties.getProperty("database.name");
            String password = properties.getProperty("database.password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url,name,password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }
}
