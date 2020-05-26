<%-- 
    Document   : Logeado
    Created on : 25-may-2020, 18:14:55
    Author     : Salva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="daw.agencia.controlador.Registro"%>
<%@page import="daw.agencia.controlador.AgenciaCultura"%>
<%@page import="modelo.ClienteVO"%>
<%@page import="modelo.ClienteDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola ${sessionScope['nombreCliente']} ${sessionScope['apellidosCliente']} </h1>
        <button type="button" onclick="location.href = './index.jsp'">Salir</button>
        <button type="button" onclick="location.href= './contratarReserva.jsp'">Contratar reserva</button>
        <button type="button" onclick="location.href= './verReservas.jsp'">Ver reserva</button>
        <button type="button" onclick="location.href= './anularReserva.jsp'">Anular reserva</button>

    </body>
</html>
