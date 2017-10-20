<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1>ユーザー情報確認</h1>

<ul>
	<li>
		名前
		<s:div><s:property value="#session.userInfo.getUserName()" /></s:div>
	</li>
	<li>
		ID
		<s:div><s:property value="#session.userInfo.getId()" /></s:div>
	</li>
	<li>
		パスワード
		<s:div><s:property value="#session.userInfo.getPassword()" /></s:div>
	</li>
	<li>
		電話番号
		<s:div><s:property value="#session.userInfo.getTel()" /></s:div>
	</li>
	<li>
		メールアドレス
		<s:div><s:property value="#session.userInfo.getMail()" /></s:div>
	</li>
	<li>
		住所
		<s:div><s:property value="#session.userInfo.getAddress()" /></s:div>
	</li>
	<li>
		<a href= '<s:url action="GoUserInfoMod" />' >登録情報変更</a>
	</li>
</ul>
