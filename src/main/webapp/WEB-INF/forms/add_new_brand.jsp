<%--
  Created by IntelliJ IDEA.
  User: nykec
  Date: 18.10.2019
  Time: 15:55
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
</head>
<body>

<div class="promt_window">
    <div class="overlay" style="display: none;z-index: 1;">
        <div class="login-wrapper">
            <div class="login-content" id="loginTarget">
                <a class="close">x</a>
                <h3><fmt:message key="label.action.add_new_brand"/></h3>

                <form enctype="multipart/form-data" method="post" action="mainWindow">

                    <label for="brandNameInput"> <fmt:message key="label.text.brand_name"/></label>
                    <input id="brandNameInput"
                           required type="text" placeholder="name" name="brandName">


                    <label for="brandDescriptionInput"> <fmt:message key="label.text.brand_description"/></label>
                    <input id="brandDescriptionInput"
                           required type="text" placeholder="description" name="brandDescription">


                    <label for="brandImagePathInput"> <fmt:message key="label.text.brand_image_path"/></label>
                    <input id="brandImagePathInput"
                           type="text" placeholder="description" name="brandImagePath">


                    <button type="submit" name="action" value="addNewBrand">
                        <strong><fmt:message key="button.message.save"/></strong>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
