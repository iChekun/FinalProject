<%--
  Created by IntelliJ IDEA.
  User: nykec
  Date: 04.10.2019
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale"
       value="${not empty param.locale ? param.locale : not empty locale ? locale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text"/>

<html>
<head>
    <link href='http://fonts.googleapis.com/css?family=Varela+Round|Open+Sans:400,300,600' rel='stylesheet'
          type='text/css'>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="css/promtWindow.css" type="text/css"/>
    <script src="js/signIn.js"></script>
    <script src="js/alert.js"></script>
</head>
<body>

<div class="promt_window">
    <div class="overlay" style="display: none;z-index: 10;">
        <div class="login-wrapper">
            <div class="login-content" id="loginTarget">
                <a class="close">x</a>
                <h3><fmt:message key="button.signIn"/></h3>

                <form method="post" action="mainWindow">
                    <label for="username">
                        <fmt:message key="table.message.user.login"/>
                        <input type="text" name="login" id="username"
                               placeholder="" required/>
                        <!--   pattern="^[a-zA-Z][a-zA-Z0-9-_.]{8,20}$"-->
                    </label>
                    <label for="password">
                        <fmt:message key="table.message.user.password"/>
                        <input type="password" name="password" id="password"
                               placeholder="" required/>
                        <!--   pattern="(?=^.{8,}$)((?=.*d)|(?=.*W+))(?![.n])(?=.*[A-Z])(?=.*[a-z]).*$"-->
                    </label>

                    <button type="submit" name="action" value="signIn">
                        <strong> <fmt:message key="confirm.signIn"/></strong>
                    </button>
                </form>
            </div>
        </div>
    </div>

    <c:if test="${errorMessage !=null}">
        <script>
            showAlertMessage("<fmt:message key="${errorMessage}"/>");
        </script>
    </c:if>
    <c:remove var="errorMessage"/>
</div>


</body>
</html>
