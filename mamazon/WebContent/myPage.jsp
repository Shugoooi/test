<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mamazon</title>
<link rel="stylesheet" href="css/style.css">

<style>

#left {
	float: left;
	width: 20%;
	margin-left: 0;
	margin-right: 30px;
}

#right{
	float: left;
	width: 70%;
}
.myPageContents {
	border: none;
	background-color: white;
	font-size: 15px;
}

.myPageContents:hover {
	text-decoration: underline;
}

</style>
</head>
<body>

<jsp:include page="subjsp/header.jsp" flush="true" />

<s:div id="main">
	<s:div id="left">
		<ul>
			<li><s:form action="GoMyPage"><s:submit class="myPageContents" value="登録情報" /><s:hidden name="myPageDisplay" value="myResister" /></s:form></li>
			<li><s:form action="GoMyPage"><s:submit class="myPageContents" value="購入履歴" /><s:hidden name="myPageDisplay" value="myPurchaseHistory" /></s:form></li>
			<li><s:form action="GoMyPage"><s:submit class="myPageContents" value="カート情報" /><s:hidden name="myPageDisplay" value="myCart" /></s:form></li>
			<li><s:form action="GoMyPage"><s:submit class="myPageContents" value="欲しいものリスト" /><s:hidden name="myPageDisplay" value="null" /></s:form></li>
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