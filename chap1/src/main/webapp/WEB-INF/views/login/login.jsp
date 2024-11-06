<%--
  Created by IntelliJ IDEA.
  User: full5-5
  Date: 2024-11-05
  Time: 오전 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form name="rfmLogin" id="rfmLogin" action="/login/login.do" method="POST">
    <table>
        <tbody>
        <tr>
            <th>아이디 : </th>
            <td class="">
                <input type="text" name="memberId" id="memberId" value="" maxlength="20">
            </td>
        </tr>
        <tr>
            <th>비밀번호 : </th>
            <td class="">
                <input type="text" name="pwd" id="pwd" value="" maxlength="20">
            </td>
        </tr>
        <tr>
            <td  colspan="2" class="">
                <label for="saveId">아이디저장</label>
                <input type="checkbox" name="saveId"  id="saveId" value=<c:if test="${saveId eq 'Y'}" >'Y'</c:if>>
                &nbsp; <label for="autoLogin">자동로그인</label>
                <input type="checkbox" name="autoLogin"  id="autoLogin" value="Y">
            </td>
        </tr>

        <tr>
            <td  colspan="2" class="">
                <input type="submit" name="btnLogin"  value="로그인">
                <input type="button" name="btnMemberRegist"  value="회원가입">
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
