import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Carla on 06/10/2016.
 */
public class ReservaTest {
    Reserva reserva;

    @Before
    public void setUp() throws Exception {
        reserva =  new Reserva(
                "res1", new Date(2016,10,20,11,0),
                new Date(2016,10,20,12,0), "soc1",
                "pag1");

    }

    @Test
    public void addToDatabase(){

    }

}