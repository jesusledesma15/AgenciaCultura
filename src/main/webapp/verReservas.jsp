<%-- 
    Document   : verReservas
    Created on : 30-may-2020, 11:39:54
    Author     : Salva
--%>


<%@page import="daw.agencia.controlador.AgenciaCultura"%>
<%@page import="modelo.ClienteVO"%>
<%@page import="modelo.ClienteDAO"%>
<%@page import="modelo.ReservaVO"%>
<%@page import="modelo.ReservaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas por clientes</title>
    </head>
    <body>
        <h1>Reservas por clientes</h1>
        <table border ="1">

            <tr>
                <th>
                    <b>IdReserva</b>
                </th>
                <th>
                    <b>IdCliente</b>
                </th>
                <th>
                    <b>IdServicio</b>
                </th>
                <th>
                    <b>fecha</b>
                </th>
            </tr>
            <!--        ArrayList<ReservaVO> listaReservas = ClienteDAO.consultarReservas(ClienteDAO.getIdbyNif("87542132U"));-->

            <%

                // Lista ordenada de reservas para un idCliente
                ArrayList<ReservaVO> listaReservas = ClienteDAO.consultarReservas(ClienteDAO.getIdbyNif("87542132U"));

                for (ReservaVO r : listaReservas) {
                    out.print("<tr><td>");
                    out.print(r.getIdReserva());
                    out.print("</td><td>");
                    out.print(r.getIdCliente());
                    out.print("</td><td>");
                    out.print(r.getIdServicio());
                    out.print("</td><td>");
                    out.print(r.getFecha());
                    out.print("</td><tr>");

                }
            %>

        </table>
    </body>
</html>
