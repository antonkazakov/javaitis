package factories;

import dao.AutoDAO;
import dao.UsersDao;
import models.Auto;
import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class UsersAndAutoServiceImpl implements UsersAndAutoService {

    UsersDao usersDao;
    AutoDAO autoDAO;

    public UsersAndAutoServiceImpl(UsersDao usersDao, AutoDAO autoDAO) {
        this.usersDao = usersDao;
        this.autoDAO = autoDAO;
    }


    /**
     * Check is users exists id DB
     * @param id
     * @return
     */
    public boolean isUserExists(int id) {
        return usersDao.find(id) != null;
    }


    /**
     * Get All users in specific city
     * @param city
     * @return
     */
    public List<User> getAllUsersByCity(String city) {

        List<User> users = new ArrayList<User>();

        for (User user : usersDao.findAll()){
            List<Auto> userAutos = autoDAO.getUserCars(user.getId());
            user.setAutos(userAutos);
            users.add(user);
        }

        return users;
    }


    /**
     * Get All users with car list
     * @return
     */
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<User>();

        for (User user : usersDao.findAll()){
            List<Auto> userAutos = autoDAO.getUserCars(user.getId());
            user.setAutos(userAutos);
            users.add(user);
        }

        return users;
    }

}
