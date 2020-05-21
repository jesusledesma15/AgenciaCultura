/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Salva
 */
public class ReservaDAO {
    
      private static final Connection CONEXION = Conexion.getInstance();

       public static void insertarReserva(int idReserva, int idCliente, int idServicio, LocalDate fecha) {

        // Cadena con la consulta parametrizada
        String sql = "insert into reservas values (?,?,?,?)";

        PreparedStatement prest;

        try {
            // Preparamos la inserción de datos  mediante un PreparedStatement
            prest = CONEXION.prepareStatement(sql);

            // Procedemos a indicar los valores que queremos insertar
            // Usamos los métodos setXXX(indice, valor)
            // indice indica la posicion del argumento ?, empieza en 1
            // valor es el dato que queremos insertar
            prest.setInt(1, idReserva);
            prest.setInt(2, idCliente);
            prest.setInt(3, idServicio);
            prest.setDate(4, java.sql.Date.valueOf(fecha));


            // Ejecutamos la sentencia de inserción preparada anteriormente
            prest.executeUpdate();

            // Cerramos el recurso PreparedStatement 
            prest.close();

            // La inserción se realizó con éxito, devolvemos filas afectadas
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla Reservas");
            System.out.println(e);

        }
    }
    
}
