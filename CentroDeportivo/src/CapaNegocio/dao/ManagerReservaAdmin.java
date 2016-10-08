package CapaNegocio.dao;

import CapaDatos.ReservaDatos;
import CapaDatos.UsuarioDatos;
import CapaNegocio.excepciones.ExcepcionReserva;

import java.sql.Date;

/**
 * Created by Carla on 08/10/2016.
 */
public class ManagerReservaAdmin {

    public void crearReservaCentro(Date inicio, Date fin, String idInst) throws ExcepcionReserva {
        ReservaDao reserva = new ReservaDao(ReservaDatos.obtenerNuevoIDReserva(),
                ReservaDao.CENTRO, inicio, fin, idInst, null);
        ReservaDatos.insertarReserva(reserva, true);
    }

    public void crearReservaSocio(Date inicio, Date fin, String idInst, String idUsu) throws ExcepcionReserva {
        ReservaDao reserva = new ReservaDao(ReservaDatos.obtenerNuevoIDReserva(),
                ReservaDao.SOCIO, inicio, fin, idInst, idUsu);
        ReservaDatos.insertarReserva(reserva, true);
    }

    public void crearReservaNoSocio(Date inicio, Date fin, String idInst,
                                    String nombre, String apellidos, String DNI, String direccion) throws ExcepcionReserva {

        Usuario usuario = new Usuario(false, nombre, apellidos, UsuarioDatos.obtenerNuevoIDNoSocio(), DNI, direccion, null);
        UsuarioDatos.insertarUsuario(usuario);

        ReservaDao reserva = new ReservaDao(ReservaDatos.obtenerNuevoIDReserva(),
                ReservaDao.NO_SOCIO, inicio, fin, idInst, usuario.getIdUsu());
        ReservaDatos.insertarReserva(reserva, true);
    }
}
