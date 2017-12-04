<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE htmlml>
<html>
<head>
<meta charset="UTF-8">
<title>決済完了画面</title>
</head>
<body>
<s:form>
 <tr>
  <td>商品名</td>
  <td><s:property value=""/></td>
 </tr>
 <tr>
  <td>商品かな</td>
  <td><s:property value=""/></td>
 </tr>
 <tr>
  <td>値段</td>
  <td><s:property value=""/><span>円</span></td>
 </tr>
 <tr>
  <td>画像</td>
  <td><s:property value=""/></td>
 </tr>
 <tr>
 <td>発売会社</td>
  <td><s:property value=""/></td>
 </tr>
 <tr>
  <td>発売年月</td>
  <td><s:property value=""/></td>
 </tr>
 <br>
 <tr>
  <td><input type="button" value="完了" onclick=""/></td>
 </tr>
 </s:form>
</body>
</html>