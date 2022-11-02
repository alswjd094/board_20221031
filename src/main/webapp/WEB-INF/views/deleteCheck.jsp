<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-02
  Time: 오전 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteCheck.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <style>
        #delete-form{
            width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="delete-form">
  <input type="password" name="boardPass" id="boardPass" class="form-control" placeholder="글작성 비밀번호">
  <button class="btn btn-secondary" onclick="deleteCheck()">확인</button>
</div>
</body>
<script>
  const deleteCheck = () => {
    const passDB = ${findById.boardPass};
      const pass = document.getElementById("boardPass").value;
      const id = '${findById.id}';
      if(passDB == pass){
          location.href="/board/delete?id="+id;
      } else{
          alert("비밀번호가 일치하지 않습니다.");
      }
  }
</script>
</html>
