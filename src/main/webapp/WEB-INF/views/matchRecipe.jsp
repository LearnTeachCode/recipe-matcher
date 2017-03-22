<html>

<head>
  <title>Match Recipe!</title>
  
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="../../css/addel/addel.css">
  <link rel="stylesheet" href="../../css/range/jquery.range.css">
</head>

<body>
	<nav>
	   <div class="nav-wrapper">
	      <a href="/match" class="brand-logo">&nbsp;Match Recipe</a>
	      
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="/registration">Register</a></li>
	        <li><a href="/login">Login</a></li>
	      </ul>
	   </div>
	</nav>

	<br/>
	
	<div class="row">
		<div class="col s4" style="margin-left: 6%;">	
			<form class="addel" method="post" action="/match" onSubmit="return toLowerCase();">
                <h2>
                    Recipe
                    <small>Insert your ingredients</small>
                </h2>
                
                <div class="form-group addel-target">
                    <label class="control-label">
                    	<b class="new-ing-label">Ingredient 1</b>
                    </label>
                    
                    <div class="input-group">
                        <input type="text" name="ingredients[]" class="form-control">
                        
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-danger addel-delete">
                                <i class="fa fa-remove"></i>
                            </button>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <br/>
                    <button type="button" class="btn btn-success btn-block addel-add">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
                
                <br/><br/>
                <div class="form-group">	
                    <label class="control-label">
                    	<b>Matching percentage</b>
                    </label> 
                                 
                	<input class="single-slider" name="percentage" type="hidden" value="50"/>
                </div>
                
                <br/><br/>
                <button class="btn waves-effect waves-light" type="submit" name="action">Submit
				</button>
            </form> 
		</div>
		
		<br/>
		<div class="row">
			<div class="col s6" style="margin-left: 6%;">
				  <div id="div-no-matches" class="center collection" style="display: none;">
				    <a href="#!" class="collection-item">No matching recipes were found</a>
				  </div>
				
				<table id="trecipedata" class="bordered highlight"></table>
			</div>
		</div>
	</div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="../../js/materialize/materialize.min.js"></script>
	
  <script src="../../js/addel/addel.jquery.min.js"></script>
  <script src="../../js/matchRecipe.js"></script>
  <script src="../../js/range/jquery.range.js"></script>
  
  <script type="text/javascript">
	$(document).ready(function(){
		var recipesJson = ${matchedList};
		setRecipesData(recipesJson);
		
		$('.single-slider').jRange({
            from: 50,
            to: 100,
            step: 5,
            scale: [50, 60, 70, 80, 90, 100],
            format: '%s',
            width: 300,
            showLabels: true,
            snap: true
        });
	});
  </script>
  
</body>

</html>