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
	  <h5 class="indigo-text">Please, login into your account</h5>
      <br/>
      <div class="container">
        <div id="lg-wrapper" class="z-depth-1 grey lighten-4 row">

          <form class="col s12" method="post" action="/login">
            <div class="row">
              <div class="col s12">
				<span id="message" class="lg-message"></span>
              </div>
            </div>

            <div class="row">
              <div class="input-field col s12">
                <input name="username" type="text" id="username" class="validate" />
                <label for="username">Enter your email</label>
              </div>
            </div>

            <div class="row">
              <div class="input-field col s12">
                <input name="password" type="password"  id="password" class="validate" />
                <label for="password">Enter your password</label>
                <!-- data-error="wrong" -->
              </div>
            </div>

            <br />
            <div class="row">
                <button type="submit" name="btn_login" class="col s12 btn btn-large waves-effect indigo">Login</button>
            </div>
          </form>
        </div>
      </div>
      <a href="/registration">Create account</a>
      <a href="/match">&nbsp;&nbsp;&nbsp;&nbsp;Match Recipe</a>
	</div>

  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="../../js/materialize/materialize.min.js"></script>
	<script src="../../js/login.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			setMessage("${message}", "${error}");
		});
	</script>

</body>

</html>