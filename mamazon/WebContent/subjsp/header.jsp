<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:div id="header">
	<ul>
		<li><a href=' <s:url action="GoHome" /> '>ホーム</a></li>
		<li><s:form action="DisplayGoods">
			<s:textfield name="keyword" /><s:submit value="検索" /><s:hidden name="howSearchGoods" value="searchForm" />
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