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
    <form action="/board/save" method="post" name="saveForm">
<input type="text" name="boardWriter" placeholder="작성자" class="form-control">
        <span id="writer-input-check"></span>
<input type="text" name="boardPass" placeholder="글비밀번호" class="form-control">
        <span id="pass-input-check"></span>
<input type="text" name="boardTitle" placeholder="제목" class="form-control">
        <span id="title-input-check"></span>
<input type="text" name="boardContents" placeholder="내용" class="form-control">
        <span id="contents-input-check"></span>
<input type="button" value="저장" onclick="save()" class="btn btn-primary">
</form>
</div>
</body>
<script>
const save = () => {
    if(document.saveForm.boardWriter.value==""){
        const writerCheck =document.getElementById("writer-input-check");
        writerCheck.innerHTML="작성자를 입력해주세요";
        writerCheck.style.color="red";
        return false;
    }else if(document.saveForm.boardPass.value==""){
        const passCheck = document.getElementById("pass-input-check");
        passCheck.innerHTML="비밀번호를 입력해주세요";
        passCheck.style.color="red";
        return false;
    }else if(document.saveForm.boardTitle.value==""){
        const titleCheck = document.getElementById("title-input-check");
        titleCheck.innerHTML="제목을 입력해주세요";
        titleCheck.style.color="red";
        return false;
    }else if(document.saveForm.boardContents.value==""){
        const contentsCheck = document.getElementById("contents-input-check");
        contentsCheck.innerHTML="내용을 입력해주세요";
        contentsCheck.style.color="red";
        return false;
    }
    document.saveForm.submit();
}
</script>
</html>
