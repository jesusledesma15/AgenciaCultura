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
    
    private int idReserva;
    private ClienteVO idCliente; //preguntar si se guarda el cliente entero
    //o solo el id
    private ServicioTuristicoVO idServicio;
    private LocalDate fecha;

    public ReservaVO(int idReserva, ClienteVO idCliente, ServicioTuristicoVO idServicio, LocalDate fecha) {
        this.idReserva = idReserva;
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

    public ClienteVO getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteVO idCliente) {
        this.idCliente = idCliente;
    }

    public ServicioTuristicoVO getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(ServicioTuristicoVO idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public String toString() {
        return "ReservaVO{" + "idReserva=" + idReserva + ", idCliente=" + idCliente + ", idServicio=" + idServicio + ", fecha=" + fecha + '}';
    }

    
    
}
