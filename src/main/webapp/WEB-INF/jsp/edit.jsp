<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
 <%@include file="header.jsp" %> 
<form action="edit" method="post">
<label>Customer id:</label>
<input type="number" value="${customer.customerId}" name="custId" readonly/>
<br><br>
<label>Customer Name:</label>
<input type="text" name="custName" value="${customer.customerName}" required/>
<br><br>
<label>Password :</label>
<input type="password" name="password" value="${customer.password}" required/>
<br><br>
<input type="submit" value="edit"/>
</form>
</body>
</html>