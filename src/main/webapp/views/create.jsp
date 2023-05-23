<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="utf-8" language="java" %>
<html lang="en">
<head>
    <title>create</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <style>
		.errors {color:red}
	</style>
</head>
<body>
<!-- <form action="/store" method="post" modelAttribute="cuaHang">
    <lable>ID: </lable>
    <input type="text" name="id" />
    <br>
    <lable>Ten Cua Hang: </lable>
    <input type="text" name="tenCH" />
    <br>
    <lable>Dia Chi: </lable>
    <input type="text" name="diaChi" />
    <input type="submit" value="Submit" />
</form> -->
<form:form action="/store" method="post" modelAttribute="cuaHang">
    <lable>ID: </lable>
    <form:input type="text"  path="id"/>
    <form:errors path="id"  cssClass="errors"/>
    <br>
    <lable>Ten Cua Hang: </lable>
    <form:input type="text"  path="tenCH"/>
    <form:errors path="tenCH" cssClass="errors"/>
    <br>
    <lable>Dia Chi: </lable>
    <form:input type="text" path="diaChi"/>
    <form:errors path="diaChi" cssClass="errors"/>
    <br>
    <input type="submit" value="Submit"/>
</form:form>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"
></script>
</body>
</html>