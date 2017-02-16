<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ingredients</title>

	<link rel="stylesheet" href="../../css/materialize/materialize.min.css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

    
<body>
	<jsp:include page="navbar.jsp" />
	
	<br/>
	<div class="row">
		<div class="col s7">
			<table id="tingredients" class="striped"></table>
		</div>
	</div>
	
	<br/><br/>
	<div class="row">
		<form:form class="col s12" action="ingredient/add" commandName="ingredient">
		    <div class="row">
			    <div id="row-id" class="row hide">
			        <div class="input-field col s3">			            
			            <label for="key">ID</label>
			            
			            <input id="key" type="text" name="key" readonly disabled /> 
		                <input id="hidden-key" type="hidden" name="key" disabled /> 			          
			        </div>
			    </div>
			    <div class="row">
			        <div class="input-field col s3">
			          	<label for="name">Name</label>
						<input type="text" name="name" /> 
			        </div>
			    </div>
			    <div class="row">
			        <div class="input-field col s3">
			          	<label for="descr">Description</label>
						<textarea id="descr" class="materialize-textarea" name="description"></textarea>
			        </div>
			    </div>			    
			    <div class="row">
				    <button id="submit-btn" class="btn waves-effect waves-light" type="submit">Add Ingredient
					    <i class="material-icons right">send</i>
					</button>
			    </div>
			</div>
		</form:form>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/materialize/materialize.min.js"></script>
	<script src="../../js/ingredient.js"></script>
	
	<script>
		$(document).ready(function(){
			getAllIngredients();
		});
	</script>

</html>