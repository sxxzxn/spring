<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>게시판 -목록</title>
</head>
<link rel="stylesheet" href="../../../resources/style.css">
<body>
<h2>게시판 목록</h2>
<form id="deleteForm" >
<table>
    <button id = "btnRegist" onclick="goRegist()">게시글 등록</button>
    <button id = "btnDelete" onclick="deleteSelected()">게시글 삭제</button>
    <thead>
    <tr>
        <th><input type="checkbox" class="checkA" name="check1" onclick="allCheck(this)"></th>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>등록일</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dto" items="${bbsList}">
        <tr>
            <td><input type="checkbox" class="checkB" name="check1" value="${dto.idx}"></td>
            <td>${dto.idx}</td>
            <td><a href="${pageContext.request.contextPath}/bbs/view.do?idx=${dto.idx}">${dto.title}</a></td>
            <td>${dto.memberId}</td>
            <td>${dto.readCnt}</td>
            <td>${dto.regDate}</td>
            <td>삭제</td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="7">작성된 글이 없습니다.</td>
        </tr>
        <tr>
            <td colspan="7">페이징</td>
        </tr>
    </tbody>
</table>
</form>


<script>
function allCheck(source) {
    const checkboxes = document.querySelectorAll('.checkB');
    checkboxes.forEach(checkbox => {
        checkbox.checked = source.checked;
    });
}

function deleteSelected() {
    const selectedCheckboxes = document.querySelectorAll('.checkB:checked');
    if (selectedCheckboxes.length === 0) {
        alert("삭제할 항목을 선택하세요.");
        return;
    }

    <%--// 각 체크된 항목의 값을 `deleteForm`에 추가--%>
    <%--const form = document.getElementById("deleteForm");--%>
    <%--form.innerHTML = ''; // 기존 hidden input 초기화--%>

    <%--selectedCheckboxes.forEach(checkbox => {--%>
    <%--    const hiddenInput = document.createElement("input");--%>
    <%--    hiddenInput.type = "hidden";--%>
    <%--    hiddenInput.name = "idx";--%>
    <%--    hiddenInput.value = checkbox.value;--%>
    <%--    form.appendChild(hiddenInput);--%>
    <%--});--%>

    <%--// 폼 제출--%>
    // form.method="post"
    <%--form.action = `${contextPath}/bbs/delete.do`;--%>
    <%--form.submit();--%>
}

function goRegist(){
    location.href = "regist.do"
}
</script>
</body>
</html>
