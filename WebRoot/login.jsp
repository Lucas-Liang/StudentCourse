<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix ="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>登录注册</title>
	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags  -->
	<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>
<!-- //Head -->
<!-- Body -->
<body>
	<h1>登录注册</h1>
	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<s:form action ="user_login" method = "post" namespace ="/" them ="simple">
				<input type="text" name="u_usename" placeholder="用户名" >
				<input type="password" Name="u_password" placeholder="密码">
			
			<ul class="tick w3layouts agileits">
				<li>
					<input type="checkbox" id="brand1" value="">
					<label for="brand1"><span></span>记住我</label>
				</li>
			</ul>
			<div class="send-button w3layouts agileits">
				
					<input type="submit" value="登 录">
				
			</div>
			<a href="#">记住密码?</a>
			</s:form>
			<h3 style="color:red;"><s:actionerror/></h3>
			<div class="clear"></div>
		</div><div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<s:form action ="user_save" method = "post" namespace ="/" them ="simple">
				<input type="text" Name="u_usename" placeholder="用户名" required="">
				<input type="text" Name="u_mail" placeholder="邮箱" required="">
				<input type="password" Name="u_password" placeholder="密码" required="">
				<input type="text" Name="u_phone" placeholder="手机号码" required="">
			
			<div class="send-button w3layouts agileits">
				
					<input type="submit" value="免费注册">
				
			</div>
			<div class="clear"></div>
			</s:form>
		</div>

		<div class="clear"></div>

	</div>

	<div class="footer w3layouts agileits">
		<p>Copyright &copy; More Templates  <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
	</div>

</body>
<!-- //Body -->
</html>