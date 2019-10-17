<%--
  Created by IntelliJ IDEA.
  User: nykec
  Date: 04.10.2019
  Time: 1:02
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
                <h3><fmt:message key="label.action.add_new_category"/> </h3>

                <form enctype="multipart/form-data" method="post" action="mainWindow">


                    <label for="categoryName"><fmt:message key="categoriesTable.name"/></label>
                    <input id="categoryName"
                           required type="text" placeholder="name"
                           name="categoryName">


                    <label for="categoryDescription"><fmt:message key="label.text.category_description"/></label>
                    <input id="categoryDescription"
                           required type="text" placeholder="description"
                           name="categoryDescription">


                    <label for="categoryImagePath"><fmt:message key="label.text.category_image_path"/></label>
                    <input id="categoryImagePath"
                           type="text" placeholder="description"
                           name="categoryImagePath">


                    <button type="submit" name="action" value="addNewCategory">
                        <strong>
                            <fmt:message key="button.message.save"/>
                        </strong>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
