import CapaDatos.ReservaDatos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import CapaNegocio.dao.*;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Carla on 06/10/2016.
 */
public class ReservaTest {
    ReservaDao reserva;

    @Before
    public void setUp() throws Exception {
        reserva = new ReservaDao(
                "res1", ReservaDao.SOCIO, new Date(2016, 10, 20, 11, 0),
                new Date(2016, 10, 20, 12, 0), "inst1",
                "soc1");

    }

    @Test
    public void anadirReservaBBDD() {
        ReservaDatos.insertarReserva(reserva);
        assertEquals(reserva.toString(),
                ReservaDatos.getReservaPorID("res1"));
    }

    @Test
    public void calcularImporteReserva() {
        assertEquals(reserva.getInstalacion().getPrecioHora() *
                        reserva.getDuracionEnHoras(),
                reserva.calcularImporteReserva());
    }

}