<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="lab.io.rush.model.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>莫阿娜购票网，一网打尽好电影！</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/header.css">
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/operation.js"></script>
	<script type="text/javascript" src="js/function.js"></script>
	
	<!--  
	<script type="text/javascript">
	    $(function(){
	       setInterval("refreshPage()",3000);
        });
	</script>-->
  </head>
  
  <body>
    <div id="header" class="all_top">
       <div class="top">
           <div class="top_left"></div>
           <div class="top_right">
              <% User user = (User)session.getAttribute("user");
                 if(user != null){%>
                 <div class="emailInfo">欢迎您，<%= user.getEmail() %></div>
                 <div class="loginStatus" onclick="logout()">注销</div>
               <%}else{%>
                 <div class="emailInfo"></div>
                 <div class="loginStatus" onclick="pop_loginBox()">登录</div>
               <%} %>
		      <div id="updown"></div>
	       </div>
       </div>
    </div>
    <div id="cover" style="display: none"></div>
    <div id="loginBox" style="display:none;">
       <div class="login_title">
           <div class="title_logo">
               <div id="title_logo_word"><a>登录</a></div>
               <div id="close" onclick="close_loginBox()"></div>
           </div>
       </div>
       <div class="login_content" style="height:85%;">
           <div class="usernameDiv">
              <a>用户名:</a>&nbsp;<input type="text" name="username">
           </div>
           <div class="passwordDiv">
              <a>密&nbsp;&nbsp;&nbsp;码:</a>&nbsp;<input type="password" name="password">
           </div>
           <div class="loginDiv">
              <input type="button" value="登 录" onclick="login();">
           </div>
           <div class="goRegDiv">
              <a onclick="switchDiv();">没有帐号？免费注册  >></a>
           </div>
       </div>
       <div class="register_content" style="height:85%;display: none">
           <div class="emailDiv">
              <a>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</a>&nbsp;
              <input type="text" name="email">
           </div>
           <div class="passwordDiv">
              <a>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</a>&nbsp;
              <input type="password" name="password">
           </div>
           <div class="repasswordDiv">
              <a>重复密码:</a>&nbsp;<input type="password" name="password">
           </div>
           <div class="registerDiv">
              <input type="button" value="注 册" onclick="registerUser();">
           </div>
           <div class="gologinDiv">
              <a onclick="switchDiv();"><< 返回登录</a>
           </div>
       </div>
    </div>
    <div id="main" class="all_buttom">
       <div class="main_top"></div>
       <div class="main_buttom">
          <div class="content">
              <div id="movie_name" class="movie">
                  <h2>阿凡达2(Avatar 2)</h2>
              </div>
              <div id="movie_intro" class="movie">
                  <a><b>电影简介:</b>《阿凡达2》是电影《阿凡达》的续集，该片由詹姆斯·卡梅隆执导，萨姆·沃辛顿、佐伊·索尔达娜等主演。
                                           该片讲述了承接自初代的5年之后。曾经的地球残疾军人杰克·萨利，如今已经是潘多拉星球纳美族一方部族的族长，
                                           并且与爱妻娜塔莉共同育有一对可爱的儿女，日子过得平淡而充实的故事。</a>
              </div>
              <div id="movie_mess" class="movie">
                  <a><b>电影场次：</b>长沙解放西路万达影院 2016/12/30 任意场次</a>
              </div>
              <div id="ticket_mess" class="movie">
                  <a><b>电影票剩余(张数):</b></a>
              </div>
              <div id="ticket_last" align="center">300</div>
              <table id="ticket_selected" align="center">
                  <tr>
                     <td align="center"><a>每个账号最多只能购买2张</a></td>
                  </tr>
                  <tr>
                     <td align="center">
                         <em class="suba">-</em>
                         <input type="text" id="ticketSelected" name="ticketSelected" value="0" style="text-align: right;">
                         <em class="adda">+</em>
                     </td>
                  </tr>
                  <tr id="whitespace"></tr>
                  <tr>
                     <td align="center"><input type="button" id="ensure" value="确认购买" onclick="pop_loginBox();"></td>
                  </tr>
              </table>
          </div>
       </div>
    </div>
  </body>
</html>
