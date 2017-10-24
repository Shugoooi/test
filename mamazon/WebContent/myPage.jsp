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
	<s:div id="left">
		<ul>
			<li><a href='<s:url action="MyPageTransition" />' >登録情報確認</a></li>
			<li><a href=''>購入履歴</a></li>
			<li><a href=''>カートを見る</a></li>
			<li><a href=''>欲しいものリスト</a></li>
		</ul>
	</s:div>
	<s:div id="right">
		<s:if test='myPageDisplay=="myResister"'>
			<jsp:include page="subjsp/myResister.jsp" />
		</s:if>
		<s:elseif test='myPageDisplay=="myPurchaseHistory"'>
			<jsp:include page="subjsp/myPurchaseHistory.jsp" />
		</s:elseif>
		<s:elseif test='myPageDisplay=="myCart"'>
			<jsp:include page="subjsp/myCart.jsp" />
		</s:elseif>
		<s:elseif test='myPageDisplay=="myWishList"'>
		</s:elseif>
		<s:else>
			<jsp:include page="subjsp/myResister.jsp" />
		</s:else>
	</s:div>
</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>