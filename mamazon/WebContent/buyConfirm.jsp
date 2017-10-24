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
	<s:iterator value="#session.cartInfo">
		<img src= '<s:property value="imgLocated" />' >
		<s:property value="goodsName" />
		単価：<s:property value="price" />円
		個数：<s:property value="buyCount" />個
	</s:iterator>

		合計<s:property value="#session.totalPrice" />円

		購入情報
		<s:property value='#session.get("userInfo").getUserName()' />
		<s:property value='#session.get("userInfo").getAddress()' />
		<s:property value='#session.get("userInfo").getUserName()' />
		<a href=' <s:url action="GoBuyComplete" /> '>本当に買う</a>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>