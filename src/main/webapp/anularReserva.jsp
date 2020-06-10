<%-- 
    Document   : anularReserva
    Created on : 3 jun. 2020, 19:44:26
    Author     : Jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/estilo.css" rel="stylesheet" type="text/css">
        <title>Anulación de reserva</title>
    </head>
    <body>
        <h1>Anular Reserva</h1>
        <form action="./AnularReservas" method="post">
            <label for="idReserva">ID Reserva: </label>
            <input type="text" id="idReserva" name="txtIdReserva"/> <br/><br/>
            <label for="nifCli">NIF: </label>
            <input type="text" id="nifCli" name="txtNif" maxlength="9"/> <br/>
            <input type="submit" value="Cancelar" name="Cancelar"/>
            <button type="button" onclick="location.href = './Logeado.jsp'">Volver</button>
        </form>
        
    </body>
</html>
