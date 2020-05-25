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
        <title>Bienvenida</title>
        <meta charset="UTF-8" />
        <link href="./css/estilo.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <h1>Bienvenida</h1>

        <p><font size="7">Pagina de Bienvenida</font></p>


        <form action="./AgenciaCultura" method="POST">
            <p>login</p>
            
            <p> Correo electrónico:  <input type="email" size="40" name="txtCorreo"> </p>
            <p> DNI   <input type="text" size="9" name="txtDni">   </p>
            <p> <input type="submit" name="buttonSubmit" value="Login"> </p>

        </form>

        <a href="Formulario_Registro.jsp">¿Aun no te has registrado?</a>

    </body>
</html>

