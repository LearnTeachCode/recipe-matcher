<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Recipe Data</title>

	<link rel="stylesheet" href="../../css/custom.css">
</head>

    
<body>
	<h1>Recipe Details</h1>
	
	<table id="trecipedata" class="tg"></table>
	
	<br/>
	<a href="/recipes">Back</a>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/recipedata.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var recipeJson = ${recipejson};
			setRecipeData(recipeJson);
		});
	</script>

</html>