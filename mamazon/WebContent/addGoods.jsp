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
	<s:form action="AddGoods" enctype="multipart/form-data" theme="simple">
		<s:property value="inputErr" />
		<s:property value="goodsNameErr" />
		<s:div>商品名：<s:textfield name="goodsName" /></s:div>
		<s:div>カテゴリ名：<s:select list='{"fire_extinguisher", "flame_thrower", "seedling"}' name="category" /></s:div>
		<s:div>商品画像：<s:file property="uploadFile" name="file"/></s:div>
		<s:div>価格：<s:textfield name="price" />円</s:div>
		<s:div>在庫：<s:textfield name="stock" />個</s:div>
		<s:submit value="完了" />
		<s:div>商品画像はjpgファイルでお願いします</s:div>
	</s:form>

</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>