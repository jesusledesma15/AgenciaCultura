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
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class ServicioTuristicoDAO {

    private static final Connection CONEXION = Conexion.getInstance();

    public static void insertarServicio(String descripcion, double precio) {

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
            prest.setInt(1, numIds());
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

    public static ArrayList<ServicioTuristicoVO> consultarServicios() {
        Statement st;
        ResultSet res;
        ArrayList<ServicioTuristicoVO> lista = new ArrayList();

        // Guardo la consulta SQL realizar en una cadena
        String sql = "select * from servicios;";

        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            while (res.next()) {
                ServicioTuristicoVO s = new ServicioTuristicoVO();
                // Recogemos los datos del turismo, guardamos en un objeto
                s.setIdServicio(res.getInt("idServicio"));
                s.setDescripcion(res.getString("descripcion"));
                s.setPrecio(res.getDouble("precio"));

                //Añadimos el objeto al array
                lista.add(s);
            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla Servicios");
            System.out.println(e);
        }

        return lista;
    }

    public static int numIds() {
        Statement st;
        ResultSet res;
        int numServicio = 0;

        // Guardo la consulta SQL realizar en una cadena
        //hacer consulta para contar, los emails
        String sql = "select count(*) as num from servicios ";
        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            if (res.next()) {

                //pasamos numEmails a entero
                numServicio = res.getInt("num");

            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla Servicios");
            System.out.println(e);
        }

        return ++numServicio;
    }

    public static void main(String[] args) {

        ServicioTuristicoDAO.insertarServicio("Museo", 50);

    }
}
