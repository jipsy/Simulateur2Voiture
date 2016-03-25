package domaineroute;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jp on 15/03/16.
 */
public class TestRoute {

    Route maRoute;

    @Before
    public void setUp(){
        maRoute = new Route(100,50);
    }


    @Test
    public void  testGetX() {
        int get;
        get = maRoute.getX();
        assertEquals(100, get);
    }

    @Test
    public void  testGetY() {
        int get ;
        get = maRoute.getY();
        assertEquals(50, get);
    }
}
