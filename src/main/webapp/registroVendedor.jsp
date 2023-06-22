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
  <title>Registro Vendedor</title>
</head>
<body>
<h1>Registro Vendedor</h1>
<form action="registroVendedor" method="post">
  <div class="form-group">
    <label for="rut">RUT Vendedor:</label>
    <input type="text" id="rut" name="rut" required>
  </div>
  <div class="form-group">
    <label for= "nombre">Nombre:</label>
    <input type="text" id = "nombre" name="nombre" required>
  </div>
  <div class="form-group">
    <label for= "direccion">Dirección:</label>
    <input type="text" id = "direccion" name="direccion" required>
  </div>
  <div class="form-group">
    <label for= "titulo">Título:</label>
    <input type="text" id = "titulo" name="titulo" required>
  </div>
  <div class="form-group">
    <label>
      <select name ="estado_civil">
        <option value ="0">Estado civil</option>
        <option value="Soltero">Soltero</option>
        <option value="Casado">Casado</option>
        <option value="Divorsiado">Divorsiado</option>
      </select>
    </label>
  </div>
  <input type="submit" value="Registrar" class="boton">
</form>
</body>
</html>

