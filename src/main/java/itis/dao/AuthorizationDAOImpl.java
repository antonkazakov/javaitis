package itis.dao;

import itis.models.User;
import itis.utils.Utils;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by antonkazakov on 22.11.16.
 */
public class AuthorizationDAOImpl implements AuthorizationDAO{

    Connection connection;

    private final String SQL_LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?";
    private final String SQL_SIGNUP = "INSERT INTO users(login, password) VALUES (?,?)";
    private final String SQL_GET_USER = "SELECT * FROM users WHERE id = ?";
    private final String SQL_GET_USER_BY_NAME = "SELECT * FROM users WHERE login = ?";

    public AuthorizationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public User getUserByLogin(String login) {
        return null;
    }

    /**
     * Log in
     * @param login
     * @param password
     * @return
     */
    public String login(String login, String password) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_LOGIN);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,Utils.md5(password));

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getString("token");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Register user
     * @param login
     * @param password
     * @return
     */
    public long register(String login, String password) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SIGNUP, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2, Utils.md5(password));

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows==0){
                //If user not created show error
                throw new SQLException("ERROR ON REGISTERING");
            }else {
                if (preparedStatement.getGeneratedKeys().next())
                    return preparedStatement.getGeneratedKeys().getLong(1);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }

        return -1;
    }
}
