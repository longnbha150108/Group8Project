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
            <form id="contact" action="newteacherinfo">
                <h3>${title}</h3><br>
                <c:if test="${t!=null}">
                    <input type="text" name="id" value="${t.id}" readonly>
                </c:if>
                <fieldset>
                    <input placeholder="Teacher name" type="text" name="name" value="${t.name}"  required autofocus>
                </fieldset>
                <input type="radio" name="gender"  value="Male" <c:if test="${t.gender=='Male'}">checked</c:if>>Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="gender" value="Female" <c:if test="${t.gender=='Female'}">checked</c:if>>Female<br>
                    <fieldset>
                        BirthDay&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="dob" value="${t.dob}" required>
                </fieldset>

                <fieldset>
                    <input placeholder="Image Link start with http://" type="url" name="image" value="${t.image}" required>
                </fieldset>
                <fieldset>
                    <textarea placeholder="Introduction" name="intro"  required>${t.intro}</textarea>
                </fieldset>
                Subject&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select name="subId">
                    <c:forEach items="${listSub}" var="sub">
                        <option value="${sub.id}" <c:if test="${t.subId==sub.id}">selected</c:if>>${sub.name}</option>
                    </c:forEach>  
                </select>
                <fieldset>
                    <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
                </fieldset>
            </form>


        </div>
        <!-- partial -->

    </body>
</html>

