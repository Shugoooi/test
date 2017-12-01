<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>h1|site_name admin</title>
</head>
<body>
	<h1>Site administration</h1>
	<s:iterator value="tableSet"><s:div>
		<s:url id="showTableRowsUrl" action="ShowTableRows"><s:param name="tableName" value="<s:property />" /></s:url>
		<s:a href="%{showTableRowsUrl}"><s:property /></s:a>
		<s:url id="AddUrl" value="admin_add.jsp"><s:param name="tableName" value="<s:property />" /></s:url>
		<s:a href="%{AddUrl}">Add</s:a>
		<s:url id="ChangeUrl" action="ShowTableRows"><s:param name="tableName" value="<s:property />" /></s:url>
		<s:a href="%{ChangeUrl}">Change</s:a>


	</s:div></s:iterator>
</body>
</html>