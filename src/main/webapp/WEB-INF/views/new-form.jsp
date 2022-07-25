<%@ page contentType = "text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
    <!-- WEB-INF 밑에 있는 자원들을 외부에서 호출해도 호출되지 않는다. was설정 관련 항상 컨트롤러를 거쳐서 호출해야한다.-->
    <form action="save" method="post">
        userName : <input type="text" name="username"/>
        age :      <input type="text" name="age"/>
        <button type="submit">전송</button>
    </form>
</body>
<html>