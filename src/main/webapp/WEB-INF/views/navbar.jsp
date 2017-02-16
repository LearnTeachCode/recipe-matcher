<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- Drop down Items -->
<ul id="dropdown1" class="dropdown-content">
  <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
</ul>

<!-- Admin manage dropdown items -->
<ul id="dropdown2" class="dropdown-content">
  <li><a href="/manage/ingredients">Users</a></li>
  <li><a href="/manage/recipes-ingredients">Rec-Ings</a></li>
  <li><a href="/manage/ingredients">Ingredients</a></li>
</ul>	

<nav>
   <div class="nav-wrapper">
      <a href="/welcome" class="brand-logo">&nbsp;Home</a>
      
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="/recipes">Recipes</a></li>

		<!-- If user has admin role show manage dropdown -->
		<sec:authorize access="hasAuthority('ADMIN')">
		    <li>
		    	<a class="dropdown-button" href="#!" data-activates="dropdown2">
		    	Manage<i class="material-icons right">arrow_drop_down</i>
		    	</a>
		    </li>
		</sec:authorize>


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