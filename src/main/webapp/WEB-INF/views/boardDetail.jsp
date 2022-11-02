<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>boardDetail.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
  <style>
    #detail{
      width: 800px;
      margin-top: 50px;
    }
  </style>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="detail">
  <table class="table table-striped table-hover text-center">
    <tr>
      <th>번호</th>
      <td>${findById.id}</td>
    </tr>
    <tr>
      <th>작성자</th>
      <td>${findById.boardWriter}</td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td>${findById.boardPass}</td>
    </tr>
    <tr>
      <th>제목</th>
      <td>${findById.boardTitle}</td>
    </tr>
    <tr>
      <th>내용</th>
      <td>${findById.boardContents}</td>
    </tr>
    <tr>
      <th>작성시간</th>
      <td><fmt:formatDate value="${findById.boardCreatedDate}" pattern="yyyy-MM-dd hh:mm:ss" ></fmt:formatDate></td>
    </tr>
    <tr>
      <th>조회수</th>
      <td>${findById.boardHits}</td>
    </tr>
  </table>
  <button class="btn btn-primary" onclick="listFn()">목록</button>
  <button class="btn btn-warning" onclick="updateFn()">수정</button>
  <button class="btn btn-danger" onclick="deleteFn()">삭제</button>
</div>
</body>
<script>
  const listFn = () => {
    location.href="/board/";
  }
  const updateFn = () => {
    const id = '${findById.id}';
     location.href="/board/update?id="+id;
  }
  const deleteFn = () => {
    const id = '${findById.id}'
    location.href="/board/deleteCheck?id="+id;
  }

</script>
</html>
