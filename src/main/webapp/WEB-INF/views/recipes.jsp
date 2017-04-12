<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>
   
	<link rel="stylesheet" href="../../css/materialize/materialize.min.css">
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
	<link rel="stylesheet" href="../../css/recipe.css">	
	<link rel="stylesheet" href="../../css/pagination.css">	
</head>

    
<body>
	<jsp:include page="navbar.jsp" />
	
	<br/>
	<div class="row">
		<div class="col s7">
			<table id="trecipes" class="striped"></table>
		</div>
	</div>
	
	<br/><br/>
	<div class="row">
		<form:form class="col s12" action="recipe/add" commandName="recipe">
		    <div class="row">
			    <div id="row-id" class="row hide">
			        <div class="input-field col s3">			            
			            <label for="key">ID</label>
			            
			            <input id="key" type="text" name="key" readonly disabled /> 
		                <input id="hidden-key" type="hidden" name="key" disabled /> 			          
			        </div>
			    </div>			    
			    <div class="row div-name">
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
				    <button id="submit-btn" class="btn waves-effect waves-light" type="submit">Add Recipe
					    <i class="material-icons right">send</i>
					</button>
			    </div>
			</div>
		</form:form>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
	<script src="../../js/materialize/materialize.min.js"></script>
	<script src="../../js/recipe.js"></script>
		
	<script>
		$(document).ready(function(){
			getAllRecipes();
			
			<sec:authorize access="hasAuthority('ADMIN')">
				makeCall = function(rec_id_array){ 
					$.ajax({
						url: "/recipe/makeOld",
						type: "POST",
						data:'idArray[]='+rec_id_array,
						success: function(data){
						}        
				    });
				}
				
				activate = function(value){										
					$(".div-name").after("<div class='row' id='active-div'><div class='input-field col s3'><select id='sel-enable' name='enabled'><option value='0'>Inactive</option><option value='1'>Active</option></select><label for='enabled'>Active/Inactive</label></div></div>");
					
					if(value) $("#sel-enable>option[value=1]").prop("selected", true);
				}
			</sec:authorize>
		});
	</script>
</html>