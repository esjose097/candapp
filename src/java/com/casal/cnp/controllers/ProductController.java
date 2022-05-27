/**
 * Servlet encargado de manejar las peticiones que tengan que ver con la entidad product.
 */
package com.casal.cnp.controllers;

import com.casal.cnp.dao.CouponDao;
import com.casal.cnp.dao.ProductDao;
import com.casal.cnp.model.Coupon;
import com.casal.cnp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose casal
 */
public class ProductController extends HttpServlet {
    //Importamos las DAO que se necesitaran
    CouponDao couponDao = new CouponDao();
    ProductDao productDao = new ProductDao();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos los datos del formulario atravez de los parameters de la request
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String couponCode = request.getParameter("couponCode");
        //Con el parametro couponCode obtenemos el coupon de la BD atravez de la couponDao
        Coupon coupon = couponDao.findBycode(couponCode);
        //Creamos una instancia de un producto
        Product product = new Product();
        //Le asignamos sus valores al producto.
        product.setName(name);
        product.setDescription(description);
        //Se le asigna el respectivo descuento atravez de un "BigDecimal" en base al coupon que se haya introducido.
        product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
        //Guardamos el producto en BD
        productDao.save(product);
        //Establecemos el contentType de la response
        response.setContentType("text/html");
        //Imprimimos la response.
        PrintWriter out = response.getWriter();
        out.print("<b>Product created! </b>");
        out.print("<br/><a href='/candapp'>Home</a>");
    }
}
