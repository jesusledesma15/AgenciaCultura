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
public class ServicioTuristicoVO {
    
    private int idServicio;
    private String descripcion;
    private double precio;

    public ServicioTuristicoVO(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ServicioTuristicoVO{" + "idServicio=" + idServicio + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }


    
    
}
