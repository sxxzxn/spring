<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<div class="container-fluid">
    <!--    상단 네비게이션 시작-->
    <jsp:include page="../common/header.jsp" />
    <!--    상단 네비게이션 끝-->


    <!--    컨텐츠 시작-->
    <div class="row content">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    글작성
                </div>
                <div class="card-body">
                    <!--검색영역 시작-->
                    <!--검색영역 끝-->

                    <!--글 내용 시작-->
                    <form id="frmRegist" action="/bbs/regist.do" method="post">
                        <div class="form-group row">
                            <label for="memberId" class="col-sm-2 col-form-label">아이디</label>
                            <div class="col-sm-10">
                                <input type="text" name="memberId" class="form-control" maxlength="20" id="memberId" >
                                <div id="div_err_memberId" style="display: none;"></div>
                            </div>
                        </div>
<%--                        <div class="form-group row">
                            <label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
                            <div class="col-sm-10">
                                <input type="password" name="pwd" class="form-control"  maxlength="20" id="inputPassword3">
                            </div>
                        </div>--%>
                        <div class="form-group row">
                            <label for="displayDate" class="col-sm-2 col-form-label">노출일</label>
                            <div class="col-sm-10">
                                <input type="date" name="displayDate" class="form-control" id="displayDate" >
                                <div id="div_err_displayDate" style="display: none;"></div>
                                <div id="div_err_idx" style="display: none;"></div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="title" class="col-sm-2 col-form-label">제목</label>
                            <div class="col-sm-10">
                                <input type="text" name="title" class="form-control"  maxlength="50" id="title" >
                                <div id="div_err_title" style="display: none;"></div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="content" class="col-sm-2 col-form-label">글내용</label>
                            <div class="col-sm-10">
                                <textarea name="content" class="form-control" rows="5" maxlength="1000" id="content"  style="resize: none;"></textarea>
                                <div id="div_err_content" style="display: none;"></div>
                            </div>
                        </div>
                        <!--체크박스 영역-->
                        <!--
                        <fieldset class="form-group row">
                            <legend class="col-form-label col-sm-2 float-sm-left pt-0">Radios</legend>
                            <div class="col-sm-10">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
                                    <label class="form-check-label" for="gridRadios1">
                                        First radio
                                    </label>
                                </div>

                              <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
                                    <label class="form-check-label" for="gridRadios2">
                                        Second radio
                                    </label>
                                </div>
                                <div class="form-check disabled">
                                    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
                                    <label class="form-check-label" for="gridRadios3">
                                        Third disabled radio
                                    </label>
                                </div>
                            </div>
                        </fieldset>
                        <div class="form-group row">
                            <div class="col-sm-10 offset-sm-2">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="gridCheck1">
                                    <label class="form-check-label" for="gridCheck1">
                                        Example checkbox
                                    </label>
                                </div>
                            </div>
                        </div>-->
                        <!--체크박스 영역 끝-->
                        <div class="form-group row justify-content-center mt-3">
                            <div class="col-sm-3">
                                <button type="submit" id="btnModify" class="btn btn-primary" >등록</button>
                                <button type="button" id="btnBack" class="btn btn-dark" onclick="goBack()">목록</button>
                            </div>
                        </div>
                    </form>
                    <!--글 내용 끝-->
                </div>
            </div>
        </div>
    </div>
    <!--    컨텐츠 끝-->
    <div class="row">
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<script>
    function goBack(){
        history.back();
    }

    const svrValidateResult = {};
    <c:forEach items="${errors}" var="err">
        if (document.getElementById("div_err_${err.getField()}") != null){
            document.getElementById("div_err_${err.getField()}").innerHTML="<span style='color:red'>${err.getField()} 필드는 ${err.defaultMessage}</span>"
            document.getElementById("div_err_${err.getField()}").style.display = "block";
    }
    svrValidateResult['${err.defaultMessage}'] = '${err.defaultMessage}' ;
    </c:forEach>

    console.log(svrValidateResult);
</script>
</body>
</html>
