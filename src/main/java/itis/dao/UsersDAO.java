package itis.dao;

import itis.models.User;

import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public interface UsersDAO {

    List<User> findAll();

    User find(int id);

    void save(User user);

    void delete(int id);

    void update(User user);



}
