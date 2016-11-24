package itis.dao;

import itis.models.User;

/**
 * Created by antonkazakov on 22.11.16.
 */
public interface AuthorizationDAO {

    User getUserByLogin(String login);

    long login(String login, String password);

    long register(String login, String password);

}
