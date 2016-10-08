package CapaNegocio.dao;

import CapaDatos.InstalacionDatos;

import java.util.Date;

/**
 * Created by Carla on 08/10/2016.
 */
public class Instalacion {

    private int precioHora;
    private String idInst;
    private String descripcion;

    public Instalacion(int precioHora, String idInst,
                       String descripcion) {
        this.precioHora = precioHora;
        this.idInst = idInst;
        this.descripcion = descripcion;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    public void mostrarOcupacionSemanal() {
        InstalacionDatos.mostrarOcupacionSemanal(idInst);
    }

    public boolean estaDisponibleEnHoras(Date inicio, Date fin) {
        return InstalacionDatos.estsDisponibleEnHoras(idInst, inicio, fin);
    }
}
