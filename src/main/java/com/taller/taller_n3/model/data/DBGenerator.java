package com.taller.taller_n3.model.data;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import java.sql.Connection;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;
public class DBGenerator {
    //Metodo inicial para crear una base de datos y sus respectivas tablas en caso de que no exista
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaInmueble(create);
        crearTablaVendedor(create);
        DBConnector.closeConnection();
    }
    //Metodo para conectarse a una base de datos ya creada
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        return DSL.using(connection);
    }
    //Crea una base de datos en caso de que no exista
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }
    //Actualiza la conexion inicial para conectar a la base de datos
    private static DSLContext actualizarConexion(Connection connection,String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create =DSL.using(connection);
        return create;
    }
    private static void crearTablaInmueble(DSLContext create) {
        create.createTableIfNotExists( "Inmueble")
                .column("id_inmueble", INTEGER.identity(true)).constraint(primaryKey("id_inmueble"))
                .column("tipo_contruccion", VARCHAR(100))
                .column("ubicacion", VARCHAR(70))
                .column("precio", INTEGER).execute();
    }
    public static void crearTablaVendedor(DSLContext create){
        create.createTableIfNotExists("Vendedor")
                .column("rut", VARCHAR(12)).constraint(primaryKey("rut"))
                .column("nombre",VARCHAR(20))
                .column("direccion",VARCHAR(30))
                .column("titulo",VARCHAR(30))
                .column("estado_civil",VARCHAR(20)).execute();
    }
}
