/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
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
public class ClienteDAO {

    private static final Connection CONEXION = Conexion.getInstance();

    //metodo para insertar clientes en la base de datos
    public static void insertarCliente(String nombre, String apellidos, String correo, String dni, String numTarjeta) {

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
            prest.setInt(1, numIds()); //metodo que devuelve el numero de clientes mas uno, sirve para darle la id automaticamente
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
    //-----------------------------------------------------------------------------------

    //metodo para logearse en la pagina, que recibe un dni y un correo
    public static boolean login(String dniJsp, String correo) {
        Statement st;
        ResultSet res;
        boolean login = false;

        // Guardo la consulta SQL realizar en una cadena
        //devuelve el dni, que coincida con el correo
        String sql = "select dni as email from clientes where correo='" + correo + "'";
        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            if (res.next()) {

                //pasamos numEmails a entero
                String dniDB = res.getString("email");

//                System.out.println("dniDB " + dniDB);
//                System.out.println("dniJsp " + dniJsp);
                //si el dni de la base de datos es igual que el pasado por parametros, la variable login vale true, sino vale false
                if (dniDB.equals(dniJsp)) {
                    login = true;
                } else {
                    login = false;
                }

            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla cliente");
            System.out.println(e);
        }

        return login;
    }
    //-----------------------------------------------------------------------------------

    public static int getIdbyNif(String nif) {
        Statement st;
        ResultSet res;
        int id = -1;

        // Guardo la consulta SQL realizar en una cadena
        String sql = "select idCliente as IdbyNif from clientes where dni='" + nif + "'";
        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            if (res.next()) {

                id = res.getInt("IdbyNif");

            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("No se ha encontrado id para ese NIF");
            System.out.println(e);
        }

        return id;
    }
    //-----------------------------------------------------------------------------------

    public static boolean checkUser(String dni, String correo) {
        Statement st;
        ResultSet res;
        boolean valido = false;
        // Guardo la consulta SQL realizar en una cadena
        //hacer consulta para contar, los emails
        String sql = "select correo from clientes where dni='" + dni + "'";
        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            if (res.next()) {

                //pasamos numEmails a entero
                String checkCorreo = res.getString("correo");
                System.out.println(checkCorreo);
                //System.out.println("numEmails "+numEmails);
                //si la consulta de el dni, da mas de 0...
                valido = checkCorreo.equals(correo);

            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("El usuario no es válido");
            System.out.println(e);
        }

        return valido;
    }
    //-----------------------------------------------------------------------------------

    //metodo para ver si existe un cliente consultando la tabla por su dni
    public static boolean consultarDni(String dni) {
        Statement st;
        ResultSet res;
        boolean existe = false;

        // Guardo la consulta SQL realizar en una cadena
        //hacer consulta para contar, los emails
        String sql = "select max(*) as dni from clientes where dni='" + dni + "'";
        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            if (res.next()) {

                //pasamos numEmails a entero
                int numDnis = res.getInt("dni");
                //System.out.println("numEmails "+numEmails);
                //si la consulta de el dni, da mas de 0...
                if (numDnis > 0) {
                    existe = true;
                } else {
                    existe = false;
                }

            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla cliente");
            System.out.println(e);
        }

        return existe;
    }
    //-----------------------------------------------------------------------------------

    //metodo que devuelve el último id +1, se usara para asignar una id al siguiente cliente
    public static int numIds() {
        Statement st;
        ResultSet res;
        int numId = 0;

        // Guardo la consulta SQL realizar en una cadena
        //hacer consulta para contar, los emails
        String sql = "select max(idCliente) as num from clientes ";
        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            if (res.next()) {

                //pasamos el alias num a entero
                numId = res.getInt("num");

            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla clientes");
            System.out.println(e);
        }

        //devuelve el ultimo id mas uno 
        return ++numId;
    }

    //-----------------------------------------------------------------------------------
    //metodo para consultar las reservas, por id
    public static ArrayList<ReservaVO> consultarReservas(int idCliente) {
        Statement st;
        ResultSet res;
        ArrayList<ReservaVO> lista = new ArrayList();

        // Guardo la consulta SQL realizar en una cadena
        String sql = "select * from reservas where idCliente='" + idCliente + "'";
//        String sql = "select * from reservas ";

        try {

            // Preparamos Statement
            st = CONEXION.createStatement();
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista

            while (res.next()) {
                ReservaVO r = new ReservaVO();
                // Recogemos los datos del turismo, guardamos en un objeto
                r.setIdReserva(res.getInt("idReserva"));
                r.setIdCliente(res.getInt("idCliente"));
                r.setIdServicio(res.getInt("idServicio"));
                r.setFecha(res.getDate("fecha").toLocalDate());

                //Añadimos el objeto al array
                lista.add(r);
            }
            // Cerramos el recurso PreparedStatement 
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla reservas");
            System.out.println(e);
        }

        return lista;
    }

}
