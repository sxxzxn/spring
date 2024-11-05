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
    <title>Title</title>
</head>
<link rel="stylesheet" href="../../../resource/style.css">
<body>
<form name="frmRegsit" id="frmRegist" action="/member/regist.do" method="POST">
    <table>
        <tbody>
        <tr>
            <th class="input_title">아이디</th>
            <td class="input_col">
                ${dto.memberId}
            </td>
        </tr>
        <tr>
            <th class="input_title">비밀번호</th>
            <td class="input_col">
                ${dto.pwd}
            </td>
        </tr>
        <tr>
            <th class="input_title">이름</th>
            <td class="input_col">
                ${dto.name}
            </td>
        </tr>
        <tr>
            <th class="input_title">주민번호</th>
            <td class="input_col">
                ${dto.jumin}
            </td>
        </tr>
        <tr>
            <th class="input_title">생년월일</th>
            <td class="input_col">
                ${dto.birthday}
            </td>
        </tr>
        <tr>
            <th class="input_title">주소</th>
            <td class="input_col">
                ${dto.addr1} ${dto.addr2}
            </td>
        </tr>
<%--        <tr>--%>
<%--            <th class="input_title">주소2</th>--%>
<%--            <td class="input_col">--%>
<%--                ${dto.addr2}--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <th class="input_title">직업</th>
            <td class="input_col">
                ${dto.jobCode}
            </td>
        </tr>
        <tr>
            <th class="input_title">마일리지</th>
            <td class="input_col">
                ${dto.mileage}
            </td>
        </tr>
        <tr>
            <th class="input_title">회원상태</th>
            <td class="input_col">
                ${dto.memberState}
            </td>
        </tr>
        <tr>
            <td colspan="2" class="aligin-center">
                <input type="submit" id="btnModify" value="회원수정"/>
                <input type="button" id="btnDelete" onclick="/member/delete.do" value="회원삭제"/>
                <input type="button" id="btnToList" value="목록으로"/>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
