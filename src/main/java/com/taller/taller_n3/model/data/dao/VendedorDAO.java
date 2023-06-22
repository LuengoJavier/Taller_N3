package com.taller.taller_n3.model.data.dao;

import com.taller.taller_n3.model.Vendedor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class VendedorDAO {
    public static void registarVendedor(DSLContext query, Vendedor vendedor){
        Table tablaCliente= table(name("Vendedor"));
        Field[] columnas = tablaCliente.fields("rut","nombre","direccion","titulo","estado_civil");
        query.insertInto(tablaCliente, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(vendedor.getRut(),vendedor.getNombre(),vendedor.getDireccion(),vendedor.getTitulo(),vendedor.getEstadoCvil())
                .execute();
    }
    public static List obtenerVendedor(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Vendedor")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaClientes(resultados);
    }
    private static List obtenerListaClientes(Result resultados){
        List<Vendedor> vendedores= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            String titulo = (String) resultados.getValue(fila,"titulo");
            String direccion = (String) resultados.getValue(fila,"direccion");
            String estadoCivil = (String) resultados.getValue(fila,"estado_civil");
            Vendedor vendedor = new Vendedor(nombre,rut,direccion,titulo,estadoCivil);
            vendedores.add(vendedor);
        }
        return vendedores;
    }
}