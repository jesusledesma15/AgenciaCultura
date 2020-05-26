<%-- 
    Document   : contratarReserva
    Created on : 26 may. 2020, 18:17:49
    Author     : Jesus
--%>

<%@page import="modelo.ServicioTuristicoDAO"%>
<%@page import="modelo.ServicioTuristicoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contratar reserva</title>
    </head>
    <body>
        <h1>Contratando una reserva</h1>
        <form action="./AgenciaCultura" method="post">
            <fieldset>
                <legend>Cliente</legend>
                <label for="nombreCli">Nombre: </label>
                <input type="text" id="nombreCli"/> <br/><br/>
                <label for="nifCli">NIF: </label>
                <input type="text" id="nifCli" maxlength="9"/> <br/>
            </fieldset>
            <fieldset>
                <legend>Servicio</legend>
                <%
                    // Lista ordenada por votos, de mayor a menor
                    ArrayList<ServicioTuristicoVO> lista = ServicioTuristicoDAO.consultarServicios();

                    for (ServicioTuristicoVO s : lista) {
                        out.print("<label for='s.getIdServicio'></label>");
                        out.print(s.getDescripcion() + " ");
                        out.print(s.getPrecio() + "€\t\t");
                        out.print("<input type='radio' name='servicio'/>");
                        out.println("<br/><br/>");

                    }
                %>
            </fieldset>
            <br/>
            <input type="submit" value="Enviar" name="Enviar"/>
            <input type="reset" value="Limpiar Formulario" name="Reset"/>
        </form>
    </body>
</html>
