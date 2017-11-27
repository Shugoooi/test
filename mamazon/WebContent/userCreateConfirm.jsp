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
	<s:actionerror />
	<s:form action="UserCreateComplete">
		<ul>
			<li>
				名前
				<s:div><s:property value="newName" /></s:div>
			</li>
			<li>
				ID
				<s:div><s:property value="newId" /></s:div>
			</li>
			<li>
				パスワード
				<s:div><s:property value="newPassword" /></s:div>
			</li>
			<li>
				電話番号
				<s:div><s:property value="newTel" /></s:div>
			</li>
			<li>
				メールアドレス
				<s:div><s:property value="newMail" /></s:div>
			</li>
			<li>
				住所
				<s:div><s:property value="newAddress" /></s:div>
			</li>
			<s:hidden name="newName" value="%{newName}" />
			<s:hidden name="newId" value="%{newId}" />
			<s:hidden name="newPassword" value="%{newPassword}" />
			<s:hidden name="newTel" value="%{newTel}" />
			<s:hidden name="newMail" value="%{newMail}" />
			<s:hidden name="newAddress" value="%{newAddress}" />

			<li>
				<s:submit value="登録" />
			</li>
		</ul>
	</s:form>
	<s:form action="GoUserCreate">
			<s:hidden name="newName" value="newName" />
			<s:hidden name="newId" value="%{newId}" />
			<s:hidden name="newPassword" value="%{newPassword}" />
			<s:hidden name="newTel" value="%{newTel}" />
			<s:hidden name="newMail" value="%{newMail}" />
			<s:hidden name="newAddress" value="%{newAddress}" />
			<s:submit value="修正する" />
	</s:form>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>