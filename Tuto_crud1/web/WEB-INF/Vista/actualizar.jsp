<%@ page import="Modelo.Banco" %>
<%@ page import="ModeloDAO.BancoDAO" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16/05/2020
  Time: 4:40 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
       BancoDAO dao= new BancoDAO();
       String nit=(String)request.getAttribute("idban");
       Banco ban=dao.List(nit);
   %>
   <h1>Modificar Banco</h1>
   <form action="Controlador">
     Codigo: <br>
     <input type="text" name="frcodigo" value="<%= ban.getBan_id()%>"><br>
     Nombre: <br>
     <input type="text" name="frnombre" value="<%= ban.getBan_nom()%>"> <br>
       <input type="submit" name="accion" value="Update">
  </form>

</body>
</html>
