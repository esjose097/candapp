/**
 * Clase util para la conexión a base de datos.
 */
package com.casal.cnp.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author jose casal
 */
public class ConnectionUtil {
    /**
     * Este método se encarga de devolver una conexión a la base de datos atravez de los
     * recursos de context.xml
     * @return Connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try{
            //Se crea un contexto inicial
            Context context = new InitialContext();
            //Se obtiene el recurso de conexión a la base de datos previamente declarado en el context.xml
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/myds");
            //Se genera la conexión y la guardamos en la variable connection
            connection = dataSource.getConnection();
        }
        catch(NamingException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //Se devuelve la conexión.
        return connection;
    }
}
