package itis.factories;

import com.sun.istack.internal.NotNull;
import itis.dao.AuthorizationDAO;
import itis.dao.AutoDAO;
import itis.dao.UsersDAO;

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

    private UsersDAO usersDao;
    private AutoDAO autoDAO;
    private AuthorizationDAO authorizationDAO;

    private Properties properties;

    static {
       daoFactory = new DaoFactory();
    }


    private DaoFactory() {

        properties = new Properties();

        try {

            properties.load(new FileInputStream("/Users/antonkazakov/Auto/src/main/resources/database.properties"));

            Constructor usersConstructor = Class.forName(properties.getProperty("userdao.class")).getConstructor(Connection.class);
            Constructor autoConstructor = Class.forName(properties.getProperty("autodao.class")).getConstructor(Connection.class);
            Constructor authorizationConstructor = Class.forName(properties.getProperty("authorizationdao.class")).getConstructor(Connection.class);


            usersDao = (UsersDAO) usersConstructor.newInstance(ConnectionFactory.getConnectionFactory().getConnection());
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
    public UsersDAO getUsersDao() {
        return usersDao;
    }

    @NotNull
    public AutoDAO getAutoDAO() {
        return autoDAO;
    }

    @NotNull
    public AuthorizationDAO getAuthorizationDAO() {
        return authorizationDAO;
    }
}
