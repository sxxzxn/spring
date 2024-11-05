<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <th class="input_title"><label for="memberId">아이디</label></th>
            <td class="input_col">
                <input type="text" name="memberId" id="memberId" value=" ${dto.memberId}" maxlength="20" class="input_box_id">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="pwd">비밀번호</label></th>
            <td class="input_col">
                <input type="text" name="pwd" id="pwd" value="${dto.pwd}" maxlength="20" class="input_box_id">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="name">이름</label></th>
            <td class="input_col">
                <input type="text" name="name" id="name" value="${dto.name}" maxlength="20" class="input_box_id">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="jumin">주민번호</label></th>
            <td class="input_col">
                <input type="text" name="jumin" id="jumin" value="${dto.jumin}" maxlength="14" class="input_box_jumin">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="birthday">생년월일</label></th>
            <td class="input_col">
                <input type="date" name="birthday" id="birthday" value="${dto.birthday}" maxlength="10" class="input_box_birthday">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="addr1">주소1</label></th>
            <td class="input_col">
                <input type="text" name="addr1" id="addr1" value="${dto.addr1}" maxlength="100" class="input_box_addr">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="addr2">주소2</label></th>
            <td class="input_col">
                <input type="text" name="addr2" id="addr2" value="${dto.addr2}" maxlength="100" class="input_box_addr">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="jobCode_0">직업</label></th>
            <td class="input_col">
                <label for="jobCode_0">회사원</label><input type="radio" name="jobCode" id="jobCode_0" value="<c:if test="${dto.jobCode eq '회사원'}">회사원" </c:if>  class="input_box_radio"/>
                &nbsp;<label for="jobCode_1">운동선수</label><input type="radio" name="jobCode" id="jobCode_1" value="<c:if test="${dto.jobCode eq '운동선수'}">운동선수" </c:if>  class="input_box_radio"/>
                &nbsp;<label for="jobCode_2">의사</label><input type="radio" name="jobCode" id="jobCode_2" value="<c:if test="${dto.jobCode eq '의사'}">의사" </c:if>  class="input_box_radio"/>
                &nbsp;<label for="jobCode_3">가수</label><input type="radio" name="jobCode" id="jobCode_3" value="<c:if test="${dto.jobCode eq '가수'}">가수" </c:if>  class="input_box_radio"/>
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="mileage">마일리지</label></th>
            <td class="input_col">
                <input type="text" name="mileage" id="mileage" value="0" maxlength="100" class="input_box_id">
            </td>
        </tr>
        <tr>
            <th class="input_title"><label for="memberState_0">회원상태</label></th>
            <td class="input_col">
                <label for="memberState_0">정상</label><input type="radio" name="memberState" id="memberState_0" value="Y" class="input_box_radio"/>
                &nbsp;<label for="memberState_1">중지</label><input type="radio" name="memberState" id="memberState_1" value="N" class="input_box_radio"/>
                &nbsp;<label for="memberState_2">승인대기</label><input type="radio" name="memberState" id="memberState_2" value="S" class="input_box_radio"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="aligin-center">
                <input type="submit" id="btnRegist" value="회원가입"/>
                <input type="button" id="btnConcel" value="회원취소"/>
                <input type="button" id="btnToList" value="목록으로"/>
            </td>
        </tr>
        </tbody>
    </table>

</form>
</html>
