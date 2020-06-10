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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ClienteDAO;
import modelo.ReservaDAO;
import modelo.ReservaVO;

/**
 *
 * @author Salva
 */
@WebServlet(name = "AnularReservas", urlPatterns = {"/AnularReservas"})
public class AnularReservas extends HttpServlet {
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

        // Asigno esos datos a los atributos de la sesión y así lo puedo usar en la vista
        sesion.setAttribute("nombreCliente", nombreCliente);

//--------------------------------------------------------------------------------------------------------------
        //Anular Reserva
        String nifCli = request.getParameter("txtNif");
        int idReserva = Integer.parseInt(request.getParameter("txtIdReserva"));
        ArrayList<ReservaVO> reservaCliente = ClienteDAO.consultarReservas(ClienteDAO.getIdbyNif(nifCli));
        for (ReservaVO reserva : reservaCliente) {
            if (reserva.getIdReserva() == (idReserva)) {
                ReservaDAO.deleteReserva(idReserva);
                RequestDispatcher despachador = contexto.getRequestDispatcher("/anularReserva.jsp");
                despachador.forward(request, response);
            }
        }

//-----------------------------------------------------------------------------
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
