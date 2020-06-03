/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agencia.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ClienteDAO;
import modelo.ReservaDAO;
import modelo.ReservaVO;

;

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
        //parte del login        
        //Si el metodo login devuelve true, se envia a la pagina principal, sino no pasa de la pagina index
        if (ClienteDAO.login(dniCliente, correoCliente)) {
            RequestDispatcher despachador = contexto.getRequestDispatcher("/Logeado.jsp");
            despachador.forward(request, response);
        } else {
            RequestDispatcher despachador = contexto.getRequestDispatcher("/index.jsp");
            despachador.forward(request, response);

        }
        //Anular Reserva
        String nifCli = request.getParameter("txtNif");
        int idReserva = Integer.parseInt(request.getParameter("txtIdReserva"));
        ArrayList<ReservaVO> reservaCliente = ClienteDAO.consultarReservas(ClienteDAO.getIdbyNif(nifCli));
        for (ReservaVO reserva : reservaCliente) {
            if (reserva.getIdReserva() == (idReserva)) {
                ReservaDAO.deleteReserva(idReserva);
            }
        }

        //Contratar Reserva
        String correoCli = request.getParameter("txtEmail");
        String idServicio = request.getParameter("servicio");
        System.out.println("idServicio -- " + idServicio + " int" + Integer.parseInt(idServicio));
        int idServ = Integer.parseInt(idServicio);

        sesion.setAttribute("nifCli", nifCli);
        sesion.setAttribute("idServicio", idServicio);

        ReservaDAO.insertarReserva(ClienteDAO.getIdbyNif(nifCli),
                idServ,
                LocalDate.now());

//        ArrayList<ReservaVO> listaReservas = ClienteDAO.consultarReservas(ClienteDAO.getIdbyNif(nifCli));
//        request.setAttribute("dni", request.getParameter("txtNombre"));
//         ServicioTuristicoVO st=new ServicioTuristicoVO();
//        System.out.println("\n\nClienteDAO.checkUser(nifCli, correoCli) " + ClienteDAO.checkUser(nifCli, correoCli));
//                System.out.println("correoCli "+ correoCli);
//                System.out.println("nombreCliente "+ nombreCliente);
//                System.out.println("getIdServicio "+ st.getIdServicio());
//                System.out.println("getIdServicio "+ st.getDescripcion());
//        if (ClienteDAO.checkUser(nifCli, correoCli)) {
//            ReservaDAO.insertarReserva(ClienteDAO.getIdbyNif(dniCliente), 1, LocalDate.now());
//        }
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

}
