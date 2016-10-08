package CapaDatos;

import CapaNegocio.dao.ReservaDao;
import CapaNegocio.excepciones.ExcepcionReserva;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Carla on 08/10/2016.
 */
public class ReservaDatos {
    public static void insertarReserva(ReservaDao reserva, boolean admin) throws ExcepcionReserva {
        comprobarReservaValida(reserva, admin);
        // TODO insertar reserva
    }

    private static void comprobarReservaValida(ReservaDao reserva, boolean admin) throws ExcepcionReserva {
        if (reserva.getInstalacion()
                .estaDisponibleEnHoras(reserva.getInicio(), reserva.getFin())) {

            long diff = reserva.getInicio().getTime() - new Date(System.currentTimeMillis()).getTime();
            long daysDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            long hoursDiff = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);

            if (daysDiff > ReservaDao.DIAS_ANTELACION_MAXIMO) {
                throw new ExcepcionReserva("Es demasiado pronto para realizar esta reserva");
            } else if ((admin && hoursDiff < ReservaDao.HORAS_ANTELACION_MAXIMO_ADMIN)
                    || (!admin && hoursDiff < ReservaDao.HORAS_ANTELACION_MAXIMO_SOCIO)) {
                throw new ExcepcionReserva("Es demasiado tarde para realizar esta reserva");
            }

        } else {
            throw new ExcepcionReserva("Esta instalacion ya esta reservada para esas fechas");
        }
    }

    /**
     * Con objeto de debuggear
     *
     * @param res1 - Reserva que se busca
     * @return String identico al toString de res1
     */
    public static String getReservaPorID(String res1) {
        return "";
    }

    public static String obtenerNuevoIDReserva() {
        return "";
    }
}
