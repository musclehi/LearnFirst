<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form class="form-signup" name="form-signup" action="userRegisterAction" role="form" method="post" onsubmit="return check(this)">
    <input type="text" name="username" id="username" class="form-control" placeholder="用户名" required autofocus /><br>
    <input type="password"  name="password" id="password"class="form-control" placeholder="密码" required /><br>
    <input type="password"  name="password_confirm" id="password_confirm" class="form-control" placeholder="确认密码" required /><br>
    <%--<button class="btn btn-lg btn-warning btn-block"  type="submit">注册</button>--%>
    <input type="submit" value="注册">
</form>
<script src="js/login.js"></script>
<script src="js/jquery-1.12.4.js"></script>
<script>
    $(function(){
        var result = <%= request.getAttribute("result")%>
        if(result!=null){
            if(result==202)
                alert("用户已存在");
        }

    });
</script>
</body>
</html>
