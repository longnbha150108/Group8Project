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
        <title>Header</title>
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <div>
            <ul id="header-nav">
                <li><a href="home">Home</a></li>     
                <li>
                    <form class="search-container" action="listteacher">
                        <input id="search-box" type="text" class="search-box" name="search" />
                        <label for="search-box"><span class="fa-solid fa-magnifying-glass search-icon"></span></label>
                        <input type="submit" id="search-submit" />
                    </form>
                </li>
                <li>
                    <a>Chuyên ngành</a>
                    <ul class="spe">
                        <c:forEach items="${sessionScope.ListS}" var="s">
                            <li><a href="listteacher?sId=${s.id}">${s.name}</a></li>
                            </c:forEach>  
                            <c:if test="${sessionScope.acc.isStaff=='True'}">
                            <li><a href="updatespe?crud=c"><i class="fa-solid fa-plus"></i></a></li>
                            </c:if>
                    </ul>
                </li> 
                <li><a href="teacherdetail?best=on">Best Teacher</a></li>
                    <c:if test="${sessionScope.acc.isStaff=='True'}">
                    <li><a href="ListAccount">Manage Account</a></li>
                    </c:if>   
                    <c:if test="${sessionScope.acc==null}">
                    <li><a href="login">Login</a></li>
                    </c:if>
                    <c:if test="${sessionScope.acc!=null}">
                    <li id="setting">
                        <a href=""><img style="height: 60px; width: 60px;border-radius: 90px" src="${sessionScope.acc.image}"></a>
                        <ul class="setting">
                            <li><a> ${sessionScope.acc.name}</a></li> 
                                    <c:if test="${sessionScope.acc.isStudent=='True'}">
                                <li><a href="listteacher?favor=on">Yêu Thích</a></li> 

                            </c:if>
                            <li><a href='SettingAccount?id=${sessionScope.acc.username}&mod=update"'>Setting</a></li>
                            <li><a href="logout">Logout</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
        <script  src="js/header.js"></script>
    </body>
</html>
