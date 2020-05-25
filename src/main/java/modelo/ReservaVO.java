/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Salva
 */
public class ReservaVO {
    
    //crear otra clase, que guarde el cliente entero
    
    private int idReserva;
    private int idCliente; 
    private int idServicio;
    private LocalDate fecha;

    public ReservaVO(int idCliente, int idServicio, LocalDate fecha) {
        this.idReserva = 
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public String toString() {
        return "ReservaVO{" + "idReserva=" + idReserva + ", idCliente=" + idCliente + ", idServicio=" + idServicio + ", fecha=" + fecha + '}';
    }

    
    
}
