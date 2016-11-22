package dao;

import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class UserDAOImpl implements UsersDao{

    Connection connection;

    private static final String SQL_INSERT_USER = "INSERT INTO users(id, name,city,age) VALUES(?, ?, ?, ?);";
    private static final String SQL_GET_USERS = "SELECT * FROM users;";
    private static final String SQL_GET_USER = "SELECT * FROM users(id) VALUE(?);";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id == ?;";
    private static final String SQL_UPDATE_USER = "UPDATE users SET name == ?, city == ?, age == ? WHERE id == ?;";
    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }


    /**
     * Find all users
     * @return
     */
    public List<User> findAll() {

        List<User> users = new ArrayList<User>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_USERS);

            while (resultSet.next()){
                users.add(new User(resultSet.getInt("id"),resultSet.getString("city"),resultSet.getString("name"),resultSet.getInt("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Find user by Id
     * @param id
     * @return
     */
    public User find(int id) {

        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            user = new User(resultSet.getInt("id"),resultSet.getString("city"),resultSet.getString("name"),resultSet.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Save user
     * @param user
     */
    public void save(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER);
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getCity());
            statement.setInt(4,user.getAge());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete user by Id
     * @param id
     */
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setInt(1,id);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update user
     * @param user
     */
    public void update(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1,user.getName());
            statement.setString(2,user.getCity());
            statement.setInt(3,user.getAge());
            statement.setInt(4,user.getId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
