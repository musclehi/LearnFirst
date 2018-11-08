<%--
  Created by IntelliJ IDEA.
  User: 11085389
  Date: 2018/11/5
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form class="form-signin" role="form" action="userLoginAction" method="post"accept-charset="UTF-8">
    <input type="text" name="username" class="form-control" placeholder="用户名" required autofocus /><br>
    <input type="password"  name="password" class="form-control" placeholder="密码" required /><br>
    <%--<button  onclick="window.location.href='/register.jsp'">注册</button>--%>
    <button onclick="location.href='/register.jsp'" type="button">注册</button>
    <button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>

</form>
<script src="js/jquery-1.12.4.js"></script>
<script>
    $(function(){
        var result = <%= request.getAttribute("result")%>
        if(result!=null){
            if(result==201)
                alert("用户名或密码错误");
        }

    });
</script>

</body>
</html>
