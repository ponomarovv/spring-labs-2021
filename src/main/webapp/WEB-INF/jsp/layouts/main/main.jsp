<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <title>Hello, jsp</title>

        <link href="<c:url value="css/common.css" />" rel="stylesheet" />
        <link href="<c:url value="css/indentations.css" />" rel="stylesheet" />
        <link href="<c:url value="css/materialize.min.css" />" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/layouts/main/header.jsp" />

        <main>
            <jsp:include page="/WEB-INF/jsp/views/${_view}.jsp" />
        </main>

        <jsp:include page="/WEB-INF/jsp/layouts/main/footer.jsp" />

        <script type="text/javascript" src="<c:url value="js/materialize.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/startup.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/title-resolver.js" />"></script>
    </body>
</html>