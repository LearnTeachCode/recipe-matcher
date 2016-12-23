<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recipes</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>

</head>



    
<body>
	
	<h1>Recipe list</h1>
	
	<c:if test="${!empty recipeList}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Name</th>
            	<th width="120">Description</th>
            	<th width="60">Edit</th>
            	<th width="60"></th>
			</tr>
		
			<c:forEach items="${recipeList}" var="recipe">
				<tr>
					<td>${recipe.id}</td>
					<td><a href="/recipedata/${recipe.id}">${recipe.name}</a></td>
					<td>${recipe.description}</td>
					<td><a href="<c:url value='/edit/${recipe.id}'/>">Edit</a></td>
					<td><a href="/remove/${recipe.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	
	
<h1>Add a Recipe</h1>

<c:url var="addAction" value="/recipes/add"/>

<form:form action="${addAction}" commandName="recipe">
    <table>
        <c:if test="${!empty recipe.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty recipe.name}">
                    <input type="submit" value="<spring:message text="Edit Recipe"/>"/>
                </c:if>
                <c:if test="${empty recipe.name}">
                    <input type="submit" value="<spring:message text="Add Recipe"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
 
</body>
</html>