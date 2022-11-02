<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-01
  Time: 오후 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardUpdate.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <style>
        #update-form {
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
    <div class="container" id="update-form">
        <form action="/board/update" method="post" name="updateForm">
            <input type="hidden" name="id" value="${findById.id}" class="form-control" readonly>
            <input type="text" name="boardWriter" value="${findById.boardWriter}" class="form-control" readonly>
            <input type="text" name="boardPass" id="boardPass" placeholder="비밀번호 입력" class="form-control">
            <input type="text" name="boardTitle" value="${findById.boardTitle}" class="form-control" >
            <textarea name="boardContents" cols="30" rows="10" class="form-control">${findById.boardContents}</textarea>
            <input type="button" value="수정" class="btn btn-warning" onclick="updateCheck()">
        </form>
    </div>
</body>
<script>
    const updateCheck = () => {
        const passDB = '${findById.boardPass}';
        // board: update의 model값
        const pass = document.getElementById("boardPass").value;
        if(passDB == pass){
            document.updateForm.submit();
        }else{
            alert("비밀번호가 일치하지 않습니다.");
        }
    }

</script>
</html>
