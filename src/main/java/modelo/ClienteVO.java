/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Salva
 */
public class ClienteVO {

    private int idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String dni;
    private String numTarjeta;

    public ClienteVO(int idCliente, String nombre, String apellidos, String correo, String dni, String numTarjeta) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.dni = dni;
        this.numTarjeta = numTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "ClienteVO{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", dni=" + dni + ", numTarjeta=" + numTarjeta + '}';
    }
    

}
