package Controlador;

import Modelo.Banco;
import ModeloDAO.BancoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controlador")
public class Controlador extends HttpServlet {
    String listar="Vista/listar.jsp";
    String agregar="Vista/agregar.jps";
    String actualizar="Vista/actualizar.jsp";
    Banco ban =new Banco();
    BancoDAO Bdao=new BancoDAO();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso="";
        String action= request.getParameter(" accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;

        }else if (action.equalsIgnoreCase("agregar")){
            acceso=agregar;
        }

        else if(action.equalsIgnoreCase("add")){
            String codigo=request.getParameter("frcodigo");
            String nombre=request.getParameter("frnombre");
            ban.setBan_id(codigo);
            ban.setBan_nom(nombre);
            Bdao.agregar(ban);
            acceso=listar;

        }else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("idban",request.getParameter("ban_nit"));
            acceso=actualizar;
        }

        else if (action.equalsIgnoreCase("actualizar")){
            String codigo=request.getParameter("frcodigo");
            String nombre=request.getParameter("frnombre");
            ban.setBan_id(codigo);
            ban.setBan_nom(nombre);
            Bdao.actualizar(ban);
            acceso=listar;

        }else if (action.equalsIgnoreCase("eliminar")){
            String ban_nit=request.getParameter("ban_nit");
            ban.setBan_id(ban_nit);
            Bdao.eliminar(ban_nit);
            acceso=listar;

        }
        RequestDispatcher vista= request.getRequestDispatcher(acceso);
        vista.forward(request,response);

    }
}
