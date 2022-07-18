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
           
            
                <h2 style="text-align: center;color:white;">Account</h2>
                <article style="text-align: center" class="block-item">
                    <div class="profile">
                        <figure class="profile-card">  
                            <div>
                                <img src="https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2021/1/31/876188/DH-FPT.jpg" alt="sample87" />
                            </div>

                          
                        </figure>   
                    </div>
                </article> 
          
        </div>
        <div id="content">
            <h1 class="pen-title">Manage Account</h1>
            <!-- Begin Your Code -->

            <table style="margin-left:auto;margin-right:auto;width:100% ">
                 <tr>
                <th style ='color:white;' >Name</th>
                <th style ='color:white;' >Password</th>
                <th style ='color:white;' >Full Name</th>
                
               
                
            </tr>
            <form action="checkEdit" method="Post">
                <tr>
                    <td>
                    
                       
                   
                       <%
                ArrayList<Account> AccountList=new ArrayList<Account>();
                if(request.getAttribute("AccountList")!=null)
                    AccountList=(ArrayList<Account>)request.getAttribute("AccountList");
                
                for(Account itemStudent : AccountList){
                
                if (itemStudent.isIsStaff()==false||itemStudent.isIsStaff()==true&&itemStudent.isIsStudent()==true) {
                
                            
                    out.print("<tr>");
                    out.print("<td  style='text-align:center;'  readonly >"+itemStudent.getUsername()+"</td>");
                       
                          out.print("<td  style='text-align:center;'  readonly >********</td>");
                        out.print("<td  style='text-align:center;'  readonly >"+itemStudent.getName()+"</td>");
                        
                         
//                        out.print("<td  style='text-align:center;'  readonly >"+itemStudent.getName()+"</td>");
                        
                        
                         //out.print("<td onclick='myFunction()' style='text-align:center;' >     <input type='checkbox'  name='thisStaff' readonly='readonly' onclick='return false;' ");
                          
//                         if (itemStudent.isIsStaff()==true) {
//                       out.print("checked ");
//                        out.print("></td>");
//                 }else{
//                           out.print("></td>");
//                           }
//                        out.print("<td  onclick='myFunction()' style='text-align:center;' >   <input  type='checkbox' name='thisStudent' readonly='readonly'  onclick='return false;'");
//                      
//                      if (itemStudent.isIsStudent()==true) {
//                       out.print("checked ");
//                        out.print("> </td>");
//                 }else{
//                           out.print("></td>");
//                           }
                           
                           
                            out.print(" <td style='text-align:center;' ><a href='checkEdit?id="+itemStudent.getUsername()+"&Istaff="+itemStudent.isIsStaff()+"&Istudent="+itemStudent.isIsStudent()+"&mod=update'>Edit</a></td> ");
                            
                            
                            
                             out.print(" <td style='text-align:center;' ><a href='DeleteAccount?id="+itemStudent.getUsername()+"&mod=delete'>Delete</a></td> ");
                           
                     
                    out.print("</tr>");
                }
                }
                 
           %>
                 
                </tr>
              
                </form>
            
            
            </table>
            

                

        </div>
<script>
function myFunction() {
  alert("Please click 'Edit' to manage account !");
}
</script>
    </body>
</html>
