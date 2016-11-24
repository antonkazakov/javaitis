package itis.factories;

import itis.dao.AutoDAO;
import itis.dao.UsersDAO;
import itis.services.UsersAndAutoService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class UsersAndAutoServiceFactory {

    private static UsersAndAutoServiceFactory usersAndAutoServiceFactory;

    private UsersAndAutoService usersAndAutoService;

    Properties properties;

    static {
        new UsersAndAutoServiceFactory();
    }

    private UsersAndAutoServiceFactory() {

        properties = new Properties();

        try {
            properties.load(new FileInputStream(""));
            Constructor constructor = Class.forName(properties.getProperty("")).getConstructor(UsersDAO.class, AutoDAO.class);
            usersAndAutoService = (UsersAndAutoService) constructor.newInstance(DaoFactory.getDaoFactory().getUsersDao(),DaoFactory.getDaoFactory().getAutoDAO());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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

    public UsersAndAutoService getUsersAndAutoService() {
        return usersAndAutoService;
    }

    public static UsersAndAutoServiceFactory getUsersAndAutoServiceFactory() {
        return usersAndAutoServiceFactory;
    }
}
