<%-- 
    Document   : TeacherDetail
    Created on : Jun 6, 2022, 8:28:16 PM
    Author     : trana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/teacherdetail.css">
        <link rel="stylesheet" href="css/format.css">
        <title>Teacher-Detail</title>
    </head>
    <body>
        <div id="header">
            <%@include file='Header.jsp' %>
        </div>
        <div id="content">
            <div class="wrapper">
                <div class="profile-card js-profile-card">
                    <div class="profile-card__img">
                        <img src="${t.image}" alt="profile card">
                    </div>

                    <div class="profile-card__cnt js-profile-cnt">
                        <div class="profile-card__name">${t.name}</div>
                        <div class="profile-card__txt">${t.subject}</div>
                        <div class="profile-card-loc">
                            <span class="profile-card-loc__icon">
                                <a href=""><i class="fa-solid fa-location-pin"></i></a>
                            </span>

                            <span class="profile-card-loc__txt">
                                Hà Nội
                            </span>
                        </div>

                        <div class="profile-card-inf">
                            <div class="profile-card-inf__item">
                                <div class="profile-card-inf__title">${t.favors}</div>
                                <div class="profile-card-inf__txt">Fovorites</div>
                            </div>

                            <div class="profile-card-inf__item">
                                <div class="profile-card-inf__title">${t.comments}</div>
                                <div class="profile-card-inf__txt">Comments</div>
                            </div>

                            <div class="profile-card-inf__item">
                                <div class="profile-card-inf__title">${t.rate}</div>
                                <div class="profile-card-inf__txt">Vote</div>
                            </div>

                            <div class="profile-card-social">
                                <a href="" class="profile-card-social__item facebook" target="_blank">
                                    <span class="icon-font">
                                        <svg class="icon">
                                        <i class="fa-brands fa-facebook logo"></i>
                                        </svg>
                                    </span>
                                </a>

                                <a href="" class="profile-card-social__item github" target="_blank">
                                    <span class="icon-font">
                                        <svg class="icon">
                                        <i class="fa-solid fa-envelope logo"></i>
                                        </svg>
                                    </span>
                                </a>

                                <a href="" class="profile-card-social__item link" target="_blank">
                                    <span class="icon-font">
                                        <svg class="icon">
                                        <i class="fa-brands fa-youtube logo"></i> 
                                        </svg>
                                    </span>
                                </a>

                            </div>
                            <c:if test="${sessionScope.acc.isStudent=='True'}">
                                <form id="f" action="favor">
                                    <div class="profile-card-ctr">
                                        <button onclick="document.getElementById('f').submit()" class="profile-card__button button--orange">
                                            <c:if test="${favor=='False'}">Favor</c:if>                                        
                                            <c:if test="${favor=='True'}">Dis Favor</c:if>
                                            </button>
                                        </div>
                                    </form>

                            </c:if>

                        </div>
                    </div>
                </div>
            </div>
            <div style="padding: 100px 0" class="flex justify-center items-center">
                <c:if test="${sessionScope.acc.isStudent=='True'}">

                    <div class="w-1/2 p-2 pt-4 rounded">
                        <form id="r" action="rate">
                            <div>
                                <div class="rate-star">

                                    <label class="label-name">Your Rate </label>

                                    <div id="radio" class="star-rate">
                                        <input type="radio" class="star-check" name="stars" value="1" <c:if test="${rate==1}">checked</c:if> onclick="document.getElementById('r').submit()"/>
                                        <input type="radio" class="star-check" name="stars" value="2" <c:if test="${rate==2}">checked</c:if> onclick="document.getElementById('r').submit()"/>
                                        <input type="radio" class="star-check" name="stars" value="3" <c:if test="${rate==3}">checked</c:if> onclick="document.getElementById('r').submit()"/>
                                        <input type="radio" class="star-check" name="stars" value="4" <c:if test="${rate==4}">checked</c:if> onclick="document.getElementById('r').submit()"/>
                                        <input type="radio" class="star-check" name="stars" value="5" <c:if test="${rate==5}">checked</c:if> onclick="document.getElementById('r').submit()"/>
                                            <div class="stars">
                                                <span><i data-star-value="1" class="fa fa-star"></i></span>
                                                <span><i data-star-value="2" class="fa fa-star"></i></span>
                                                <span><i data-star-value="3" class="fa fa-star"></i></span>
                                                <span><i data-star-value="4" class="fa fa-star"></i></span>
                                                <span><i data-star-value="5" class="fa fa-star"></i></span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </form>

                            <form action="newcomment" method="post">
                                <div class="flex ml-3">
                                    <div class="mr-3">
                                        <img width="50px" height="50px" src="${sessionScope.acc.image}" alt="" class="rounded-full">
                                </div>
                                <div>
                                    <h1 style="width: 350px" class="font-semibold">${sessionScope.acc.name}</h1>
                                </div>

                            </div>

                            <div>
                                <textarea style="width: 700px; height: 230px" name="content" placeholder="Write something...">${content}</textarea>
                            </div>

                            <div class="flex justify-between mx-3">
                                <div><button class="px-4 py-1 bg-gray-800 text-white rounded font-light hover:bg-gray-700">Submit</button>

                                </div>
                            </div>
                        </form>
                    </div>
                </c:if>
                <c:if test="${listC.size()==0}">
                    <div class="comment" style="padding-top: 120px;">
                        <ul class="cards">
                            <li class="card">
                                <p style="font-size: 20px;">No comments</p>
                            </li>
                        </ul>
                    </div>
                </c:if>
                <div class="comment" style="padding-top: 120px;">
                    <ul class="cards">
                        <c:forEach items="${listC}" var="c">
                            <li class="card">
                                <h1 style="font-weight: 500;font-size: 30px;font-weight:500 ; color: #f39c12">${c.author}</h1>
                                <c:if test="${sessionScope.acc.username==c.username}">
                                    <div id="option">
                                        <nav class="btn-pluss-wrapper">
                                            <div href="#" class="btn-pluss">
                                                <ul>
                                                    <li><a href="updatecomment?ud=edit&cId=${c.id}"><i class="fa-solid fa-pen"></i></a></li>
                                                    <li><a href="updatecomment?ud=delete&cId=${c.id}"><i class="fa-solid fa-trash-can"></i></a></li>
                                                </ul>
                                            </div>
                                        </nav>
                                    </div>
                                </c:if>
                                <c:if test="${sessionScope.acc.isStaff=='True'}">
                                    <div id="option">
                                        <nav class="btn-pluss-wrapper">
                                            <div href="#" class="btn-pluss">
                                                <ul>
                                                    <li><a href="updatecomment?ud=delete&cId=${c.id}"><i class="fa-solid fa-trash-can"></i></a></li>
                                                </ul>
                                            </div>
                                        </nav>
                                    </div>
                                </c:if>
                                <p style="font-size: 20px;">${c.content}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

        </div>
        <!-- partial -->
        <script src='https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.0/js/mdb.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/cash/1.3.0/cash.min.js'></script><script  src="js/teacherdetail.js"></script>
    </body>
</html>
