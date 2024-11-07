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
    <title>게시글 확인</title>
</head>
<body>
<h2>게시글 확인</h2>
<table>
    <tr>
        <td>제목</td>
        <td>작성자</td>
        <td>내용</td>
        <td>등록일</td>
    </tr>
    <tr>
        <td>${bbsDTO.title}</td>
        <td>${bbsDTO.memberId}</td>
        <td>${bbsDTO.content}</td>
        <td>${bbsDTO.regDate}</td>
    </tr>
    <tr>
        <td colspan="4">
            <button id="btnModify" onclick="goModify()">수정</button>
            <button id="btnDelete" onclick="goDelete()">삭제</button>
            <button id="btnBack" onclick="goBack()">뒤로가기</button>
        </td>
    </tr>
</table>

<script>
    function goModify(){
        location.href = "modify.do?idx=${bbsDTO.idx}"
    }
    function goDelete(){

    }
    function goBack(){
        history.back();
    }
</script>

</body>
</html>
