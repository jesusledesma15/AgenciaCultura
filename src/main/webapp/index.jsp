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
        <div class="contenedor">
            <header>
                <h1 id="logo">Agencia Cultural S&J</h1>
                <form action="./AgenciaCultura" method="POST">
                    <label for="correo"> Correo electrónico: </label>
                    <input type="email" size="40" name="txtCorreo" id="correo"/>
                    <label for="nif">NIF:</label>
                    <input type="password" size="9" name="txtDni" id="nif"/>
                    
                    <input type="submit" name="buttonSubmit" value="Login">
                </form>

                <p><a href="Formulario_Registro.jsp">¿Aun no te has registrado?</a></p>
            </header>
            <main>

            </main>
        </div>
    </body>
</html>

