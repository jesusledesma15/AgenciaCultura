/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Salva
 */
public class ServicioTuristicoDAO {

    private static final Connection CONEXION = Conexion.getInstance();

       public static void insertarCliente(int idServicio, String descripcion, double precio) {

        // Cadena con la consulta parametrizada
        String sql = "insert into servicios values (?,?,?)";

        PreparedStatement prest;

        try {
            // Preparamos la inserción de datos  mediante un PreparedStatement
            prest = CONEXION.prepareStatement(sql);

            // Procedemos a indicar los valores que queremos insertar
            // Usamos los métodos setXXX(indice, valor)
            // indice indica la posicion del argumento ?, empieza en 1
            // valor es el dato que queremos insertar
            prest.setInt(1, idServicio);
            prest.setString(2, descripcion);
            prest.setDouble(3, precio);

            // Ejecutamos la sentencia de inserción preparada anteriormente
            prest.executeUpdate();

            // Cerramos el recurso PreparedStatement 
            prest.close();

            // La inserción se realizó con éxito, devolvemos filas afectadas
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla servicios");
            System.out.println(e);

        }
    }
    public static void main(String[] args) {

        ServicioTuristicoDAO.insertarCliente(1, "Gastronomía", 50);

    }
}
