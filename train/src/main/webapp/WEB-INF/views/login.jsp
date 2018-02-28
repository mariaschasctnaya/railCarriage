<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" media="all">
    <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/modalWindows.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.cookie.js"/>"></script>
</head>
<body>

<div class="container block-center-div">
    <div class="row align-items-end">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-4">
                    <a href="<c:url value = "/timetable"/>"
                       class="btn br2">TIMETABLE</a>
                </div>
                <div class="col-md-4">
                    <a href="<c:url value = "/"/>"
                       class="btn br2 ">TRAINS</a>
                </div>
                <div class="col-md-4">
                    <a href="<c:url value ="/login"/>"
                       class="btn br2 disabled">LOG
                        IN</a>
                </div>
            </div>
        </div>

        <div class="col-md-3"></div>
    </div>
    <div class="container text-center text-light">
        <h1>&nbsp;</h1>
        <h1>&nbsp; Log in to your account &nbsp; &nbsp;</h1>
    </div>

    <%--<div class="alert alert-danger alert-dismissable" id="errorAlertDiv">--%>
    <%--<a href="<c:url value="#"/>" class="close" aria-label="close"--%>
    <%--onclick="hideModalWindow('errorAlertDiv')">&times;</a>--%>
    <%--<strong id="errorMessage"></strong>--%>
    <%--</div>--%>

    <div class="container w-50 vcenter">
        <div class="form-control filter-blur popin">
            <form method="POST" autocomplete="off" action="j_spring_security_check">
                <div class="form-group">
                    <label class="control-label" for="login">LOGIN</label>
                    <div class="controls">
                        <input id="login" type="text" class="form-control" placeholder="Enter your login"
                               name="username"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label" for="login">PASSWORD</label>
                    <div class="controls">
                        <input id="password" type="password" class="form-control" placeholder="Enter your password"
                               name="password"/>
                    </div>
                </div>

                <div class="control-group">
                    <button type="submit" class="btn br2-search loginButton">LOG IN</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>