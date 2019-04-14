<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="org.dzq.dao.LoginDao" %>
<%@ page import="org.dzq.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			String name =request.getParameter("uname") ;
			String pwd = request.getParameter("upwd") ;
			Login login=new Login(name, pwd);
			
			LoginDao dao=new LoginDao();
			int count=dao.login(login);
			if(count==1){
				out.println("登陆成功！");
			}else if(count==0){
				out.println("登录失败！");
			}else if(count==-1){
				out.println("系统出错！");
			}
		%>
</body>
</html>