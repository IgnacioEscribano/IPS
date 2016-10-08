package CapaNegocio.dao;

import CapaDatos.InstalacionDatos;
import CapaDatos.ReservaDatos;
import CapaDatos.UsuarioDatos;
import CapaNegocio.excepciones.ExcepcionReserva;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Carla on 06/10/2016.
 */
public class ReservaDao {
    public static final int SOCIO = 0;
    public static final int CENTRO = 1;
    public static final int NO_SOCIO = 2;

    public static final int DIAS_ANTELACION_MAXIMO = 15;
    public static final int HORAS_ANTELACION_MAXIMO_ADMIN = 0;
    public static final int HORAS_ANTELACION_MAXIMO_SOCIO = 1;

    private final String idRes;
    private final int tipoRes;
    private final Date inicio;
    private final Date fin;
    private final String idInst;
    private final String idUsu;
    private Instalacion instalacion;
    private Usuario usuario;
    private int duracionEnHoras;

    public ReservaDao(String idRes, int tipoRes, Date inicio, Date fin,
                      String idInst, String idUsu) throws ExcepcionReserva {
        this.idRes = idRes;
        this.tipoRes = tipoRes;
        this.inicio = inicio;
        this.fin = fin;
        this.idInst = idInst;
        this.idUsu = idUsu;
        this.duracionEnHoras = fin.getHours() - inicio.getHours();

        if (duracionEnHoras > 2) {
            throw new ExcepcionReserva("Esta reserva dura demasiado");
        }

        instalacion = InstalacionDatos.obtenerInstalacionAPartirDeID(idInst);
        usuario = UsuarioDatos.obtenerUsuarioAPartirDeID(idUsu);
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public int getDuracionEnHoras() {
        return duracionEnHoras;
    }

    public int calcularImporteReserva() {
        return 0;
    }
}
