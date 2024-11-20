<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 -목록</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<link rel="stylesheet" href="../../../resources/style.css">
<body>

<div class="container-fluid">
    <!--    상단 네비게이션 시작-->
    <jsp:include page="../common/header.jsp"/>
    <!--    상단 네비게이션 끝-->


    <!--    컨텐츠 시작-->
    <div class="row content">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    게시판 목록
                </div>
                <div class="card-body">
                    <!--검색영역 시작-->
                    <!--검색영역 끝-->

                    <!--버튼 시작-->
                    <div class="form-group row justify-content-center mt-3">
                        <div class="col-sm-3">
                            <button class="btn btn-primary" onclick="goRegist()">등록</button>
                            <button class="btn btn-secondary" onclick="deleteSelected()">게시글 삭제</button>
                        </div>
                    </div>
                    <!--버튼 끝-->
                    <!--리스트 시작-->
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col"><input type="checkbox" class="checkA" name="check1"
                                                   onclick="allCheck(this)"></th>
                            <th scope="col">번호</th>
                            <th scope="col">제목</th>
                            <th scope="col">작성자</th>
                            <th scope="col">조회수</th>
                            <th scope="col">등록일</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bbsList.dtoList}" var="dto" varStatus="loop">
                            <tr>
                                <td><input type="checkbox" class="checkB" name="check1" value="${dto.idx}"></td>
                                <td>${fn:length(bbsList.dtoList) - loop.index}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/bbs/view.do?idx=${dto.idx}">${dto.title}</a>
                                </td>
                                <td>${dto.memberId}</td>
                                <td>${dto.readCnt}</td>
                                <td>${dto.displayDate}</td>
                            </tr>
                        </c:forEach>
                        <c:if test="${bbsList.dtoList == null}">
                            <tr>
                                <td colspan="7">작성된 글이 없습니다.</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                    <!--리스트 끝-->

                    <!--페이징 시작-->
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item">
                                <a class="page-link" href="<c:choose>
                                <c:when test="${bbsList.page_no == 1}">#</c:when>
                                    <c:otherwise>? page_no=1</c:otherwise>
                                </c:choose>" aria-label="맨 앞">
                                    <span aria-hidden="true">&langle;&langle;</span>
                                </a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="<c:choose>
                                <c:when test="${bbsList.prev_page_flag}">? page_no = ${bbsList.block_start -1 }</c:when>
                                <c:otherwise>#</c:otherwise>
                                </c:choose>" aria-label="이전 블록">
                                    <span aria-hidden="true">&langle;</span>
                                </a>
                            </li>
                            <c:forEach begin="${bbsList.block_start}" end="${bbsList.block_end}" var="page_num">
                                <li class="page-item"><a class="page-link" href="?page_no=${page_num}">${page_num}</a></li>
                            </c:forEach>
                            <li class="page-item">
                                <a class="page-link" href="
                                        <c:choose>
                                            <c:when test="${bbsList.next_page_flag}">?page_no=${bbsList.block_end + 1}</c:when>
                                             <c:otherwise>#</c:otherwise>
                                        </c:choose>
                                " aria-label="다음 블럭">
                                    <span aria-hidden="true"> &rangle; </span>
                                </a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="<c:choose>
                                <c:when test="${bbsList.page_no == bbsList.tatal_pages}">#</c:when>
                                <c:otherwise>?page_no=${bbsList.total_pages}</c:otherwise>

                                </c:choose>" aria-label="맨뒤">
                                    <span aria-hidden="true">&rangle;&rangle;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <!--페이징 끝-->
                </div>
            </div>

        </div>
    </div>
    <!--    컨텐츠 끝-->
    <div class="row">

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>


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

    function goRegist() {
        location.href = "regist.do"
    }
</script>
</body>
</html>
