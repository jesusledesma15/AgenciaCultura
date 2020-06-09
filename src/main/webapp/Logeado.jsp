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
        <link href="./css/estilo.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contenedor">
            <header>
                <h1 id="saludo">Hola ${sessionScope['dniCliente']} ${sessionScope['correoCliente']}</h1>
                <div class="menu">                    
                    <button type="button" onclick="location.href= './contratarReserva.jsp'"><span class="icon">&#128270;</span> Contratar reserva</button>
                    <button type="button" onclick="location.href= './verReservas.jsp'"><span class="icon">&#x1f440;</span> Ver reserva</button>
                    <button type="button" onclick="location.href= './anularReserva.jsp'"><span class="icon">&#10060;</span> Anular reserva</button>
                    <button id="off" type="button" onclick="location.href = './index.jsp'"><span class="icon">&#x1f518; </span> Salir</button>
                </div>
            </header>
        </div>
    </body>
</html>
