package com.taller.taller_n3.model.data.dao;

import com.taller.taller_n3.model.Inmueble;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class InmuebleDAO {
    public static void registarInmueble(DSLContext query, int id_inmueble, String tipoConstruccion, String ubicacion, int precio){
        Table tablaLibro= table(name("Inmueble"));
        Field[] columnas = tablaLibro.fields("id_inmueble", "tipo_construccion", "ubicacion", "precio");
        query.insertInto(tablaLibro, columnas[0], columnas[1],columnas[2],columnas[3])
                .values(id_inmueble,tipoConstruccion,ubicacion,precio)
                .execute();
        Inmueble inmueble = new Inmueble(id_inmueble,tipoConstruccion,ubicacion,precio);
    }
    public static List obtenerInmueble(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Libro")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaInmuebles(query, resultados);
    }
    private static List obtenerListaInmuebles(DSLContext query,Result resultados){
        List<Inmueble> inmuebles= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            int id_inmueble = (Integer) resultados.getValue(fila,"id_libro");
            String tipoConstruccion = (String) resultados.getValue(fila,"tipo_contruccion");
            String ubicacion = (String) resultados.getValue(fila,"ubicacion");
            int precio = (Integer) resultados.getValue(fila,"precio");
            inmuebles.add(new Inmueble(id_inmueble,tipoConstruccion,ubicacion,precio));
        }
        return inmuebles;
    }
    public static List<Inmueble> obtenerInmuebles(DSLContext query){
        Result resultados=query.select().from(DSL.table("Inmueble")).fetch();
        List<Inmueble> inmuebles= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            int id_inmueble = (Integer) resultados.getValue(fila,"id_libro");
            String tipoConstruccion = (String) resultados.getValue(fila,"tipo_contruccion");
            String ubicacion = (String) resultados.getValue(fila,"ubicacion");
            int precio = (Integer) resultados.getValue(fila,"precio");
            inmuebles.add(new Inmueble(id_inmueble,tipoConstruccion,ubicacion,precio));
        }
        return inmuebles;
    }
}