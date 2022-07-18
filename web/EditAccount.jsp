<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>


<%@page import="java.util.ArrayList" %>
<%@page import="Model.Account" %>
<%@page import="DAL.AccountDAO" %>
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


             <c:forEach items="${AccountList}" var="t"> 
            <h2 style="text-align: center;color:white;">${t.getName()}</h2>
            <article style="text-align: center" class="block-item">
                <div class="profile">
                    <figure class="profile-card">  
                        <div>
                             
                            
                                 <img src="${t.getImage()}" alt="sample87" />
                      
                                
                            </c:forEach>
                            
                        </div>


                    </figure>   
                </div>
            </article> 

        </div>
        <div id="content">
            <h1 class="pen-title" >Manage Account</h1>
            <!-- Begin Your Code -->

            <form action="checkEdit" method="Post" >
                <table border="1"style="margin-left: -20px;margin-right:auto;width: 100%" >
                    <tr>
                        <th style="color:white;">UserName</th>
                        <th style="color:white;">PassWord</th>

                        <th style="color:white;" >Full Name</th>
                        <th style="color:white;">Image</th>
                       <th style="color:white;">is Staff</th>
                       <th style="color:white;">is Student</th>
                       
                        
                        
                        



                    </tr>

                    <tr>




                        <%
                 ArrayList<Account> AccountList=new ArrayList<Account>();
                 if(request.getAttribute("AccountList")!=null)
                     AccountList=(ArrayList<Account>)request.getAttribute("AccountList");
                
                 for(Account itemStudent :AccountList){
                     out.print("<tr  style='text-align:center;' > ");
                       //  out.print("<td>"+itemStudent.getUsername()+"</td>");
                         out.print("<td style='background-color: #F9A653;'> <input type='text' style='  text-align:center;    border: none;  background-color: transparent; resize: none;  outline: none;'   readonly   name='username' value='"+itemStudent.getUsername()+ "'></td>");
                          out.print("<td style='background-color: #F9A653;'> <input type='password' style=' text-align:center;   border: none;  background-color: transparent; resize: none;  outline: none;'      name='password' value='"+itemStudent.getPassword()+"'></td>");
                            out.print("<td style='background-color: #F9A653;'> <input type='text' style='   text-align:center;  border: none;  background-color: transparent; resize: none;  outline: none;'      name='fullname' value='"+itemStudent.getName()+"'></td>");
                                                    out.print("<td style='background-color: #F9A653;'> <input type='text' style='  text-align:center;    border: none;  background-color: transparent; resize: none;  outline: none;'      name='image' value='"+itemStudent.getImage()+"'></td>");

                        
                        //  if (itemStudent.isIsStaff()==true) {     
                          out.print("<td style='text-align:center;'>     <input type='checkbox'  name='thisStaff'  ");
                          
                           if (itemStudent.isIsStaff()==true) {
                        out.print("checked ");
                         out.print("></td>");
                  }else{
                            out.print("></td>");
                            }
                         out.print("<td style='text-align:center;'>   <input  type='checkbox' name='thisStudent' ");
                      
                       if (itemStudent.isIsStudent()==true) {
                        out.print("checked ");
                         out.print("> </td>");
                  }else{
                            out.print("></td>");
                            }
                           // }
                           
                           
                     
                     out.print("</tr>");
                 }
                
                 
                        %>

                    </tr>
                </table>


                </br>
                
                
          
                                 <input type="submit" name="submit" value="Save" > 
                          
                
               

                <button type="button" > <a href='ListAccount'>Back</a></button>

            </form>




        </div>

    </body>
</html>
