<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<form method="get"
  action="${pageContext.request.contextPath}/param4.do">
    <input type="text=" name="username"/>
    <input type="text=" name="age"/>
    <input type="submit"value="test"/>
</form>

</body>
</html>
