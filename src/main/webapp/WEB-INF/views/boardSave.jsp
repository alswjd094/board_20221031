<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <title>boardSave.jsp</title>
    <style>
        
    </style>
</head>
<body>
<div class="container">
    <form action="/board/save" method="post">
<input type="text" name="boardWriter" placeholder="작성자" class="form-control">
<input type="text" name="boardPass" placeholder="글비밀번호" class="form-control">
<input type="text" name="boardTitle" placeholder="제목" class="form-control">
<input type="text" name="boardContents" placeholder="내용" class="form-control">
<input type="submit" value="저장" class="btn btn-primary">
</form>
</div>
</body>
<script>

</script>
</html>
