/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class ReservaDAO {

    private static final Connection CONEXION = Conexion.getInstance();

    public static boolean insertarReserva(int idCliente, int idServicio, LocalDate fecha) {

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
            prest.setInt(1, numIds());
            prest.setInt(2, idCliente);
            prest.setInt(3, idServicio);
            prest.setDate(4, java.sql.Date.valueOf(fecha));

            // Ejecutamos la sentencia de inserción preparada anteriormente
            prest.executeUpdate();

            // Cerramos el recurso PreparedStatement 
            prest.close();
            return true;
            // La inserción se realizó con éxito, devolvemos filas afectadas
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla Reservas");
            System.out.println(e);

        }
        return false;
    }

    public static boolean deleteReserva(int idReserva) {
        boolean numFilas = false;

        String sql = "delete from reservas where idReserva = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = CONEXION.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, idReserva);
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Problemas durante el borrado de datos en la tabla reservas");
            System.out.println(e);
        }
        return numFilas;
    }

    public static int numIds() {
        Statement st;
        ResultSet res;
        int numReservas = 0;

        // Guardo la consulta SQL realizar en una cadena
        //hacer consulta para contar, los emails
        String sql = "select max(idReserva) as num from reservas";
        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            if (res.next()) {

                //pasamos numEmails a entero
                numReservas = res.getInt("num");

            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla clientes");
            System.out.println(e);
        }

        return ++numReservas;
    }

}
