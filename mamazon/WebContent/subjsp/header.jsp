<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:div id="header">
	<s:div id="headerLogo">
		<a href= '<s:url action="GoHome" />' ><img src="img/mamazon_logo.png" alt="ロゴ" height="50px"></a>
		<s:if test="#session.userInfo.getLoginFlg()">
			<a id="logout_button" href= '<s:url action="Logout" />' >ログアウト</a>
		</s:if>
	</s:div>
	<ul>
		<li><a href=' <s:url action="GoHome" /> '>ホーム</a></li>
		<li><s:form id="searchForm" action="DisplayGoods">
			<s:textfield name="keyword" theme="simple" /><s:submit id="searchButton" value="検索" theme="simple" /><s:hidden name="howSearchGoods" value="searchForm" />
		</s:form></li>
		<s:if test="#session.userInfo.getLoginFlg()">
			<li><a href=' <s:url action="GoMyPage" /> '>マイページ</a></li>
		</s:if>
		<s:else>
			<li><a href=' <s:url action="GoLogin" /> '>ログイン</a></li>
		</s:else>
		<li><a href="#">ほしいものリスト</a></li>
		<li><a href=' <s:url action="LookCart" /> '>カートを見る</a></li>
		<li><a href=' <s:url action="GoHelp" /> '>ヘルプ</a></li>
	</ul>
</s:div>