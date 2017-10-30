<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String result = (String)request.getAttribute("result");
	%>
	
	결과 : <%= result %>
	<p>
	<a href="/calculatorWeb/calculate_form.jsp">계산폼</a>
	../calculate_form.jsp 절대경로
</body>
</html>