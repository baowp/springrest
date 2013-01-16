<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
upload:
<form action=uploadFile enctype="multipart/form-data" method="post">
file1:<input type="file" name="file1" id="file1" /> 
<br></br>
file2:<input type="file" name="file2" id="file2" /> 
<br></br>
<button type="submit">submit</button>
</form>

uploadMulti:
<form action="uploadMulti" enctype="multipart/form-data" method="post">
file1:<input type="file" name="file1" id="file1" /> 
<br></br>
file2:<input type="file" name="file2" id="file2" /> 
<br></br>
file3:<input type="file" name="file3" id="file3" /> 
<br></br>
file4:<input type="file" name="file4" id="file4" /> 
<br></br>
file5:<input type="file" name="file5" id="file5" /> 
<br></br>
<button type="submit">submit</button>
</form>

file_list:
<table>
<c:if test="${! empty list}">
<tr><th>name</th><th>size</th><th>path</th></tr>
<c:forEach items="${list}" var="demo">
<tr><td>${demo.name}</td><td>${demo.size}</td><td>${demo.path}</td></tr>
</c:forEach>
</c:if>

<c:forEach var="student" items="${commad.feedback}" varStatus="status">
<font size=5 color=blue>${student}</font><br>
</c:forEach>

</table>
</body>
</html>