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
	<s:if test="! #session.cartInfo.isEmpty()">
	<s:iterator value="#session.cartInfo">
		<img src= '<s:property value="imgLocated" />' >
		<s:property value="name" />
		単価：<s:property value="price" />円
		個数：<s:property value="buyCount" />個
	</s:iterator>

	<div class="right">
		合計<s:property value="totalPrice" />円
		<a href=' <s:url action="GoBuyConfirm" /> '>買う</a>
	</div>

	</s:if>
	<s:else>
		<div>
			カートの中は空です
		</div>
	</s:else>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>