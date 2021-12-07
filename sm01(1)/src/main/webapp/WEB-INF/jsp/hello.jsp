<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 2021/11/26
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello, ${sessionScope.user.username}!</h1>C
</div>
<p>${CRUDmsg}</p>
<a href="${pageContext.request.contextPath}/user/welcome.do">返回欢迎页面</a>
</div>
<div>
    <form action="${pageContext.request.contextPath}/user/upload.do" enctype="multipart/form-data"method="post">
        上传头像<input type="file" name="images"><br>
        <input type="submit" value="上传">
    </form>
</div>
<div>
    <form action="${pageContext.request.contextPath}/user/upload2.do" enctype="multipart/form-data"method="post">
    上传图片1:<input type="file" name="images"><br>
    上传图片2:<input type="file" name="images"><br>
    上传图片3:<input type="file" name="images"><br>
    <input type="submit"value="上传">
</form>
    </div>
</body>
</html>
