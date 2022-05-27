<%-- 
    Document   : createProduct
    Created on : May 27, 2022, 1:33:02 PM
    Author     : jose casal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
    </head>
    <body>
        <header>
            <h1>Create a product!</h1>
        </header>
        <form>
            <pre>
                Product name: <input type="text" name="name">
                Description: <input type="text" name="description">
                Price: <input type="text" name="price">
                Coupon code: <input type="text" name="couponCode">
                <input type="submit" value="Save">
            </pre>
        </form>
    </body>
</html>
