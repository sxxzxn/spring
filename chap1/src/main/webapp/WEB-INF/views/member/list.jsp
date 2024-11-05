<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: full5-5
  Date: 2024-11-05
  Time: 오후 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 목록</title>
</head>
<link rel="stylesheet" href="../../../resource/style.css">
<body>
<form name="frmList" id="frmList" method="GET">
    <table>
        <tbody>
        <tr>
            <th class="">체크</th>
            <th class="">번호</th>
            <th class="">아이디</th>
            <th class="">비밀번호</th>
            <th class="">이름</th>
            <th class="">회원상태</th>
            <th class="">가입일</th>
            <th class="">수정</th>
        </tr>
        <c:if test="${not empty mList}">
            <c:forEach var="dto" items="${mList}" varStatus="loop">
                <tr>
                    <td class=""><input type="checkbox" name="ids" value="${dto.memberId}"> </td>
                    <td class="">${loop.index+1}</td>
                    <td class=""><a href="/member/view.do?memberId=${dto.memberId}">${dto.memberId}</a></td>
                    <td class="">${dto.pwd}</td>
                    <td class="">${dto.name}</td>
                    <td class="">${dto.memberState}</td>
                    <td class="">${dUtil.localDateTimeToString(dto.regDate, "yyyy-MM-dd HH:mm:ss")}</td>
                    <td class=""><button onclick="javascript:goModifyMember('${dto.memberId}')">수정</button></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty mList}">
            <tr>
                <td colspan="8" class="align-center">
                    등록된 회원 정보가 없습니다.
                </td>
            </tr>
        </c:if>
        <tr>
            <td colspan="8" class="align-center">
                페이징영역
            </td>
        </tr>
        <tr>
            <td colspan="2" class="aligin-center">
                <input type="button" id="btnDeleteAll" value="선택삭제"/>
                <input type="button" id="btnToList" value="목록으로"/>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
