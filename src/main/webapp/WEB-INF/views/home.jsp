<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<body>

<security:authorize ifAnyGranted="ADMIN">
    <h3>Hi Admin/User</h3>
</security:authorize>

<security:authorize ifAnyGranted="USER">
    <h3>Hi User</h3>
</security:authorize>

</body>
</html>