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
	<s:if test='howSearchGoods.equals("searchForm")'>
		<s:div>検索結果</s:div>
	</s:if>
	<s:elseif test='howSearchGoods.equals("category")'>
		<s:div><s:property value="#session.categoryMap.get(category)" />の一覧</s:div>
	</s:elseif>
	<s:else>
		<s:div>ベストセラー</s:div>
	</s:else>

	<s:iterator value="goodsList">
		<s:form action="ShowGoodsDetail" id="goodsList">
			<h4><s:property value="name" /></h4>
			<img src= '<s:property value="imgLocated" />' >
			<s:div><s:property value="price" />円</s:div>
			<s:div>在庫
				<s:if test="stock >= 10">○</s:if>
				<s:elseif test="stock < 10 && stock > 5">△</s:elseif>
				<s:elseif test="stock <= 5 && stock > 0">残り<s:property value="stock" />個</s:elseif>
				<s:else>×</s:else>
			</s:div>

			<s:hidden name="goodsName" value="%{name}" />
			<s:submit value="詳細を見る" />
		</s:form>
	</s:iterator>


</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>