/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agencia.controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ClienteDAO;

/**
 *
 * @author Salva
 */
public class AgenciaCultura extends HttpServlet {

    // El siguiente método procesa la petición para métodos GET y POST
    // Tiene dos parámetros:
    //  -   request objeto tipo HTTPServletRequest con info de la 
    //      petición del cliente
    //  -   response objeto tipo HTTPServletResponse con info de la 
    //      respuesta al cliente
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Se establece el tipo de contenido a enviar en la respuesta
        response.setContentType("text/html;charset=UTF-8");

        // ServletContext permite acceder a la información asociada 
        // a la aplicación
        ServletContext contexto = request.getServletContext();

        // Obtengo la sesion de la petición HTTP, si existe. 
        // Con true, si no está creada se crea
        HttpSession sesion = request.getSession(true);

        // Guardo los datos del cliente en Strings
        String nombreCliente = request.getParameter("txtNombre");
        String apellidosCliente = request.getParameter("txtApellidos");
        String correoCliente = request.getParameter("txtCorreo");
        String dniCliente = request.getParameter("txtDni");
        String numTarjetaCliente = request.getParameter("txtNumTarjeta");

        // Asigno esos datos a los atributos de la sesión y así lo puedo usar en la vista
        sesion.setAttribute("nombreCliente", nombreCliente);
//        sesion.setAttribute("apellidosCliente", apellidosCliente);
//        sesion.setAttribute("correoCliente", correoCliente);
//        sesion.setAttribute("dniCliente", dniCliente);
//        sesion.setAttribute("numTarjetaCliente", numTarjetaCliente);

//--------------------------------------------------------------------------------------------------------------
        if (ClienteDAO.login(dniCliente, correoCliente) ) {
            RequestDispatcher despachador = contexto.getRequestDispatcher("/Logeado.jsp");
            despachador.forward(request, response);
        }
//        else{
////               RequestDispatcher despachador = contexto.getRequestDispatcher("/Formulario_Registro.jsp");
////            despachador.forward(request, response);
//        }

        if (!ClienteDAO.consultarDni(dniCliente)) {
            ClienteDAO.insertarCliente(nombreCliente, apellidosCliente, correoCliente, dniCliente, numTarjetaCliente);
            RequestDispatcher despachador = contexto.getRequestDispatcher("/Respuesta_No_Existe.jsp");
            despachador.forward(request, response);
        } else {
            RequestDispatcher despachador = contexto.getRequestDispatcher("/Respuesta_Ya_Existe.jsp");
            despachador.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
