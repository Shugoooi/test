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
	問い合わせ
	<s:form action="InquiryTransmission" >
		<s:div>
			<s:div>名前：<s:property value="userName" /></s:div>
			<s:div>返信用メールアドレス：<s:property value="mail" /></s:div>
			<s:div>問い合わせ内容</s:div>
			<s:property value="inquiry" />
		</s:div>
		<s:submit value="送信" />
		<s:hidden name="userName" value="%{userName}" />
		<s:hidden name="mail" value="%{mail}" />
		<s:hidden name="text" value="%{inquiry}" />
	</s:form>



</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>