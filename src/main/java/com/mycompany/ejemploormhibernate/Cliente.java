package com.mycompany.ejemploormhibernate;

/**
 * Clase POJO Cliente: creamos la clase, con sus atributos.
 * A continuacion, constructor, getter y setter automatico.
 *  
 * @author oscar
 */
public class Cliente {
    private int identificador;
    private String nombre;
    private String apellido;
    private String email;

    public Cliente(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Cliente() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
