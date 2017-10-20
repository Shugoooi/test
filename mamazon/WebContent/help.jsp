<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mamazon</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<jsp:include page="subjsp/header.jsp" flush="true" />>


<s:div id="main">
	Q&A


	問い合わせは<a href=' <s:url action="GoInquiry" /> '>こちらまで</a>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>