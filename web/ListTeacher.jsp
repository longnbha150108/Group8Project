<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Teacher</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/listteacher.css">
        <link rel="stylesheet" href="css/format.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" /><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>
    </head>

    <body>
        <div id="header">
            <%@include file='Header.jsp' %> 
        </div>
        <div class="nav">
            <h2 style="text-align: center">${subtittle}</h2>

            <c:if test="${requestScope.ListSpe!=null}">

                <ul>
                    <c:forEach items="${ListSpe}" var="s">
                        <li><a href="listteacher?sId=${s.id}">${s.name}</a></li>
                        </c:forEach>
                        <c:if test="${sessionScope.acc.isStaff=='True'}">
                        <li><a href="updatespe?crud=c"><i class="fa-solid fa-plus"></i></a></li>
                            </c:if>
                </ul>

            </c:if>
            <c:if test="${requestScope.ListSpe==null}">


                <ul>
                    <c:forEach items="${ListSub}" var="sub">
                        <li><a <c:if test="${sub.id==subId}">style="border: 1px;color: blue;background: white"</c:if> href="listteacher?sId=${sub.sId}&subId=${sub.id}">${sub.name}</a></li>
                        </c:forEach>
                        <c:if test="${sessionScope.acc.isStaff=='True'}">
                        <li><a href="updatesubject?crud=c"><i class="fa-solid fa-plus"></i></a></li>
                            </c:if>
                </ul>

            </c:if>
            <c:if test="${bestT.name!=null}">
                <h2 style="text-align: center">Best Teacher</h2>
                <article style="text-align: center" class="block-item">
                    <div class="profile">
                        <figure class="profile-card">  
                            <div>
                                <img src="https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2021/1/31/876188/DH-FPT.jpg" alt="sample87" />
                            </div>

                            <figcaption>
                                <img src="${bestT.image}" alt="profile-sample4" class="profile-img" />
                                <h2>${bestT.name}<span>${bestT.subject}</span></h2>
                                <p>
                                <div class="scroll-bar">${bestT.intro}</div>
                                </p>
                                <a href="teacherdetail?tId=${bestT.id}&subId=${bestT.subId}" class="info">More Info</a>

                            </figcaption>
                        </figure>   
                    </div>
                </article> 
            </c:if>
        </div>
        <div id="content">

            <h1 class="pen-title">${tittle}</h1>

            <!-- Begin Your Code -->

            <section>
                <c:if test="${sessionScope.acc.isStaff=='True'}">
                    <div><a href="updateteacher?cud=create"><i class="fa-solid fa-user-plus"></i></a></div>                                          
                        </c:if>
                <div class="content-container">
                    <c:forEach items="${listT}" var="t">
                        <article class="block-item">
                            <div class="profile">
                                <figure class="profile-card">  
                                    <div>
                                        <img src="https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2021/1/31/876188/DH-FPT.jpg" alt="sample87" />
                                        <c:if test="${sessionScope.acc.isStaff=='True'}">
                                            <div class="option">
                                                <nav class="btn-pluss-wrapper">
                                                    <div href="#" class="btn-pluss">
                                                        <ul>
                                                            <li><a href="updateteacher?cud=update&tId=${t.id}"><i class="fa-solid fa-pen"></i></a></li>
                                                            <li><a href="updateteacher?cud=delete&tId=${t.id}"><i class="fa-solid fa-trash-can"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </nav>
                                            </div>                                               
                                        </c:if>   

                                    </div>

                                    <figcaption>
                                        <img src="${t.image}" alt="profile-sample4" class="profile-img" />
                                        <h2>${t.name}<span>${t.subject}</span></h2>
                                        <p>
                                        <div class="scroll-bar">${t.intro}</div>
                                        </p>
                                        <a href="teacherdetail?tId=${t.id}&subId=${t.subId}" class="info">More Info</a>

                                    </figcaption>
                                </figure>   
                            </div>
                        </article>   

                    </c:forEach>

                </div>
                <c:if test="${empty listT}">
                    ${mess}
                </c:if>
            </section>
            <div style="width: 100%;margin: 20px;text-align: center;float: left">
                <c:forEach begin="1" end="${size}" var="i">
                    <a  <c:if test="${page==i}">style="border: 1px;color: blue;background: white"</c:if> href="listteacher?${link}page=${i}">${i}</a>
                </c:forEach>
            </div>

        </div>
    </body>
</html>
