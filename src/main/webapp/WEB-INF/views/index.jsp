<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-31
  Time: 오후 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<button class="btn btn-primary" onclick="saveFn()">글작성</button>
<button class="btn btn-primary" onclick="findAllFn()">글목록 출력</button>
<a href="/board/paging">페이징목록</a>
<a href="/board/paging?page=10">페이징목록</a>
<a href="/board/paging?page=3">페이징목록</a>

</body>
<script>
const saveFn = () => {
    location.href="/board/save";
}
const findAllFn = () => {
    location.href="/board/";
}
</script>
</html>
