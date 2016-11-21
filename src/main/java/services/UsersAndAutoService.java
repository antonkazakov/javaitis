package services;

import models.Auto;
import models.User;

import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public interface UsersAndAutoService {

    boolean isUserExists(int id);

    List<User> getAllUsersByCity(String city);

    List<User> getAllUsers();

    List<Auto> getAllCarsByCity(String city);

}
