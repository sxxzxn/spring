<%--
  Created by IntelliJ IDEA.
  User: full5-9
  Date: 2024-11-07
  Time: 오전 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 - 수정</title>
</head>
<body>
<h2>게시글 수정</h2>
<form id="frmModify" method="POST" action="bbs/modify.do">
<table>
    <tr>
        <td>제목</td>
        <td>작성자</td>
        <td>내용</td>
        <td>등록일</td>
    </tr>
    <tr>
        <td><input type="text" name="title" value="${bbsDTO.title}"></td>
        <td><input type="text" name="memberId" value="${bbsDTO.memberId}"></td>
        <td><input type="text" name="content" value="${bbsDTO.content}"></td>
        <td><input type="date" name="regDate" value="${bbsDTO.regDate}"></td>
    </tr>
    <tr>
        <td colspan="4">
            <button id="btnModify" type="submit">수정</button>
            <button id="btnBack" onclick="view.do?idx=${bbsDTO.idx}">뒤로가기</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
