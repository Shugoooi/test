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
	<s:form action="UserInfoModConfirm" theme="simple">
		<ul>
			<li>
				名前
				<s:div><input type="text" name="newName" value='<s:if test='#session.containsKey("newUser")' ><s:property value="#session.newUser.getUserName()" /></s:if>' required /></s:div>
			</li>
			<li>
				ID
				<s:div><s:property value="#session.userInfo.getUserName()" /></s:div>
			</li>
			<li>
				パスワード
				<s:div><input type="password" name="newPassword" value='<s:if test='#session.containsKey("newUser")' ><s:property value="#session.newUser.getPassword()" /></s:if>' pattern="(?=.*\d)(?=.*[a-zA-Z]).{6,}" title="半角英数字で6文字以上（英字も数字も必ず入れること)" required /></s:div>
			</li>
			<li>
				電話番号
				<s:div><input type="text" name="newTel" value='<s:if test='#session.containsKey("newUser")' ><s:property value="#session.newUser.getTel()" /></s:if>' pattern="\d{2,4}-?\d{3,4}-?\d{3,4}" title="電話番号に間違いがあります。" required /></s:div>
			</li>
			<li>
				メールアドレス
				<s:div><input type="text" name="newMail" value='<s:if test='#session.containsKey("newUser")' ><s:property value="#session.newUser.getMail()" /></s:if>' pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="メールアドレスに間違いがあります" required /></s:div>
			</li>
			<li>
				住所
				<s:div><input type="text" name="newAddress" value='<s:if test='#session.containsKey("newUser")' ><s:property value="#session.newUser.getAddress()" /></s:if>' required /></s:div>
			</li>
			<li>
				<s:submit value="登録情報変更確認" />
			</li>
		</ul>
	</s:form>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>