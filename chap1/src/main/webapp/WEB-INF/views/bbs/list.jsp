<%--
  Created by IntelliJ IDEA.
  User: full5-9
  Date: 2024-10-31
  Time: 오후 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>게시판 - 리스트</h2>
<ul>
    <c:forEach var="dto" items="${list}">
    <li>
        <ul>
            <li>${dto.idx}</li>
            <li>${dto.memberId}</li>
            <li>${dto.title}</li>
            <li>${dto.content}</li>
            <li>${dto.regDate}</li>
        </ul>
    </li>
    </c:forEach>
</ul>
</body>
</html>
