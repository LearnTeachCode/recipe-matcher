<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>

	<link rel="stylesheet" href="../../css/custom.css">
</head>

    
<body>
	
	<h1>Recipe list</h1>

	<table id="trecipes" class="tg"></table>

	<br/>
	<form:form action="recipe/add" commandName="recipe">
	    <table> 
	        <tr id="row-id" class="hidden">
	            <td>
	                <label>ID</label>
	            </td>
	            <td>
	                <input id="key" type="text" name="key" readonly disabled /> 
	                <input id="hidden-key" type="hidden" name="key" disabled /> 
	            </td>
	        </tr> 
	        <tr>
	            <td>
	                <label>Name</label>
	            </td>
	            <td>
	                <input type="text" name="name" /> 
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <label>Description</label>
	            </td>
	            <td>
	                <textarea id="descr" name="description"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2">
	                <input id="submit-btn" type="submit" value="Add Recipe" />
	            </td>
	        </tr>
	    </table>
	</form:form>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/recipe.js"></script>
	
	<script>
		$(document).ready(function(){
			getAllRecipes();
		});
	</script>

</html>