package itis.dao;

import itis.models.Auto;

import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public interface AutoDAO {

    List<Auto> getUserCars(int id);

}
