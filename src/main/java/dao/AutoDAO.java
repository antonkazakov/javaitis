package dao;

import models.Auto;
import models.User;

import java.util.List;

/**
 * Created by antonkazakov on 21.11.16.
 */
public interface AutoDAO {

    List<Auto> getUserCars(int id);

}
