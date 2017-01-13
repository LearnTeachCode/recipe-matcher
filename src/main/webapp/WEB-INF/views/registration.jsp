<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
  <title>Log in with your account</title>
  
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
  <link rel="stylesheet" href="../../css/custom.css">
</head>

<body>
  <div class="section"></div>
  <div class="text-center">
	  <h5 class="indigo-text">Create an account</h5>
      <br/>
      <div class="container">
        <div id="lg-wrapper" class="z-depth-1 grey lighten-4 row">
		  <form:form method="POST" modelAttribute="userForm" class="col s12">
            <div class="row">
              <div class="col s12">
				<span id="message" class="lg-message"></span>
              </div>
            </div>
			
            <div class="row">
              <div class="input-field col s12 text-left">                
                <input id="username" name="username" type="text" class="validate">
                <span id="username-error" class="span-field-error"></span>
                <label for="username">Username</label>
              </div>
            </div>

            <div class="row">
              <div class="input-field col s12 text-left">               
                <input name="password" type="text" class="validate">
                <span id="password-error" class="span-field-error"></span>
                <label for="password">Password</label>
              </div>
            </div>
            
            <div class="row">
              <div class="input-field col s12 text-left">      
                <input name="confirmPassword" type="text" class="validate">
                <span id="confirmPassword-error" class="span-field-error"></span>
                <label for="password">Confirm your password</label>
              </div>
            </div>

            <br />
            <div class="row">
                <button type="submit" name="btn_login" class="col s12 btn btn-large waves-effect waves-light">Register</button>
            </div>
          </form:form>
        </div>
      </div>
	</div>

  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/materialize/materialize.min.js"></script>
	<script src="../../js/registration.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			setValues(${errorsjson});		
		});
	</script>
</body>
</html>