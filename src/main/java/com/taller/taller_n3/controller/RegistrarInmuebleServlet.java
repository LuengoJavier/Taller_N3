package com.taller.taller_n3.controller;

import com.taller.taller_n3.model.data.DBGenerator;
import com.taller.taller_n3.model.data.dao.InmuebleDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
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
        if(req.getParameter("id_inmueble").length()!=0 && req.getParameter("tipo_contruccion").length()!=0 && req.getParameter("ubicacion").length()!=0 &&
                req.getParameter("precio").length()!=0 && req.getParameter("ciudad").length()!=0){
            int id_inmueble = Integer.parseInt(req.getParameter("id_inmueble"));
            String tipoConstruccion = req.getParameter("tipo_contruccion");
            int precio = Integer.parseInt(req.getParameter("precio"));
            String ubicacion = req.getParameter("ubicacion");
            String ciudad = req.getParameter("ciudad");
            try {
                if(agregarInmueble(id_inmueble,tipoConstruccion,ciudad,ubicacion,precio)){
                    req.setAttribute("inmueble",agregarInmueble(id_inmueble,tipoConstruccion,ciudad,ubicacion,precio));
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarInmueble(int id_inmueble, String tipoConstruccion,String ciudad, String ubicacion, int precio) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("Inmobiliaria_BD");
        List inmuebles = InmuebleDAO.obtenerInmueble(query,"id_inmueble", id_inmueble);
        if(inmuebles.size()!=0){
            return false;
        }
        else{
            InmuebleDAO.registarInmueble(query,id_inmueble,tipoConstruccion,ciudad,ubicacion,precio);
            return true;
        }
    }
}