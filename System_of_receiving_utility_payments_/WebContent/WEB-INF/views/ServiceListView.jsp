<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Service List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Service List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ServiceId</th>
          <th>ServiceName</th>
          <th>Client</th>
          <th>Payment</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${serviceList}" var="service" >
          <tr>
             <td>${service.service_id}</td>
             <td>${service.service_name}</td>
             <td>${service.client}</td>
             <td>${service.payment}</td>
 
             <td>
                <a href="editService?code=${service.service_id}">Edit</a>
             </td>
             <td>
                <a href="deleteService?code=${service.service_id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createService" >Create Service</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>