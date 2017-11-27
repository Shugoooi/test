<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MamazonAdmin</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<jsp:include page="subjsp/header.jsp" flush="true" />

<s:div id="main">
	<s:form action="SearchGoods">
		商品名：<s:textfield name="keyword" theme="simple" />
		<s:select list='{"未選択", "fire_extinguisher", "flame_thrower", "seedling"}' name="category" value="未選択"/>

		<s:submit value="検索" />
	</s:form>

	<s:iterator value="goodsList">
		<s:form action="GoChangeGoodsInfo">
			<img src= '<s:property value="imgLocated" />' >
			<s:property value="name" />
			&yen; <s:property value="price" />
			在庫
			<s:if test="stock >= 10">○</s:if>
			<s:elseif test="stock < 10 && stock > 5">△</s:elseif>
			<s:elseif test="stock <= 5 && stock > 0">残り<s:property value="stock" />個</s:elseif>
			<s:else>×</s:else>

			<s:hidden name="goodsName" value="%{name}" />
			<s:submit value="商品情報の変更" />
		</s:form>
	</s:iterator>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>