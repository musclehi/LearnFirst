<%--
  Created by IntelliJ IDEA.
  User: 11085389
  Date: 2018/11/6
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游戏管理</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/navigation.css">
</head>
<body>
<div class="top">

        <ul>
            <li><a href="#">欢迎登录：<%= session.getAttribute("username")%></a></li>
            <li>
                <a href="#">操作</a>
                <ul>
                    <li><a href="/userLogoutAction">退出登录</a></li>
                </ul>
            </li>
        </ul>

</div>

<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">添加游戏</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">添加游戏</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="addGameAction" method="post">
                    <div class="form-group">
                        <label for="type" class="col-sm-4 control-label">类型</label>
                        <div class="col-sm-6">
                            <%--<input type="text" class="form-control" id="type" placeholder="请输入类型">--%>
                            <select class="form-control" id="type" name="type">
                                <option value="1">角色扮演</option>
                                <option value="2">动作冒险</option>
                                <option value="3">飞行射击</option>
                                <option value="4">休闲益智</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="icon" class="col-sm-4 control-label">icon</label>
                        <div class="col-sm-6">
                            <input type="file" id="icon" name="icon">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-4 control-label">游戏名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入游戏名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="developer" class="col-sm-4 control-label">开发者</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="developer" name="developer"
                                   placeholder="请输入开发者">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="state" class="col-sm-4 control-label">状态</label>
                        <div class="col-sm-6">
                            <select class="form-control" id="state" name="state">
                                <option value="1">已上架</option>
                                <option value="0">未上架</option>
                            </select>
                            <%--<input type="text" class="form-control" id="state" placeholder="请输入姓">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="autoupdate" class="col-sm-4 control-label">自动更新</label>
                        <div class="col-sm-6">
                            <%--<input type="text" class="form-control" id="autoupdate" placeholder="请输入姓">--%>
                            <select class="form-control" id="autoupdate" name="autoupdate">
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="isofficial" class="col-sm-4 control-label">是否官方</label>
                        <div class="col-sm-6">
                            <%--<input type="text" class="form-control" id="isofficial" placeholder="请输入姓">--%>
                            <select class="form-control" id="isofficial" name="isofficial">
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dateissued" class="col-sm-4 control-label">发布时间</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="dateissued" name="dateissued"
                                   placeholder="请输入时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="updatetime" class="col-sm-4 control-label">更新时间</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="updatetime" name="updatetime"
                                   placeholder="请输入时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activecomment" class="col-sm-4 control-label">好评数</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="activecomment" name="activecomment"
                                   placeholder="请输入好评数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="downloadnum" class="col-sm-4 control-label">下载量</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="downloadnum" name="downloadnum"
                                   placeholder="请输入下载量">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">添加</button>
                    </div>
                </form>
            </div>
            <%--<div class="modal-footer">--%>
            <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
            <%--<button type="submit" class="btn btn-primary">提交更改</button>--%>
            <%--</div>--%>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--模态框end--%>
<%--　<%List<Game> list = (List<Game>)request.getAttribute("gamelist");%>--%>
<div>
    　<button class="btn btn-primary" data-toggle="modal" data-target="#myModal"style="margin-top: 30px;">添加游戏</button>
</div>

<table style="width:80%; margin-left: 30px;">
    　　
</table>
<script src="js/jquery-1.12.4.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function () {
        $.ajax({
            type: "POST",
            url: "gameList",
            beforeSend: function () {
                //some js code
            },
            success: function (data) {
                var jsondatas = eval(data)
                $("table").empty();

                $("table").append(" <tr><td>游戏ID</td><td>分类</td><td>icon</td><td>游戏名称</td><td>开发者</td><td>状态</td><td>自动更新</td>        　　　　　　\n" +
                    "<td>是否官方</td><td>上次操作时间</td><td>上架时间</td><td>更新时间</td><td>好评数</td><td>总下载量</td></tr>");
                $.each(jsondatas, function (i, item) {//遍历

                    //通过 Jsondates[i].name 可以取出json里面的值

                    var tr = $("<tr><td>" + jsondatas[i]['id'] + "</td><td>" + jsondatas[i]['type'] + "</td><td>" + jsondatas[i]['icon'] + "</td>" +
                        "<td>" + jsondatas[i]['name'] + "</td><td>" + jsondatas[i]['developer'] + "</td><td>" + jsondatas[i]['state'] + "</td>" +
                        "<td>" + jsondatas[i]['autoUpdate'] + "</td><td>" + jsondatas[i]['isOfficial'] + "</td><td>" + jsondatas[i]['operateTime'] + "</td>" +
                        "<td>" + jsondatas[i]['dateIssued'] + "</td><td>" + jsondatas[i]['updateTime'] + "</td><td>" + jsondatas[i]['activeComment'] + "</td>" +
                        "<td>" + jsondatas[i]['downloadNum'] + "</td></tr>");
                    //动态生成列表

                    $("table").append(tr);

                });

                $("table").append("<tr><td><button onclick=\"previous()\">上一页</button></td><td><button onclick=\"next()\">下一页</button></td></tr>");

            },
            error: function () {
                console.log("error")
            }
        })
    });

    function previous() {
        $.ajax({
            type: "POST",
            <%--url: "gameList?action=previous&page=" +<%=request.getParameter("page")%>,--%>
            url: "gameList?action=previous",
            beforeSend: function () {
                //some js code
            },
            success: function (data) {
                // console.log(data)
                var jsondatas = eval(data)
                console.log(data)
                $("table").empty();

                $("table").append(" <tr><td>游戏ID</td><td>分类</td><td>icon</td><td>游戏名称</td><td>开发者</td><td>状态</td><td>自动更新</td>        　　　　　　\n" +
                    "<td>是否官方</td><td>上次操作时间</td><td>上架时间</td><td>更新时间</td><td>好评数</td><td>总下载量</td></tr>");
                $.each(jsondatas, function (i, item) {//遍历

                    //通过 Jsondates[i].name 可以取出json里面的值

                    var tr = $("<tr><td>" + jsondatas[i]['id'] + "</td><td>" + jsondatas[i]['type'] + "</td><td>" + jsondatas[i]['icon'] + "</td>" +
                        "<td>" + jsondatas[i]['name'] + "</td><td>" + jsondatas[i]['developer'] + "</td><td>" + jsondatas[i]['state'] + "</td>" +
                        "<td>" + jsondatas[i]['autoUpdate'] + "</td><td>" + jsondatas[i]['isOfficial'] + "</td><td>" + jsondatas[i]['operateTime'] + "</td>" +
                        "<td>" + jsondatas[i]['dateIssued'] + "</td><td>" + jsondatas[i]['updateTime'] + "</td><td>" + jsondatas[i]['activeComment'] + "</td>" +
                        "<td>" + jsondatas[i]['downloadNum'] + "</td></tr>");
                    //动态生成列表

                    $("table").append(tr);

                });
                $("table").append("<tr><td><button onclick=\"previous()\">上一页</button></td><td><button onclick=\"next()\">下一页</button></td></tr>");

            },
            error: function () {
                console.log("error")
            }
        })
    }

    function next() {
        $.ajax({
            type: "POST",
            url: "gameList?action=next",
            beforeSend: function () {
                //some js code
            },
            success: function (data) {
                // console.log(data)
                var jsondatas = eval(data)
                console.log(data)
                $("table").empty();

                $("table").append(" <tr><td>游戏ID</td><td>分类</td><td>icon</td><td>游戏名称</td><td>开发者</td><td>状态</td><td>自动更新</td>        　　　　　　\n" +
                    "<td>是否官方</td><td>上次操作时间</td><td>上架时间</td><td>更新时间</td><td>好评数</td><td>总下载量</td></tr>");
                $.each(jsondatas, function (i, item) {//遍历

                    //通过 Jsondates[i].name 可以取出json里面的值

                    var tr = $("<tr><td>" + jsondatas[i]['id'] + "</td><td>" + jsondatas[i]['type'] + "</td><td>" + jsondatas[i]['icon'] + "</td>" +
                        "<td>" + jsondatas[i]['name'] + "</td><td>" + jsondatas[i]['developer'] + "</td><td>" + jsondatas[i]['state'] + "</td>" +
                        "<td>" + jsondatas[i]['autoUpdate'] + "</td><td>" + jsondatas[i]['isOfficial'] + "</td><td>" + jsondatas[i]['operateTime'] + "</td>" +
                        "<td>" + jsondatas[i]['dateIssued'] + "</td><td>" + jsondatas[i]['updateTime'] + "</td><td>" + jsondatas[i]['activeComment'] + "</td>" +
                        "<td>" + jsondatas[i]['downloadNum'] + "</td></tr>");
                    //动态生成列表

                    $("table").append(tr);

                });
                $("table").append("<tr><td><button onclick=\"previous()\">上一页</button></td><td><button onclick=\"next()\">下一页</button></td></tr>");

            },
            error: function () {
                console.log("error")
            }
        })
    }
</script>
</body>
</html>
