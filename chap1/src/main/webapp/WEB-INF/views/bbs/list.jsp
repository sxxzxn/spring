<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="../../../resource/style.css">
<body>
<h2>게시판 - 리스트</h2>
<form id="deleteForm" method="post" action="${pageContext.request.contextPath}/bbs/delete.do">
    <button type="button" onclick="deleteSelected()">삭제</button>
    <table>
        <thead>
        <tr>
            <th><input type="checkbox" class="checkA" name="check1" onclick="allCheck(this)">
            </th>
            <th>번호</th>
            <th>작성자 ID</th>
            <th>제목</th>
            <th>내용</th>
            <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${list}">
            <tr>
                <td><input type="checkbox" class="checkB" name="check1"></td>
                <td>${dto.idx}</td>
                <td>${dto.memberId}</td>
                <td><a href="${pageContext.request.contextPath}/bbs/view.do?idx=${dto.idx}">${dto.title}</a></td>
                <td>${dto.content}</td>
                <td>${dto.regDate}</td>
            </tr>
        </c:forEach>
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

    // 각 체크된 항목의 값을 `deleteForm`에 추가
    const form = document.getElementById("deleteForm");
    selectedCheckboxes.forEach(checkbox => {
        const hiddenInput = document.createElement("input");
        hiddenInput.type = "hidden";
        hiddenInput.name = "idx";
        hiddenInput.value = checkbox.value;
        form.appendChild(hiddenInput);
    });

    // 폼 제출
    form.submit();
}
</script>
</body>
</html>
