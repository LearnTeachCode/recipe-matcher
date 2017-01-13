<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome!</title>

 	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../../css/materialize/materialize.min.css">
</head>

<body>
	
	<%-- Later we can include different navigation bars depending on user roles 
	
	<security:authorize ifAnyGranted="ADMIN">
	    <jsp:include page="admin_navbar.jsp" />
	</security:authorize>

	<security:authorize ifAnyGranted="USER">
	    <jsp:include page="user_navbar.jsp" />
	</security:authorize>
	--%>
	
	<!-- Navigation Bar -->
	<jsp:include page="navbar.jsp" />
	
	
	<br/>
	<div class="container">
		<h3 id="welcome-h3"></h3>
	</div>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/materialize/materialize.min.js"></script>
	<script src="../../js/welcome.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			setValues("${pageContext.request.userPrincipal.name}");
		});
	</script>

</html>