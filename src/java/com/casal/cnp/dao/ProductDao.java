/**
 * Clase encargada de representar la DAO de la entidad producto en BD.
 */
package com.casal.cnp.dao;

import com.casal.cnp.model.Product;
import com.casal.cnp.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jose casal
 */
public class ProductDao {
    /**
     * Método encargado de recibir un producto como parametro y guardarlo en base de datos.
     * @param product <-- Producto a guardar.
     */
    public void save(Product product){
        //Creamos la conexión a base de datos con el método util
        Connection connection = ConnectionUtil.getConnection();
        try{
            //Preparamos el statement con la sentencia SQL que necesitamos en este caso un insert into
            PreparedStatement statement = connection.prepareStatement("insert into product (name,description,price) values(?,?,?)");
            //Asignamos los valores necesarios al respectivo query
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBigDecimal(3, product.getPrice());
            //Ejecutamos el query
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
