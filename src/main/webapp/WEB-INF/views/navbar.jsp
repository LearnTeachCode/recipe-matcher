<!-- Drop down Items -->
<ul id="dropdown1" class="dropdown-content">
  <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
</ul>	

<nav>
   <div class="nav-wrapper">
      <a href="/welcome" class="brand-logo">&nbsp;Home</a>
      
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="/recipes">Recipes</a></li>

		<li>
			<!-- Drop down -->
			<a class="dropdown-button" href="#!" data-activates="dropdown1">
				<i class="large material-icons">perm_identity</i>
				<i class="material-icons right">arrow_drop_down</i>
			</a>
		</li>
      </ul>
   </div>
   
   <!-- Logout Form -->
   <form id="logoutForm" method="POST" action="/logout"></form>
</nav>