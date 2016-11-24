package itis.dao;

import itis.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by antonkazakov on 22.11.16.
 */
public class AuthorizationDAOImpl implements AuthorizationDAO{

    Connection connection;

    private final String SQL_LOGIN = "SELECT * FROM users WHERE name = ? AND password = ?";
    private final String SQL_SIGNUP = "INSERT INTO users(login, password) VALUES (?,?)";
    private final String SQL_GET_USER = "SELECT * FROM users WHERE id = ?";
    private final String SQL_GET_USER_BY_NAME = "SELECT * FROM users WHERE login = ?";

    public AuthorizationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public User getUserByLogin(String login) {
        return null;
    }

    public long login(String login, String password) {
        return 0;
    }

    public long register(String login, String password) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SIGNUP, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);

            // If user exists throw exception
            /// if (getUserByLogin(login)!=null){
            ///     throw new SQLException("USER EXISTS");
            //   }

            //If not exists

            int affectedRows = preparedStatement.executeUpdate();


            if (affectedRows==0){
                //If user not created show error
                throw new SQLException("ERROR ON REGISTERING");
            }else {

                //preparedStatement.getGeneratedKeys();
                if (preparedStatement.getGeneratedKeys().next()){

                    return preparedStatement.getGeneratedKeys().getLong(1);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }

        return -1;
    }
}
