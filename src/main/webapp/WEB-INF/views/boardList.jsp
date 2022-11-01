<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <title>boardList.jsp</title>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>내용</th>
        <th>삭제</th>
        </tr>
        <c:forEach items="${findAll}" var="board">
            <tr>
                <td>${board.id}</td>
                <td><a href="/board?id=${board.id}">${board.boardWriter}</a></td>
                <td>${board.boardTitle}</td>
                <td>${board.boardContents}</td>
                <td><button class="btn btn-danger" onclick="deleteBoard(${board.id})">삭제</button></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
<script>
    const deleteBoard = (clickedId) => {
        console.log('${findAll}');
        location.href="/board/delete?id="+clickedId;
    }
</script>
</html>
