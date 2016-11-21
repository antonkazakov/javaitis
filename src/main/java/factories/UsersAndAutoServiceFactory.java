package factories;

import dao.AutoDAO;
import dao.UsersDao;
import services.UsersAndAutoService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class UsersAndAutoServiceFactory {

    private static UsersAndAutoServiceFactory usersAndAutoServiceFactory;

    private UsersAndAutoService usersAndAutoService;

    static {
        new UsersAndAutoServiceFactory();
    }

    private UsersAndAutoServiceFactory() {
        try {
            Constructor constructor = Class.forName("").getConstructor(UsersDao.class, AutoDAO.class);
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
        }
    }

    public UsersAndAutoService getUsersAndAutoService() {
        return usersAndAutoService;
    }

    public static UsersAndAutoServiceFactory getUsersAndAutoServiceFactory() {
        return usersAndAutoServiceFactory;
    }
}
