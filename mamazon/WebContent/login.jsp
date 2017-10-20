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

<jsp:include page="subjsp/header.jsp" flush="true" />

<s:div id="main">
	<s:property value="loginError" />
	<s:form action="Login" theme="simple">
		<ul>
			<li>ID<s:div><s:textfield name="loginId" /></s:div></li>

			<li>パスワード<s:div><s:password name="loginPassword" /></s:div></li>

			<li><s:submit id="login_button" value="ログイン" /></li>

			<li>Mamazonの新しいお客様ですか？
			<s:div><input type="button" value="Mamazonアカウントを作成"
			onclick="location.href= '<s:url action="GoUserCreate" />' "></s:div></li>
		</ul>
	</s:form>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>