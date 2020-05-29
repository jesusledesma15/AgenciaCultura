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
                <label for="nombreCli">Correo: </label>
                <input type="text" id="nombreCli" name="txtEmail"/> <br/><br/>
                <label for="nifCli">NIF: </label>
                <input type="text" id="nifCli" name="txtNif" maxlength="9"/> <br/>
            </fieldset>
            <fieldset>
                <legend>Servicio</legend>
                <%
                    // Lista de servicios
                    ArrayList<ServicioTuristicoVO> lista = ServicioTuristicoDAO.consultarServicios();

                    for (ServicioTuristicoVO s : lista) {
                        out.print("<label for='" + s.getDescripcion() + "'>" + s.getDescripcion() + "</label> \t");
                        out.print(s.getPrecio() + "€");
                        out.print("<input type='radio' name='servicio' id='" + s.getDescripcion() + "'   value='" + s.getIdServicio() + "'/>");
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
