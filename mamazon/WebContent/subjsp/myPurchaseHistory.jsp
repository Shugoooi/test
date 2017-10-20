<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1>購入履歴</h1>
	<s:iterator value="#session.purchaseHistories">
		<img src= '<s:property value="imgLocated" />' >
		<s:property value="goodsName" />
		単価：<s:property value="price" />円
		個数：<s:property value="buyCount" />個
	</s:iterator>
