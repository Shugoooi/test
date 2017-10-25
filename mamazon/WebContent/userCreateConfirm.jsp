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
	<s:form action="UserCreateComplete">
		<ul>
			<li>
				名前
				<s:div><s:property value="#session.newUser.getUserName()" /></s:div>
			</li>
			<li>
				ID
				<s:div><s:property value="#session.newUser.getId()" /></s:div>
			</li>
			<li>
				パスワード
				<s:div><s:property value="#session.newUser.getPassword()" /></s:div>
			</li>
			<li>
				電話番号
				<s:div><s:property value="#session.newUser.getTel()" /></s:div>
			</li>
			<li>
				メールアドレス
				<s:div><s:property value="#session.newUser.getMail()" /></s:div>
			</li>
			<li>
				住所
				<s:div><s:property value="#session.newUser.getAddress()" /></s:div>
			</li>
			<li>
				<s:submit value="登録" /><input type="button" value="修正する" onclick="location.href= '<s:url action="GoUserCreate" />' " />
			</li>
		</ul>
	</s:form>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>