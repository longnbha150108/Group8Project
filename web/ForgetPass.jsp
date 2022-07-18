<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CodePen - Forgot Password - Form</title>
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel="stylesheet" href="css/forgetpass.css">

    </head>
    <body>
        <!-- partial:index.partial.html -->
    <html lang="en">
        <head>
            <style></style>
        </head>
        <body>
            <div class="container-center">
                <center>
                    <img src = "https://i.imgur.com/LaimZqD.png" width="30%" >
                </center>
                <h2>Don't Worry!</h2>
                <form action="forgetpass" method="post">
                    <h4>
                        Just provide your username and your name<br> 
                        and we can do the rest
                    </h4>
                    <h3 style="color: red;text-align: center">${notice}</h3><br>
                    <formgroup>
                        <span>enter your username</span>
                        <input type="text" name="username"/>
                        <label>Username</label>
                    </formgroup>
                    <formgroup>
                        <span>enter your name</span>
                        <input type="text" name="name"/>
                        <label>Name</label>
                    </formgroup>


                    <button id="login-btn">Next</button>



                </form>

                <p>Did you remember? <a href="Login.jsp">Log In</a></p>
            </div>
        </body>
    </html>
    <!-- partial -->
    <script  src="js/forgetpass.js"></script>

</body>
</html>
