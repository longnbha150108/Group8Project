<%-- 
    Document   : Header
    Created on : Jun 27, 2022, 10:00:56 PM
    Author     : trana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css">
        <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="form">            
            <ul class="tab-group">
                <c:if test="${Snotice==null}">
                    <li class="tab active"><a href="#login">Log In</a></li>
                    <li class="tab"><a href="#signup">Sign Up</a></li>
                    </c:if>
                    <c:if test="${Snotice!=null}">
                    <li class="tab"><a href="#login">Log In</a></li>
                    <li class="tab active"><a href="#signup">Sign Up</a></li>
                    </c:if>

            </ul>

            <div class="tab-content">
                <c:if test="${Snotice==null}">
                    <div id="login">   
                        <h1>Welcome Back!</h1>

                        <form action="login" method="post">
                            <div class="field-wrap" style="color: red; text-align: center" >
                                ${Lnotice}
                            </div>
                            <div class="field-wrap">
                                <label>
                                    Username<span class="req">*</span>
                                </label>
                                <input type="text" name="username" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Password<span class="req">*</span>
                                </label>
                                <input type="password" name="password" required autocomplete="off"/>
                            </div>

                            <p class="forgot"><a href="ForgetPass.jsp">Forgot Password?</a></p>

                            <button class="button button-block"/>Log In</button>

                        </form>

                    </div>
                    <div id="signup">   
                        <h1>Sign Up for Free</h1>

                        <form action="signup" method="post">
                            <div class="field-wrap" style="color: red; text-align: center" >
                                ${Snotice}
                            </div>
                            <div class="top-row">
                                <div class="field-wrap">
                                    <label>
                                        First Name<span class="req">*</span>
                                    </label>
                                    <input type="text" name="firstname" required autocomplete="off" />
                                </div>

                                <div class="field-wrap">
                                    <label>
                                        Last Name<span class="req">*</span>
                                    </label>
                                    <input type="text" name="lastname" required autocomplete="off"/>
                                </div>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Username<span class="req">*</span>
                                </label>
                                <input type="text" name="username" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Set A Password<span class="req">*</span>
                                </label>
                                <input type="password" name="password" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Confirm Password<span class="req">*</span>
                                </label>
                                <input type="password" name="re-password" required autocomplete="off"/>
                            </div>
                            <div class="field-wrap">
                                <label>
                                    Image_Link
                                </label>
                                <input type="text" name="image" />
                            </div>
                            <button type="submit" class="button button-block" />Get Started</button>

                        </form>

                    </div> 
                </c:if>
                <c:if test="${Snotice!=null}">
                    <div id="signup">   
                        <h1>Sign Up for Free</h1>

                        <form action="signup" method="post">
                            <div class="field-wrap" style="color: red; text-align: center" >
                                ${Snotice}
                            </div>
                            <div class="top-row">
                                <div class="field-wrap">
                                    <label>
                                        First Name<span class="req">*</span>
                                    </label>
                                    <input type="text" name="firstname" required autocomplete="off" />
                                </div>

                                <div class="field-wrap">
                                    <label>
                                        Last Name<span class="req">*</span>
                                    </label>
                                    <input type="text" name="lastname" required autocomplete="off"/>
                                </div>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Username<span class="req">*</span>
                                </label>
                                <input type="text" name="username" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Set A Password<span class="req">*</span>
                                </label>
                                <input type="password" name="password" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Confirm Password<span class="req">*</span>
                                </label>
                                <input type="password" name="re-password" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Image_Link
                                </label>
                                <input type="text" name="image" />
                            </div>

                            <button type="submit" class="button button-block"/>Get Started</button>

                        </form>

                    </div> 
                    <div id="login">   
                        <h1>Welcome Back!</h1>

                        <form action="login" method="post">
                            <div class="field-wrap" style="color: red; text-align: center" >
                                ${Lnotice}
                            </div>
                            <div class="field-wrap">
                                <label>
                                    Username<span class="req">*</span>
                                </label>
                                <input type="text" name="username" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Password<span class="req">*</span>
                                </label>
                                <input type="password" name="password" required autocomplete="off"/>
                            </div>

                            <p class="forgot"><a href="ForgetPass.jsp">Forgot Password?</a></p>

                            <button class="button button-block"/>Log In</button>

                        </form>

                    </div>

                </c:if>


            </div><!-- tab-content -->

        </div> <!-- /form -->
        <!-- partial -->
        <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script  src="js/login.js"></script>

    </body>
</html>
