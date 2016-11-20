package factories;

import dao.AutoDAO;
import dao.UsersDao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    UsersDao usersDao;
    AutoDAO autoDAO;

    Properties properties;

    static {
        new DaoFactory();
    }

    public DaoFactory() {

        try {
            Constructor usersConstructor = Class.forName("").getConstructor(Connection.class);
            Constructor autoConstructor = Class.forName("").getConstructor(Connection.class);

            usersDao = (UsersDao) usersConstructor.newInstance(ConnectionFactory.getConnectionFactory().getConnection());
            autoDAO = (AutoDAO)autoConstructor.newInstance(ConnectionFactory.getConnectionFactory().getConnection());
            
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
        }

    }

    public static DaoFactory getDaoFactory() {
        return daoFactory;
    }
}
