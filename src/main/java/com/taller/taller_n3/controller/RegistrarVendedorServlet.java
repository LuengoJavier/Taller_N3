package com.taller.taller_n3.controller;
import com.taller.taller_n3.model.data.dao.VendedorDAO;
import com.taller.taller_n3.model.Vendedor;
import com.taller.taller_n3.model.data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registroVendedorServlet", value = "/registroVendedor")
public class RegistrarVendedorServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Inmobiliaria_BD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroVendedor.jsp");
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroVendedorErroneo.jsp");
        if(req.getParameter("titulo").length()!=0 && req.getParameter("nombre").length()!=0  &&
                req.getParameter("rut").length()!=0 && req.getParameter("estado_civil").length()==0
        && req.getParameter("direccion").length()==0){
            String nombre = req.getParameter("nombre");
            String titulo = req.getParameter("titulo");
            String ubicacion = req.getParameter("ubicacion");
            String rut = req.getParameter("rut");
            String estadoCivil = req.getParameter("estado_civil");
            Vendedor vendedor = new Vendedor(nombre,rut,ubicacion,titulo,estadoCivil);
            try {
                if(agregarVendedor(vendedor)){
                    req.setAttribute("vendedor",vendedor);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarVendedor(Vendedor vendedor) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("Inmobiliaria_BD");
        List vendedores = VendedorDAO.obtenerVendedor(query,"rut", vendedor.getRut());
        if(vendedores.size()!=0){
            return false;
        }
        else{
            VendedorDAO.registarVendedor(query,vendedor);
            return true;
        }
    }
}