<%-- 
    Document   : CreateUpdateTeacher
    Created on : Jul 10, 2022, 3:14:16 AM
    Author     : trana
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="css/createupdate.css">

    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="container">  
            <form id="contact" action="newspeinfo">
                <h3>${title}</h3><br>
                <h4 style="color: red">${mess}</h4><br>
                <fieldset>

                    <input placeholder="Specialization id" type="text" name="speId" value="${t.id}"<c:if test="${t!=null}"> readonly </c:if> required autofocus>
                    </fieldset>

                    <fieldset>
                        <input placeholder="Specialization name" type="text" name="speName" value="${t.name}"  required autofocus>
                </fieldset>
                <fieldset>
                    <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
                </fieldset>
            </form>


        </div>
        <!-- partial -->

    </body>
</html>

