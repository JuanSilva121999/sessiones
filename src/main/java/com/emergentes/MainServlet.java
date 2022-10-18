package com.emergentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int pos= -1;
            int buscado= -1;
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            ArrayList<Tareas> lista = (ArrayList<Tareas>)ses.getAttribute("tarea");
            
            for(Tareas t : lista){
                pos++;
                if(t.getId()==id){
                    buscado = pos;
                }
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean estado = false;
        int id = Integer.parseInt(request.getParameter("id"));
        String tar=request.getParameter("tarea");
        int es=Integer.parseInt(request.getParameter("estado"));
        if(es ==1){
            estado = true;
        }
        
        Tareas t = new Tareas();
         t.setId(id);
         t.setTarea(tar);
         t.setEstado(estado);
         
         HttpSession ses = request.getSession();
         ArrayList<Tareas> lista = (ArrayList<Tareas>) ses.getAttribute("tarea");

        lista.add(t);
        response.sendRedirect("index.jsp");
    }


}
