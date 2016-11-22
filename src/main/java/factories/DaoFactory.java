package factories;

import com.sun.istack.internal.NotNull;
import dao.AuthorizationDAO;
import dao.AutoDAO;
import dao.UsersDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private UsersDao usersDao;
    private AutoDAO autoDAO;
    private AuthorizationDAO authorizationDAO;


    private Properties properties;

    static {
        new DaoFactory();
    }

    private DaoFactory() {

        properties = new Properties();

        try {

            properties.load(new FileInputStream(""));

            Constructor usersConstructor = Class.forName(properties.getProperty("")).getConstructor(Connection.class);
            Constructor autoConstructor = Class.forName(properties.getProperty("")).getConstructor(Connection.class);
            Constructor authorizationConstructor = Class.forName(properties.getProperty("")).getConstructor(Connection.class);


            usersDao = (UsersDao) usersConstructor.newInstance(ConnectionFactory.getConnectionFactory().getConnection());
            autoDAO = (AutoDAO)autoConstructor.newInstance(ConnectionFactory.getConnectionFactory().getConnection());
            authorizationDAO = (AuthorizationDAO)authorizationConstructor.newInstance(ConnectionFactory.getConnectionFactory().getConnection());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    @NotNull
    public UsersDao getUsersDao() {
        return usersDao;
    }

    @NotNull
    public AutoDAO getAutoDAO() {
        return autoDAO;
    }
}
