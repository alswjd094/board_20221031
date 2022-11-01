<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <title>boardList.jsp</title>
    <style>
        #list{
            width:800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="list">
    <table class="table table-striped table-hover text-center">
        <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성시간</th>
        </tr>
        <c:forEach items="${findAll}" var="board">
            <tr>
                <td>${board.id}</td>
                <td>${board.boardWriter}</td>
                <td><a href="/board?id=${board.id}">${board.boardTitle}</a></td>
                <td>${board.boardContents}</td>
                <td>
                    <fmt:formatDate value="${board.boardCreatedDate}" pattern="yyyy-MM-dd hh:mm:ss" ></fmt:formatDate>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
