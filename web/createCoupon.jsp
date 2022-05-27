<%-- 
    Document   : createCoupon
    Created on : May 27, 2022, 1:27:37 PM
    Author     : jose casal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create coupon</title>
    </head>
    <body>
        <header>
            <h1>Create a coupon!</h1>
        </header>
        <form action="couponController" method="post">
            <pre>
                coupon code: <input type="text" name="couponCode">
                Discount: <input type="text" name="discount">
                Expiry date: <input type="text" name="expiryDate">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Save">
            </pre>
        </form>
    </body>
</html>
