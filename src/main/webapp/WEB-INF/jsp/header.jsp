<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header Page</title>
</head>
<body bgcolor="cyan">

<form>
<div id="menu">
<style>
nav{
background-color:grey;
height: 50px;
}
nav ul{
}
nav ul li{
list-style-type:none;
width:150px;
float: left
}
</style>
<img src="/images/bankImage.png" height="100" width="100"/>&nbsp;
<h1 align="center">WELCOME TO SBI</h1>
<nav>
<ul>
<li><a href="index">Home</a></li>
<li><a href="login">Login</a></li>
<li><a href="editPage">Edit_profile</a></li>
 <li><a href="fundTransferPage">Transfer_money</a></li>
 <li><a href="balance">Balance_Enquiry</a></li>
 <li><a href="changePasswordPage">changePassword</a>
 <li><a href="logout">logout</a>
</ul>
</nav>
<br><br>
</div>

</form>
</body>
</html>






<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<link href="css/bankapplication.css" rel ="stylesheet">
<style>
	  .footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: black;
   color: white;
   text-align: center;
}
</style>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<header>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	     <img src="images/bankImage.png" width="400" height="120"/>
	    </div>
	    <ul class="nav navbar-nav">
	    <c:if test="${sessionScope.customer.customerId==null}">
<!-- 	      <li class="active"><a href="index.jsp">Home</a></li> -->
	     </c:if>
	  
	      <c:if test="${sessionScope.customer.customerId==null}">
<!-- 	      	<li><a href="loginCustomer.jsp">Login</a></li> -->
	      </c:if>
	      <c:if test="${sessionScope.customer.customerId!=null}">
<!-- 	      	<li><a href="balanceEnquiry.jsp">Balance inquiry</a></li> -->
	      </c:if>
	      <c:if test="${sessionScope.customer.customerId!=null}">
<!-- 	      	<li><a href="fundTransfer.jsp">Fund Transfer</a></li> -->
	      </c:if>
	      	
	      <c:if test="${sessionScope.customer.customerId!=null}">
<!-- 	      	<li><a href="changePassword.jsp">Change Password</a></li> -->
	      </c:if>
	      
	      <c:if test="${sessionScope.customer.customerId!=null}">
<!-- 	      	<li><a href="editProfile.jsp">Edit Profile</a></li> -->
	      </c:if>
	      
	      <li class="active"><a href="index">Home</a></li>
	      	<li><a href="login">Login</a></li>
	
	      	<li><a href="balanceEnquiry">Balance inquiry</a></li>
	      	<li><a href="fundTransferPage">Fund Transfer</a></li>
	      	
	      	<li><a href="changePassword">Change Password</a></li>
	      
	      	<li><a href="editProfile">Edit Profile</a></li>
	      
	      
	      
	    </ul>
	  <ul class="nav navbar-nav navbar-right">
	 	<c:if test="${sessionScope.customer.customerName!=null}">
     		<li><a href="displayDetails.jsp"><span class="glyphicon glyphicon-user">${sessionScope.customer.customerName}</span></a></li>
		</c:if>
	  	<c:if test="${sessionScope.customer.customerName!=null}">
     		<li><a href="logout.do"><span class="glyphicon glyphicon-user"></span>Log out</a></li>
		</c:if>
	      <div class="footer">
  <p>All Rights Reserved@2018</p>
</div>

	      
	    </ul>
	  </div>
	</nav>
	</header>
</body>
</html> --%>