<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Recipe Data</title>

	<link rel="stylesheet" href="../../css/materialize/materialize.min.css">
</head>

<body>
	<nav>
	   <div class="nav-wrapper">
	      <a href="/recipes" class="brand-logo">&nbsp;Recipes</a>
	   </div>
	</nav>
	
	<br/>
	<div class="row">
		<div class="col s6">
			<table id="trecipedata" class="bordered highlight"></table>
		</div>
	</div>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/recipedata.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var recipeJson = ${recipejson};
			setRecipeData(recipeJson);
		});
	</script>

</html>