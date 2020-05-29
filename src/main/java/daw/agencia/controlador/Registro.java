package daw.agencia.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ClienteDAO;
import modelo.ReservaDAO;
import modelo.ServicioTuristicoDAO;

/**
 *
 * @author Salva
 */
public class Registro extends HttpServlet {

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
        sesion.setAttribute("apellidosCliente", apellidosCliente);
//        sesion.setAttribute("correoCliente", correoCliente);
//        sesion.setAttribute("dniCliente", dniCliente);
//        sesion.setAttribute("numTarjetaCliente", numTarjetaCliente);

        //Contratar Reserva
//        String nifCli = request.getParameter("txtNif");
//        String correoCli = request.getParameter("txtEmail");
//        String idServicio = request.getParameter("servicio");
//
//        //Controlamos las credenciales del usuario que contrata el servicio
////        System.out.println("ClienteDAO.checkUser(nifCli, correoCli): " + ClienteDAO.checkUser(nifCli, correoCli));
//        System.out.println("getIdbyNif " + (ClienteDAO.getIdbyNif(dniCliente)));
//
//        ReservaDAO.insertarReserva((ClienteDAO.getIdbyNif(dniCliente)), Integer.parseInt(idServicio), LocalDate.now());

//        if (ClienteDAO.checkUser(nifCli, correoCli)) {
//            ReservaDAO.insertarReserva((ClienteDAO.getIdbyNif(dniCliente)), Integer.parseInt(idServicio), LocalDate.now());
//        }
//--------------------------------------------------------------------------------------------------------------
        //parte del registro
        if (!ClienteDAO.consultarDni(dniCliente)) {
            ClienteDAO.insertarCliente(nombreCliente, apellidosCliente, correoCliente, dniCliente, numTarjetaCliente);
            RequestDispatcher despachador = contexto.getRequestDispatcher("/Respuesta_No_Existe.jsp");
            despachador.forward(request, response);
        } else {
            RequestDispatcher despachador = contexto.getRequestDispatcher("/Respuesta_Ya_Existe.jsp");
            despachador.forward(request, response);
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
