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
public class ClienteDAO {

    private static final Connection CONEXION = Conexion.getInstance();

    public static void insertarCliente(int idCliente, String nombre, String apellidos, String correo, String dni, String numTarjeta) {

        // Cadena con la consulta parametrizada
        String sql = "insert into clientes values (?,?,?,?,?,?)";

        PreparedStatement prest;

        try {
            // Preparamos la inserción de datos  mediante un PreparedStatement
            prest = CONEXION.prepareStatement(sql);

            // Procedemos a indicar los valores que queremos insertar
            // Usamos los métodos setXXX(indice, valor)
            // indice indica la posicion del argumento ?, empieza en 1
            // valor es el dato que queremos insertar
            prest.setInt(1, idCliente);
            prest.setString(2, nombre);
            prest.setString(3, apellidos);
            prest.setString(4, correo);
            prest.setString(5, dni);
            prest.setString(6, numTarjeta);

            // Ejecutamos la sentencia de inserción preparada anteriormente
            prest.executeUpdate();

            // Cerramos el recurso PreparedStatement 
            prest.close();

            // La inserción se realizó con éxito, devolvemos filas afectadas
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla clientes");
            System.out.println(e);

        }
    }

//    public static void main(String[] args) {
//
//        String nombre = "Paco";
//        String apellidos = "Perez";
//        String correo = "Paco@hotmail.com";
//        String dni = "77232323O";
//        String numTarjeta = "4656651657841";
//
//        ClienteDAO.insertarCliente(1, nombre, apellidos, correo, dni, numTarjeta);
//
//    }
}
