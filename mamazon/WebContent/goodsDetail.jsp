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
		<s:form action="SelectGoodsIntoCart">
			<h1><s:property value="goodsName" /></h1>
			<img src= '<s:property value="imgLocated" />' >
			&yen; <s:property value="price" />
			在庫
			<s:if test="stock >= 10">○</s:if>
			<s:elseif test="stock < 10 && stock > 5">△</s:elseif>
			<s:elseif test="stock <= 5 && stock > 0">残り<s:property value="stock" />個</s:elseif>
			<s:else>×</s:else>

			<s:if test="stock != 0">
				購入数：<s:select list="purchaseCount" name="purchaseCount" value="1" />

				<s:if test="! goodsAlreadyIntoCartFlg">
					<s:submit value="カートに入れる" />
				</s:if>
				<s:else>
					<s:property value="goodsAlreadyIntoCartMessage" />
					<s:submit value="購入数を変更する" />
				</s:else>

			</s:if>
			<s:else>次回入荷予定は未定です</s:else>

			<s:hidden name="targetGoods" value="%{goodsName}" />
			<s:hidden name="goodsAlreadyIntoCartFlg" value="%{goodsAlreadyIntoCartFlg}" />
		</s:form>


</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>