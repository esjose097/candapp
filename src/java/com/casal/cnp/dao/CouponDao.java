/**
 * Esta clase representa la DAO de la entidad "coupon"
 */
package com.casal.cnp.dao;

import com.casal.cnp.model.Coupon;
import com.casal.cnp.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jose casal
 */
public class CouponDao {
    /**
     * Método encargado de guardar un coupon en base de datos.
     * @param coupon <-- Coupon a guardar
     */
    public void save(Coupon coupon){
        //Creamos la conexión a Base de datos con el método util.
        Connection connection = ConnectionUtil.getConnection();
        try{
            //Preparamos el statement con la sintaxis SQL que necesitemos en este caso un insert into.
            PreparedStatement statement = connection.prepareStatement("insert into coupon (code,discount,exp_date) values(?,?,?)");
            //Asignamos los valores necesario a el respectivo query.
            statement.setString(1, coupon.getCode());
            statement.setBigDecimal(2, coupon.getDiscount());
            statement.setString(3, coupon.getExpDate());
            //Ejecutamos el Query.
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * Método encargado de buscar en base al parametro "code" una entidad de la base de datos y devolverla
     * en forma de objeto.
     * @param code <-- Código de descuento
     * @return coupon un cupon en caso de encontrarlo en caso de que no un objeto vacio.
     */
    public Coupon findBycode(String code){
        Coupon coupon = new Coupon();
                //Generamos la conexión con el método de utils.
                Connection connection = ConnectionUtil.getConnection();
        try{
            //Preparamos el statement con la sentencia sql que necesitamos en este caso un select
            PreparedStatement statement = connection.prepareStatement("select * from coupon where code =?");
            //Insertamos los datos en el statement en este caso el codigo
            statement.setString(1, code);
            //Ejecutamos el query y guardamos los resultados en la variable resultSet
            ResultSet resultSet = statement.executeQuery();
            //Iteramos los resultados obtenidos.
            while(resultSet.next())
            {
                //Le asignamos los valores obtenidos al objeto "coupon"
                coupon.setId(resultSet.getInt(1));
                coupon.setCode(resultSet.getString(2));
                coupon.setDiscount(resultSet.getBigDecimal(3));
                coupon.setExpDate(resultSet.getString(4));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //Regresamos el coupon.
        return coupon;
    }
}
