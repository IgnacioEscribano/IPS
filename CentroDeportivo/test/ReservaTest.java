import CapaDatos.ReservaDatos;
import CapaNegocio.excepciones.ExcepcionReserva;
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
        try {
            reserva = new ReservaDao(
                    "res1", ReservaDao.SOCIO, new Date(2016, 10, 20, 11, 0),
                    new Date(2016, 10, 20, 12, 0), "inst1",
                    "soc1");
        } catch (ExcepcionReserva excepcionReserva) {
            excepcionReserva.printStackTrace();
        }

    }

    @Test
    public void anadirReservaBBDD() {
        try {
            ReservaDatos.insertarReserva(reserva, true);
            assertEquals(reserva.toString(),
                    ReservaDatos.getReservaPorID("res1"));
        } catch (ExcepcionReserva excepcionReserva) {
            excepcionReserva.printStackTrace();
        }
    }

    @Test
    public void calcularImporteReserva() {
        assertEquals(reserva.getInstalacion().getPrecioHora() *
                        reserva.getDuracionEnHoras(),
                reserva.calcularImporteReserva());
    }

}