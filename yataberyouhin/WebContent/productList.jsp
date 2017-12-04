<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ProductList</title>
</head>
<body>

	<header>
		<!--タイトルロゴここから-->
		<div class="logo">ヤタベ良品</div>
		<!--タイトルロゴここまで-->

		<!--ヘッダーメニューここから-->
		<div class="menu">
			<ul>
				<li><a href="">TOP</a></li>
				<li><a href="">Login</a></li>
				<li><s:a href="">商品一覧</s:a></li>
				<li><a href="">マイページ</a></li>
			</ul>
		</div>
	</header>


	<table>
		<tbody>

			<s:iterator value="#session.productListDTO">

				<tr>

					<td><s:property value="productName" /></td>
					<td><s:property value="productNameKana" /></td>
					<td><s:property value="price" /></td>
					<td><a href='<s:url action="Action"><s:param name="productId" value="%{productId}" /></s:url>'>
					<img src='<s:property value="imageFilePath"/>' /></a></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>


</body>
</html>