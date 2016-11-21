package dao;

import com.google.common.collect.Lists;
import factories.ConnectionFactory;
import models.Auto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by antonkazakov on 21.11.16.
 */
public class AutoDAOImplTest {

    AutoDAO autoDAOImpl;

    private static List<Auto> getFakeAutos(){

        Auto test1 = new Auto(1,1000,"LaFerrari",1);
        Auto test2 = new Auto(2,2000,"Mercedes",1);
        Auto test3 = new Auto(3,3000,"R8",1);
        return Lists.newArrayList(test1,test2,test3);
    }

    @Before
    public void setUp() throws Exception {
        autoDAOImpl = new AutoDAOImpl(ConnectionFactory.getConnectionFactory().getConnection());
    }

    @Test
    public void getUserCars() throws Exception {

        List<Auto> expected = getFakeAutos();

        List<Auto> actual = autoDAOImpl.getUserCars(1);

        assertEquals(expected,actual);


    }

}