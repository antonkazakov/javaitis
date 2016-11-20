package dao;

import models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class UserDAOImpl implements UsersDao{

    Connection connection;

    private static final String SQL_INSERT_USER =
            "INSERT INTO group_member(id, name) VALUES(?, ?);";

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() {

        List<User> users = new ArrayList<User>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_INSERT_USER);

            while (resultSet.next()){
                users.add(new User(resultSet.getInt("id"),resultSet.getString("city"),resultSet.getString("name"),resultSet.getInt("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User find(int id) {

        User user = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_INSERT_USER);
            user = new User(resultSet.getInt("id"),resultSet.getString("city"),resultSet.getString("name"),resultSet.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void save(User user) {



    }

    public void delete(int id) {

    }

    public void update(User user) {

    }
}
