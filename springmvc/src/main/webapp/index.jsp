<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<br/>
<ul>
  <li>게시판
    <ul>
      <li><a href="bbs/list.do?pageNo=&pageSize=&sortField=&sortOrder=">목록</a> </li>
      <li><a href="bbs/view.do?idx=1&pageNo=&pageSize=&sortField=&sortOrder=">조회</a> </li>
      <li><a href="bbs/regist.do">등록</a> </li>
      <li><a href="bbs/modify.do">수정</a> </li>
    </ul>
  </li>
</ul>
</body>
</html>