package com.taller.taller_n3.controller;

import com.taller.taller_n3.model.data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "registrarInmuebleServlet", value = "/registroInmueble")
public class RegistrarInmuebleServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroInmueble.jsp");
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroInmuebleErroneo.jsp");
        if(req.getParameter("id_inmueble").length()!=0 &&
                req.getParameter("tipo_contruccion").length()!=0 && req.getParameter("ubicacion").length()!=0 &&
                req.getParameter("precio").length()!=0){
            int id_inmueble = Integer.parseInt(req.getParameter("id_inmueble"));
            String tipoConstruccion = req.getParameter("tipo_contruccion");
            int precio = Integer.parseInt(req.getParameter("precio"));
            String ubicacion = req.getParameter("ubicacion");
            try {
                if(agregarInmobiliaria(id_inmueble,tipoConstruccion,ubicacion,precio)){
                    req.setAttribute("inmueble",agregarInmueble(id_inmueble,tipoConstruccion,ubicacion,precio));
                    respuesta = req.getRequestDispatcher("/registroLibroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("categorias",obtenerCategorias());
        respuesta.forward(req,resp);
    }
    private boolean agregarLibro(int id_inmueble, String tipoConstruccion, String ubicacion, int precio) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("Inmobiliaria_BD");
        List inmuebles = InmuebleDAO.obtenerInmueble(query,"id_inmueble", id_inmueble);
        if(inmuebles.size()!=0){
            return false;
        }
        else{
            InmuebleDAO.registarInmueble(query,id_inmueble,tipoConstruccion,ubicacion,precio);
            return true;
        }
    }
    public List<Categoria> obtenerCategorias(){
        Connection connection= DBConnector.connection("BibliotecaDB","root","");
        DSLContext query= DSL.using(connection);
        return CategoriaDAO.obtenerCategorias(query);
    }
}