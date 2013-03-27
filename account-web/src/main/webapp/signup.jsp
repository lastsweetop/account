<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="com.eshore.account.service.*,org.springframework.context.ApplicationContext,
 org.springframework.web.context.support.WebApplicationContextUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

.text-field {position: absolute; left: 40%; background-color:rgb(255,230,220);}
label {display: inline-table; width: 100px; margin: 0px 0px 10px 20px; }
input {display: inline-table; width: 150px; margin: 0px 20px 10px 0px;}
img {width:150px; margin: 0px 20px 10px 110px;}
h2 {margin: 20px 20px 20px 40px;} 
button {margin: 20px 20px 10px 110px;}      
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>signup</title>
</head>
<body>
	<%
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		AccountService service = (AccountService) context
				.getBean("accountService");
		String captchaKey = service.generateCaptchaKey();
	%>
	<div class="text-field">
		<h2>注册新用户</h2>
		<form action="signup" name="signup" method="post">
			<label>账户ID:</label><input type="text" name="id" /><br /> <label>Email:</label><input
				type="text" name="email" /><br /> <label>显示名称:</label><input
				type="text" name="name" /><br /> <label>密码:</label><input
				type="text" name="password" /><br /> <label>确认密码:</label><input
				type="text" name="confirm_password" /><br /> <label>验证码:</label><input
				type="text" name="captcha_value" /><br /> <input type="hidden"
				name="captcha_key" value="<%=captchaKey%>"> <img alt=""
				src="<%=request.getContextPath()%>/captcha_image?key=<%=captchaKey%>">
			<br />
			<button>确认并提交</button>
		</form>
	</div>
</body>
</html>