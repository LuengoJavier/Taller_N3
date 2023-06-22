<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 22-06-2023
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Registro Inmueble</title>
</head>
<body>
<h1>Registro Inmueble</h1>
<h2>Datos Incorrectos o inmueble ya registrado, favor comprobar nuevamente</h2>
<form action="registroInmueble.jsp" method="post">
    <div class="form-group">
        <label for="id_inmueble">Codigo Categoria:</label>
        <input type="text" id="id_inmueble" name="id_inmueble" required>
    </div>
    <div class="form-group">
        <label>
            <select name ="tipo_construccion">
                <option value ="0">Material</option>
                <option value="Madera">Madera</option>
                <option value="Ladrillo">Ladrillo</option>
                <option value="Cemento">Cemento</option>
            </select>
        </label>
    </div>
    <div class="form-group">
        <label for= "direccion">Direccion:</label>
        <input type="text" id = "direccion" name="direccion" required>
    </div>
    <div class="form-group">
        <label for= "precio">Valor:</label>
        <input type="text" id = "precio" name="precio" required>
    </div>
    <input type="submit" value="Registrar" class="boton">
</form>
</body>
</html>
