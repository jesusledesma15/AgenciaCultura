<%-- 
    Document   : index
    Created on : 20-may-2020, 18:29:50
    Author     : Salva
--%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>
    <head>
        <title>Registro clientes</title>
        <meta charset="UTF-8" />
        <link href="./css/estilo.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <h1>Formulario de registros</h1>

        <p><font size="7">Registro clientes</font></p>

        <form action="./AgenciaCultura" method="POST">

            <p> Nombre del cliente   <input type="text" size="20" name="txtNombre">   </p>
            <p> Apellido del cliente   <input type="text" size="20" name="txtApellidos">   </p>
            <p> Correo electrónico:  <input type="email" size="40" name="txtCorreo"> </p>
            <p> DNI   <input type="text" size="9" name="txtDni">   </p>
            <p> Número de tarjeta de credito   <input type="text" size="16" name="txtNumTarjeta">   </p>



            <p> <input type="submit" name="buttonSubmit" value="Enviar"> 
                <input type="reset" name="buttonReset" value="Reset"> </p>
        </form>
    </body>
</html>

