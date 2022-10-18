<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Tareas"%>
<%
    if (session.getAttribute("tarea") == null) {
        ArrayList<Tareas> lisaux = new ArrayList<Tareas>();

        session.setAttribute("tarea", lisaux);

    }
    ArrayList<Tareas> tarea = (ArrayList<Tareas>) session.getAttribute("tarea");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tareas Pendientes</h1>
        <a href="nuevo.jsp">Nuevo</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Tarea</th>
                <th>Completado</th>
                <th></th>
            </tr>
            <%
                if (tarea != null) {
                    for (Tareas t : tarea) {
            %>
            <tr>
                <td><%= t.getId()%></td>
                <td><%= t.getTarea()%></td>
                <td><input type="checkbox" name="estado" 
                           <%
                               if (t.getEstado()) {
                           %>checked<%
                               }
                           %>></td>
                <td><a href="MainServlet?id=<%= t.getId()%>">Eliminar</a></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>

