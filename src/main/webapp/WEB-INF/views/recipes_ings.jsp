<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Recipes-Ingredients</title>

	<link rel="stylesheet" href="../../css/materialize/materialize.min.css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<link rel="stylesheet" href="../../css/addel/addel.css">
	
	<link rel="stylesheet" href="../../css/pickList/pickList.css">
	<link rel="stylesheet" href="../../css/recipes-ingredients.css">
	<link rel="stylesheet" href="../../css/pagination.css">	
</head>

    
<body>
	<jsp:include page="navbar.jsp" />
	
	<br/>
	<div class="row">
		<div class="col s3">
			<h2>Recipes</h2>
	        <h5>Select a recipe to update it's ingredients</h5>
		
			<table id="trecipes" class="striped"></table>
		</div>
	
		<div class="div-ings col s6">
			<h2 class="panel-title">Ingredients</h2>
			<br/><br/>
			
			<div class="panel-body">
               <div id="pickList"></div>
            </div>
            
            <input type="hidden" id="recipe-id" name="recipe_id" value="" />
            <input type="submit" id="submit-btn" name="submit" value="Update" class="input-sumbit" />
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
	<script src="../../js/materialize/materialize.min.js"></script>
	
	<script src="../../js/recipes_ings.js"></script>	
	<script src="../../js/pickList/pickList.js"></script>
	
	<script>
		var recIngsMap = new Object();
		var ingsMap = new Object();
		
		$(document).ready(function(){
			getRecipesIngs();
		});
		
		var pick = $("#pickList").pickList();
	</script>
	
</html>