<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 22-06-2023
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Buscar Inmueble</title>
</head>
<body>
<h1>Buscar Inmbueble por ciudad</h1>
<form action="buscarInmueble" method="post">
    <div class="form-group">
        <label for= "ciudad">Ciudad:</label>
        <input type="text" id = "ciudad" name="ciudad" required>
    </div>
    <input type="submit" value="Buscar Articulo" class="boton">
</form>
</body>
</html>