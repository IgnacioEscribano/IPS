package CapaNegocio.dao;

/**
 * Created by Carla on 08/10/2016.
 */
public class Instalacion {

    private int precioHora;
    private String idInst;
    private String descripcion;
    private boolean disponible;

    public Instalacion(int precioHora, String idInst,
                       String descripcion) {
        this.precioHora = precioHora;
        this.idInst = idInst;
        this.descripcion = descripcion;
        this.disponible = true;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }
}
