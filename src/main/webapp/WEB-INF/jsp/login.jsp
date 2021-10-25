<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Login</title>

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="<c:url value="/css/common.css" />" rel="stylesheet" />
        <link href="<c:url value="/css/indentations.css" />" rel="stylesheet" />
        <link href="<c:url value="/css/materialize.min.css" />" rel="stylesheet" />
    </head>

    <body>
        <div class="window-height window-width yellow lighten-5 s-vflex-center">
            <div class="container">
                <div class="row">
                    <div class="col s12 m4 push-m4">
                        <div class="pb10 px10 radius-4 z-depth-1">
                            <form action="" method="post" class="auto-height">
                                <div class="full-width input-field col s12">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="login" type="text" name="login" />
                                    <label for="login">Login</label>
                                </div>
                                <div class="full-width input-field col s12">
                                    <i class="material-icons prefix">lock</i>
                                    <input id="password" type="password" name="password" />
                                    <label for="password">Password</label>
                                </div>
                                <div class="col s12">
                                    <button class="full-width btn waves-effect waves-light" type="submit">
                                        Login
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="<c:url value="/js/materialize.min.js" />"></script>
    </body>
</html>