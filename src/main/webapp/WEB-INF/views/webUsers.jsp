<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Web Users</title>

	<link rel="stylesheet" href="../../css/materialize/materialize.min.css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../../css/custom.css">
</head>

    
<body>
	<jsp:include page="navbar.jsp" />
	
	<br/>
	<div class="row">
		<div class="col s7">
			<table id="twebusers" class="striped"></table>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/materialize/materialize.min.js"></script>
	<script src="../../js/webUsers.js"></script>
	
	<script>
		$(document).ready(function(){
			getAllWebUsers(${securityRoleTypes});
		});
	</script>

</html>