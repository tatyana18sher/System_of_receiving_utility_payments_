<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Service</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Service</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty service}">
         <form method="POST" action="${pageContext.request.contextPath}/editService">
            <input type="hidden" name="service_id" value="${service.service_id}" />
            <table border="0">
               <tr>
                  <td>ServiceId</td>
                  <td style="color:red;">${service.service_id}</td>
               </tr>
               <tr>
                  <td>ServiceName</td>
                  <td><input type="text" name="service_name" value="${service.service_name}" /></td>
               </tr>
               <tr>
                  <td>Client</td>
                  <td><input type="text" name="client" value="${service.client}" /></td>
               </tr>
               <tr>
                  <td>Payment</td>
                  <td><input type="text" name="payment" value="${service.payment}" /></td>
               </tr>
        
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/serviceList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>