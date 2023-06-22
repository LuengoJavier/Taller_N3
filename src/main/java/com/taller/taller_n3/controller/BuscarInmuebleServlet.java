package com.taller.taller_n3.controller;
import com.taller.taller_n3.model.data.dao.InmuebleDAO;
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

@WebServlet(name = "buscarInmuebleServlet", value = "/buscarInmueble")
public class BuscarInmuebleServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/buscarInmueble.jsp");
        respuesta.forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/busquedaInmuebleErroneo.jsp");
        if(req.getParameter("ciudad").length()!=0){
            String ciudad = req.getParameter("ciudad");
            try {
                if(buscarInmueble(ciudad)!=null){
                    req.setAttribute("inmueble",buscarInmueble(ciudad));
                    respuesta = req.getRequestDispatcher("/mostrarInmueble.jsp");
                }
                else{
                    respuesta = req.getRequestDispatcher("/busquedaInmuebleErroneo.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private List buscarInmueble(String ciudad) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("Inmobiliaria_BD");
        List articulos = InmuebleDAO.obtenerInmueble(query,"ciudad",ciudad);
        if(articulos.size()!=0){
            return articulos;
        }else {
            return null;
        }
    }
}