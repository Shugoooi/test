<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1>購入履歴</h1>
	<s:if test='! #session.get("purchaseHistories").isEmpty()'>
		<s:iterator value="#session.purchaseHistories">
			<img src= '<s:property value="getImgLocated()" />' >
			<s:property value="GoodsName" />
			単価：<s:property value="goodsPrice" />円
			個数：<s:property value="purchaseCount" />個
		</s:iterator>
	</s:if>
	<s:else>
		購入履歴はありません
	</s:else>
