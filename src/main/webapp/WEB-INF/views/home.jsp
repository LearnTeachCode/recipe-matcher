<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<body>

<security:authorize ifAnyGranted="ADMIN">
    <h3>Hi Admin/User</h3>
</security:authorize>

<security:authorize ifAnyGranted="USER">
    <h3>Hi User</h3>
</security:authorize>

<h1>hi!</h1>

<input type="button" value="Get Recipes" onclick="getAllRecipes()">

<ol><!-- blank --></ol>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="../../js/recipe.js"></script>

</body>
</html>