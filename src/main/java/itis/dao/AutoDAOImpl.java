package itis.dao;

import itis.models.Auto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class AutoDAOImpl implements AutoDAO {

    Connection connection;

    public AutoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Get specific user cars
     * @param id
     * @return
     */
    public List<Auto> getUserCars(int id) {

        List<Auto> autos = new ArrayList<Auto>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("");

            while (resultSet.next()){
                autos.add(new Auto(resultSet.getInt("id"),resultSet.getLong("distance"),resultSet.getString("modelName"), resultSet.getInt("userId")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autos;
    }

}
