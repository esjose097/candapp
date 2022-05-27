<%-- 
    Document   : findCoupon
    Created on : May 27, 2022, 1:34:53 PM
    Author     : jose casal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find a coupon</title>
    </head>
    <body>
        <header>
            <h1>Find a coupon!</h1>
        </header>
        <form action="CouponController" method="post">
            <pre>
                Coupon code: <input type="text" name="couponCode">
                <input type="hidden" name="action" value="find">
                <input type="submit" value="find">
            </pre>
        </form>        
    </body>
</html>
