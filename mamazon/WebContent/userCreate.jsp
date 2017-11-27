<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>

<html>
<head>
<meta charset="UTF-8">
<title>Mamazon</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<jsp:include page="subjsp/header.jsp" flush="true" />

<s:div id="main">

	<h3>新規ユーザー登録</h3>

	<s:form action="UserCreateConfirm" theme="simple">
		<s:property value="errMsg" />
		<s:div><s:property value="idErr" /></s:div>
		<s:div><s:property value="passwordErr" /></s:div>
		<s:div><s:property value="telErr" /></s:div>
		<s:div><s:property value="mailErr" /></s:div>


		<ul>
			<li>
				名前
				<s:div><s:textfield  name="newName" value="%{newName}" /></s:div>
			</li>
			<li>
				ID
				<s:div><s:textfield  name="newId" value="%{newId}" /></s:div>
			</li>
			<li>
				パスワード
				<s:div><s:password name="newPassword" value="%{newPassword}" /></s:div>
			</li>
			<li>
				電話番号
				<s:div><s:textfield  name="newTel" value="%{newTel}" /></s:div>
			</li>
			<li>
				メールアドレス
				<s:div><s:textfield  name="newMail" value="%{newMail}" /></s:div>
			</li>
			<li>
				住所
				<s:div><s:textfield name="newAddress" value="%{newAddress}" /></s:div>
			</li>
			<li>
				<s:submit value="登録情報確認" />
			</li>
		</ul>
	</s:form>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>