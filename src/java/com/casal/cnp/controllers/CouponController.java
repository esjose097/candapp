/**
 * Servlet encargado de manejar las peticiones de "Coupon"
 */
package com.casal.cnp.controllers;

import com.casal.cnp.dao.CouponDao;
import com.casal.cnp.model.Coupon;
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
public class CouponController extends HttpServlet {
    private CouponDao dao = new CouponDao();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("create"))
        {
            this.createCoupon(request, response);
        }
        else if(action.equals("find"))
        {
            this.findCoupon(request, response);
        }
    }
    
    private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Obtenemos los datos de la request
        String couponCode = request.getParameter("couponCode");
        String discount = request.getParameter("discount");
        String expiryDate = request.getParameter("expiryDate");
        //Creamos una instancia de Coupon
        Coupon coupon = new Coupon();
        //Le asignamos los valores a coupon
        coupon.setCode(couponCode);
        coupon.setDiscount(new BigDecimal(discount));
        coupon.setExpDate(expiryDate);
        //Guardamos el coupon en base de datos
        dao.save(coupon);
        //Generamos la response
        //Asignamos el tipo de contenido
        response.setContentType("text/html");
        //Guardamos el writer en una variable
        PrintWriter out = response.getWriter();
        out.print("<b>Product created!!</b>");
        out.print("<br/><a href='/candpapp'>Home</a>");        
    }
    
    private void findCoupon(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String couponCode = request.getParameter("couponCode");
        Coupon coupon = dao.findBycode(couponCode);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<b>Coupon details: </b>");
        out.print(coupon);
        out.print("<br/><a href='/candapp'>Home</a>");
    }
}
