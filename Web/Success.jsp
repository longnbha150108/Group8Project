<%-- 
    Document   : Success
    Created on : 08-06-2022, 11:03:14
    Author     : notur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Success !</h1>
        <h1>Hello Account: ${account}</h1>
         <h1>Email: ${email}</h1>
         Password: <input type="password" value="${password}" id="myInput"><br><br>
<input type="checkbox" onclick="myFunction()">Show Password
        
          
        <script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
    </body>
</html>
