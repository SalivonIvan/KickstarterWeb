<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="faq" method="post">
            <p>Enter your questions:</p>
            <textarea name="faq" rows="10" cols="60" >
            </textarea><br>
            <input type="submit" value="Submit" />
        </form>
        <form action="payment">
            <p>select payment method</p>
            <input type="radio" name="payment" value="1$" />Make a contribution of 1$<br>
            <input type="radio" name="payment" value="10$" />Make a contribution of 10$<br>
            <input type="radio" name="payment" value="40$" />Make a contribution of 40$<br>
            <input type="radio" name="payment" value="" />to contribute in any $<br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
