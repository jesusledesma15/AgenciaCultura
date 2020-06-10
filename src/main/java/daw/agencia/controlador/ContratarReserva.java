/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agencia.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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

/**
 *
 * @author Salva
 */
@WebServlet(name = "ContratarReserva", urlPatterns = {"/ContratarReserva"})
public class ContratarReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // Se establece el tipo de contenido a enviar en la respuesta
            response.setContentType("text/html;charset=UTF-8");

            // ServletContext permite acceder a la información asociada 
            // a la aplicación
            ServletContext contexto = request.getServletContext();

            // Obtengo la sesion de la petición HTTP, si existe. 
            // Con true, si no está creada se crea
            HttpSession sesion = request.getSession(true);

            // Guardo los datos del cliente en Strings
            String dniCliente = sesion.getAttribute("dniCliente").toString();

//--------------------------------------------------------------------------------------------------------------
            //Contratar Reserva
            String idServicio = request.getParameter("servicio");
            System.out.println("idServicio -- " + idServicio + " int" + Integer.parseInt(idServicio));
            System.out.println(" dniCliente " + dniCliente);
            int idServ = Integer.parseInt(idServicio);

//            sesion.setAttribute("nifCli", nifCli);
            sesion.setAttribute("idServicio", idServicio);

            if (ReservaDAO.insertarReserva(ClienteDAO.getIdbyNif(dniCliente), idServ, LocalDate.now())) {
//                System.out.println("Reserva insert " + ReservaDAO.insertarReserva(ClienteDAO.getIdbyNif(nifCli), idServ, LocalDate.now()));
                System.out.println("Reserva hecha");

                RequestDispatcher despachador = contexto.getRequestDispatcher("/contratarReserva.jsp");
                despachador.forward(request, response);
            }

        }
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
