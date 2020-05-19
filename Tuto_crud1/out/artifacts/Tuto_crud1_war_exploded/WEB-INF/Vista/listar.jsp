<%@ page import="ModeloDAO.BancoDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Banco" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16/05/2020
  Time: 4:39 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>Banco</h1>
   <table border="1">
      <thead>
          <tr>
              <th>Banco_id</th>
              <th>Banco_nombre</th>
              <th>Acciones</th>
          </tr>
      </thead>
       <tbody>
       <%
           BancoDAO dao= new BancoDAO();
           List<Banco>list=dao.listar();
           Iterator<Banco>iter=list.iterator();
           Banco ban=null;
           while(iter.hasNext()){
               ban=iter.next();

       %>
       <td><%= ban.getBan_id()%>/td>
       <td><%= ban.getBan_nom();%>/td>
       <td>
           <a>Editar</a>
           <a>Eliminar</a>
       </td>
       <%}%>
       </tbody>
   </table>



</body>
</html>
