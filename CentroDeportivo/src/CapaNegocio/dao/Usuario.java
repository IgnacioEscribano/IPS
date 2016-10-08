package CapaNegocio.dao;

import CapaDatos.UsuarioDatos;

/**
 * Created by Carla on 08/10/2016.
 */
public class Usuario {
    private boolean socio;
    private String nombre;
    private String apellidos;
    private String idUsu;
    private String DNI;
    private String direccion;
    private String cuentaBancaria;

    public Usuario(boolean socio, String nombre, String apellidos,
                   String idUsu, String DNI, String direccion, String cuentaBancaria) {
        this.socio = socio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idUsu = idUsu;
        this.DNI = DNI;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;

        UsuarioDatos.insertarUsuario(this);
    }
}
