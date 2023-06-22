<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 22-06-2023
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Inmuebles Encontrados</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<h1>Lista de inmuebles encontrados</h1>
<br>
<table class="table">
  <tr>
    <th>Tipo de material</th>
    <th>Ciudad</th>
    <th>Direccion</th>
    <th>Valor</th>
  </tr>
  <c:forEach items="${inmuebles}" var="inmueble">
    <tr>
      <td> <c:out value="${inmueble.getTipoConstruccion()}"></c:out> </td>
      <td> <c:out value="${inmueble.getCiudad()}"></c:out> </td>
      <td> <c:out value="${inmueble.getUbicacion()}"></c:out> </td>
      <td> <c:out value="${inmueble.getPrecio()}"></c:out> </td>
    </tr>
  </c:forEach>
</table>
<div class="form-group">
  <form>
    <a href="index.jsp" class="button-link">Volver al menú</a>
  </form>
</div>
</html>
