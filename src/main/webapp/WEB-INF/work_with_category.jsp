<%@ page contentType="text/html;charset=windows-1251;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale"
       value="${not empty param.locale ? param.locale : not empty locale ? locale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text"/>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="title.register"/></title>

    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/left_side_bar.css" type="text/css"/>
    <link rel="stylesheet" href="css/header.css" type="text/css"/>
    <link rel="stylesheet" href="css/search_line.css" type="text/css"/>
    <link rel="stylesheet" href="css/footer.css" type="text/css"/>
    <link rel="stylesheet" href="css/buttons_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/locale_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/logo_style.css" type="text/css"/>
    <link rel="stylesheet" href="css/user_table_look.css" type="text/css"/>

    <link rel="icon" href="pictures/logotip.jpg" type="image/x-icon">
    <link rel="shortcut icon" href="pictures/logotip.jpg" type="image/x-icon">

    <link href='http://fonts.googleapis.com/css?family=Varela+Round|Open+Sans:400,300,600' rel='stylesheet'
          type='text/css'>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/alert.js"></script>
</head>
<body>

<div id="header">
    <div class="two">
        <h1>
            <fmt:message key="shopname"/>
        </h1>
    </div>

    <div class="container">

        <div class="new-select-style-locale">
            <form style="display: inline; margin-left: 60px;">
                <div class="new-select-style-locale" style="margin-left: 340px; margin-top: -25px; ">
                    <input type="hidden" name="action" value="viewEditCategory">
                    <input type="hidden" name="categoryId" value="${category.categoryId}">
                    <label for="locale"></label>
                    <select id="locale" name="locale" onchange="submit()">
                        <option value="en_EN" ${locale == 'en_EN' ? 'selected' : ''}>English</option>
                        <option value="ru_RU" ${locale == 'ru_RU' ? 'selected' : ''}>Русский</option>
                    </select>
                </div>
            </form>
        </div>

        <nav>
            <ul class="header" style="margin-right: -23%; margin-top: 3%">
                <li>

                    <a href="mainWindow?action=viewCategoriesTable">
                        <fmt:message key="label.view_category_table"/>
                    </a>

                </li>
            </ul>
        </nav>
    </div>
</div>
<hr>


<div id="main-wrap">
    <div class="user_table_look" style="padding: 10% 5%">


        <strong style="margin-left: 10%;margin-bottom: 15%;font-size: 145%;text-decoration: underline;">
            <fmt:message key="title_category_work_with_category"/>
        </strong>
        <form enctype="multipart/form-data" method="post" action="mainWindow">


            <label style="font-size: 100%; font-weight: bold;" for="categoryName"> <fmt:message
                    key="label.text.category_name"/></label>
            <input id="categoryName"
                   required type="text" placeholder="name"
                   name="categoryName" value=${category.name}>


            <label style="font-size: 100%; font-weight: bold;" for="categoryDescription"><fmt:message
                    key="label.text.category_description"/>
                description</label>
            <input id="categoryDescription"
                   required type="text" placeholder="description"
                   name="categoryDescription" value=${category.description}>


            <label style="font-size: 100%; font-weight: bold;" for="categoryImagePath"><fmt:message
                    key="label.text.category_image_path"/></label>
            <input id="categoryImagePath"
                   type="text" placeholder="image"
                   name="categoryImagePath" value=${category.imagePath}>

            <div class="category_buttons">

                <p>
                    <input type="hidden" name="categoryId" value=${category.categoryId}>
                    <button type="submit" name="action" value="editCategory">
                        <strong>
                            <fmt:message key="label.change"/>
                        </strong>
                    </button>
                <p style="margin-left: 20%;margin-top: -3.4%;">
                    <button type="submit" name="action" value="deleteCategory">
                        <strong>
                            <fmt:message key="label.delete"/>
                        </strong>
                    </button>
            </div>
            <c:if test="${workWithCategoryMessage !=null}">
                <script>
                    showAlertMessage("<fmt:message key="${workWithCategoryMessage}"/>");
                </script>
            </c:if>

        </form>
        <c:remove var="workWithCategoryMessage"/>
    </div>
</div>

<hr>
<div id="footer">
    <table>
        <tr style="text-decoration: underline;">
            <th>Телефоны для связи</th>
            <th>Условия оплаты</th>
            <th> О магазине</th>
        </tr>

        <tr>
            <td>
                <div class="contacts_info">
                    <br>
                    Обработка заказов
                    с 8 до 22 без выходных
                    <br>
                    <img src="pictures/velcom.jpg" alt="телефон" width="40" height="40">
                    <a class="contacts_info_a_position">+375-29-313-60-52 </a>

                    <br>

                    <img src="pictures/mts.png" alt="телефон" width="40" height="40">
                    <a>8029-313-60-52 </a>
                    <br>
                    <img src="pictures/viber.jpg" alt="телефон" width="40" height="40">
                    <a>8029-313-60-52 </a>
                </div>
            </td>

            <td>
                <a href=""> Ифно</a>
            </td>

            <td>инфо</td>
        </tr>
    </table>


    <div class="end_page">
        &copy 2019 Online store. All Rights Reserved | Design by&nbsp; <a href="">Ilya Chekun</a>
    </div>
</div>
</body>
</html>


