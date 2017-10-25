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
ul .bxslider {
  clear: both;
  width: 300px;
  height: 500px;
  position: relative;
}
ul .bxslider li s:submit {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  max-width: 100%;
  max-height: 100%;
  margin: auto;
}

.categories {
	border: none;
	background-color: white;
	font-size: 15px;
}

.categories:hover {
	text-decoration: underline;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/jquery.bxslider.min.js"></script>
    <link href="css/jquery.bxslider.css" rel="stylesheet" />
    <script type="text/javascript">
            $(document).ready(function(){
                $('.bxslider').bxSlider({
                    auto: true,
                });
        	});
    </script>
</head>
<body>

<jsp:include page="subjsp/header.jsp" flush="true" />

<s:div id="main">

	<ul class="bxslider">
			<li><s:form action="DisplayGoods">
				<s:hidden name="category" value="fire_extinguisher" />
				<s:hidden name="howSearchGoods" value="category" />
				<s:submit type="image" src="img/slide1.jpg" />
			</s:form></li>
			<li><s:form action="DisplayGoods">
				<s:hidden name="category" value="flame_thrower" />
				<s:hidden name="howSearchGoods" value="category" />
				<s:submit type="image" src="img/slide2.jpg" />
			</s:form></li>
			<li><s:form action="DisplayGoods">
				<s:hidden name="category" value="seedling" />
				<s:hidden name="howSearchGoods" value="category" />
				<s:submit type="image" src="img/slide3.jpg" />
			</s:form></li>
	</ul>

	<h3>カテゴリ一覧</h3>
	<s:iterator value='#session.categoryMap'>
		<s:form action="DisplayGoods">
			<s:hidden name="category" value="%{key}" />
			<s:hidden name="howSearchGoods" value="category" />
			<s:submit class="categories" value="%{value}" />
		</s:form>
	</s:iterator>
</s:div>

<s:div id="footer">
	利用規約｜プライバシー規約｜2017 Mamazon.com, Inc. or its attributes
</s:div>

</body>
</html>