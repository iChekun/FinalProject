<%--
  Created by IntelliJ IDEA.
  User: nykec
  Date: 04.10.2019
  Time: 23:28
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
    <title>Title</title>
    <script src="js/alert.js"></script>
</head>
<body>

<div class="promt_window">
    <div class="overlay" style="display: none; z-index: 1;">
        <div class="login-wrapper">
            <div class="login-content" id="loginTarget">
                <a class="close">x</a>
                <h3><fmt:message key="label.change_password"/></h3>

                <form method="post" action="mainWindow">

                    <label for="curPass">
                        <fmt:message key="message.current_password"/>
                        <input type="password" name="currentPassword" id="curPass"
                               placeholder="" required
                               pattern="^[a-zA-Z][a-zA-Z0-9-_.]{6,15}$"/>
                    </label>
                    <label for="newPass">
                        <fmt:message key="message.new_password"/>
                        <input type="password" name="newPassword" id="newPass"
                               placeholder="" required
                               pattern="^[a-zA-Z][a-zA-Z0-9-_.]{6,15}$"/>
                    </label>
                    <label for="confNewPass">
                        <fmt:message key="message.confirm_password"/>
                        <input type="password" name="confirmedPassword" id="confNewPass"
                               placeholder=""
                               required
                               pattern="^[a-zA-Z][a-zA-Z0-9-_.]{6,15}$"/>
                    </label>
                    <button type="submit" name="action" value="changePassword">
                        <strong><fmt:message key="button.message.save"/></strong>
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
