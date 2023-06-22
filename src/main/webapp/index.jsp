<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <link rel ="stylesheet" type="text/css" href="style.css">
  <title>Menú Inmobiliaria</title>
</head>
<body>
<h1>Menú principal Inmobiliaria</h1>
<br/>
<div class="form-group">
  <form action="registroVendedor" method="get">
    <input type="submit" value="Registrar Vendedor" class="boton">
  </form>
</div>
<div class="form-group">
  <form action="registroInmueble" method="get">
    <input type="submit" value="Registrar Inmueble" class="boton">
  </form>
</div>
<div class="form-group">
  <form action="buscarInmueble" method="get">
    <input type="submit" value="Buscar Inmueble" class="boton">
  </form>
</div>
</body>
</html>