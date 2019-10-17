<%--
  Created by IntelliJ IDEA.
  User: nykec
  Date: 26.09.2019
  Time: 23:19
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


<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<html>
<head>
    <meta charset="UTF-8">
    <title>
        <fmt:message key="label.text.product_table"/>
    </title>

    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/personal_cabinet_left_bar_menu.css" type="text/css"/>
    <link rel="stylesheet" href="css/category_table.css" type="text/css"/>
    <link rel="stylesheet" href="css/header.css" type="text/css"/>
    <link rel="stylesheet" href="css/footer.css" type="text/css"/>
    <link rel="stylesheet" href="css/buttons_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/locale_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/logo_style.css" type="text/css"/>

    <link rel="stylesheet" href="css/tables.css" type="text/css"/>

    <link rel="icon" href="pictures/logotip.jpg" type="image/x-icon">
    <link rel="shortcut icon" href="pictures/logotip.jpg" type="image/x-icon">


    <link href='http://fonts.googleapis.com/css?family=Varela+Round|Open+Sans:400,300,600' rel='stylesheet'
          type='text/css'>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="css/promtWindow.css" type="text/css"/>
    <script src="js/signIn.js"></script>

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
            <form style="display: inline; margin-left: 20px">
                <div class="new-select-style-locale" style="margin-left: 340px; margin-top: -25px; ">
                    <input type="hidden" name="action" value="viewProductTable"/>
                    <label for="locale"></label>
                    <select id="locale" name="locale" onchange="submit()">
                        <option value="en_EN" ${locale=='en_EN' ? 'selected' : ''}>English</option>
                        <option value="ru_RU" ${locale=='ru_RU' ? 'selected' : ''}>Русский</option>
                    </select>
                </div>
            </form>
        </div>

        <nav>
            <ul class="header" style="margin-right: -23%; margin-top: 3%">

                <li>
                    <a href="mainWindow?action=logout">
                        <fmt:message key="button.logout"/>
                    </a>
                </li>

                <li>
                    <a style="margin-right: 50px" href="mainWindow?action=viewUserCabinet">
                        <fmt:message key="button.personal_cabinet"/>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<hr>


<div id="main-wrap">

    <div id="sidebar">
        <div class="left_bar_menu_cabinet_style">
            <aside>
                <ul>
                    <li>
                        <fieldset>
                            <fmt:message key="table.message.title.menu"/>
                        </fieldset>
                    </li>
                    <li>
                        <a href="" class="overlayLink"
                           data-action="login-form.html">
                            <fmt:message key="label.action.product_table.add_new_product"/>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            Сортировкать<br>
                            список
                        </a>
                    </li>

                </ul>
            </aside>
        </div>
    </div>
    <div id="content-wrap">

        <div class="user_table_look">
            <div class="table_line">
                <caption>
                    <fmt:message key="label.text.product_table"/>
                </caption>
            </div>

            <form action="mainWindow" method="get">
                <div class="start_table">
                    <table class="table_outer">
                        <tr>
                            <td>
                                <div style="height:472px; overflow:auto; width: 100%;">
                                    <table class="table_inner">
                                        <tr>
                                            <th width="7%">Choose for action</th>
                                            <th><fmt:message key="label.text.product_category"/></th>
                                            <th><fmt:message key="label.text.product_brand"/></th>
                                            <th><fmt:message key="label.text.product_name"/></th>
                                            <th><fmt:message key="label.text.product_description"/></th>
                                            <th><fmt:message key="label.text.product_image_path"/></th>
                                            <th><fmt:message key="label.text.product_cost"/></th>
                                        </tr>
                                        <c:forEach items="${products}" var="product">
                                            <tr>
                                                <td width="10px">

                                                    <input type="hidden" name="action"
                                                           value="viewEditProduct">
                                                    <button class="shadow-btn"
                                                            type="submit" name="productForAction"
                                                            value="${product.productId}">
                                                        <span class="table_button">
                                                            Перейти
                                                        </span>
                                                    </button>
                                                </td>
                                                <td>${product.category.name}
                                                    <c:if test="${product.category.name == null}">none</c:if>
                                                </td>
                                                <td>${product.brand.name}
                                                    <c:if test="${product.brand.name == null}">none</c:if>
                                                </td>
                                                <td>
                                                        ${product.name}
                                                </td>
                                                <td>${product.description}</td>
                                                <td>

                                                    <img src="${product.imagePath}" alt="product_picture"
                                                         width="150" height="150">
                                                </td>
                                                <td>${product.cost}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>

                    <div class="table_line"></div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="promt_window">
    <div class="overlay" style="display: none;">
        <div class="login-wrapper">
            <div class="login-content" id="loginTarget">
                <a class="close">x</a>
                <h3> <fmt:message key="label.action.product_table.add_new_product"/></h3>

                <form enctype="multipart/form-data" method="post" action="mainWindow">

                    <label for="category"> <fmt:message key="label.text.product_category"/></label>
                    <select id="category" name="categoryId">
                        <option disabled selected value> -- select an option --</option>
                        <c:forEach items="${categories}" var="order">
                            <option value="${order.categoryId}">${order.name}</option>
                        </c:forEach>
                        <option value><fmt:message key="label.select.none"/></option>
                    </select>


                    <label for="brand"> <fmt:message key="label.text.product_brand"/></label>
                    <select id="brand" name="brandId">
                        <option disabled selected value> -- select an option --</option>
                        <c:forEach items="${brands}" var="brand">
                            <option value="${brand.brandId}">${brand.name}</option>
                        </c:forEach>
                        <option value><fmt:message key="label.select.none"/></option>
                    </select>


                    <label for="productName"> <fmt:message key="label.text.product_name"/></label>
                    <input id="productName" type="text" required name="productName" value=""/>


                    <label for="productDescription"> <fmt:message key="label.text.product_description"/></label>
                    <input id="productDescription" type="text" required name="productDescription" value=""/>


                    <label for="productImagePath"> <fmt:message key="label.text.product_image_path"/></label>
                    <input id="productImagePath" type="text" name="productImagePath" value=""/>


                    <label for="productCost"> <fmt:message key="label.text.product_cost"/></label>
                    <input id="productCost" type="number" min="1" step="any" required name="productCost" value=""/>


                    <button type="submit" name="action" value="addNewProduct">
                        <strong> <fmt:message key="label.confirm"/></strong>
                    </button>
                </form>
            </div>
        </div>
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
<c:remove var="products"/>
</body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Product table</title>--%>

<%--    <link rel="stylesheet" href="css/main.css" type="text/css"/>--%>
<%--    <link rel="stylesheet" href="css/logo_look.css" type="text/css"/>--%>
<%--    <link rel="stylesheet" href="css/admin_cabinet.css" type="text/css"/>--%>
<%--    <link rel="stylesheet" href="css/users_table.css" type="text/css"/>--%>


<%--    <link rel="icon" href="pictures/logotip.jpg" type="image/x-icon">--%>
<%--    <link rel="shortcut icon" href="pictures/logotip.jpg" type="image/x-icon">--%>

<%--</head>--%>
<%--<body>--%>

<%--<div class="header_back">--%>
<%--    <div class="container">--%>
<%--        <div class="two"><h1>Online store</h1>--%>
<%--            <form style="display: inline; margin-left: 20px">--%>
<%--                <div class="new-select-style-locale" style="margin-left: 340px; margin-top: -25px; ">--%>
<%--                    <input type="hidden" name="action" value="adminWorkWithUsers"/>--%>
<%--                    <label for="locale"></label>--%>
<%--                    <select id="locale" name="locale" onchange="submit()">--%>
<%--                        <option value="en_EN" ${locale == 'en_EN' ? 'selected' : ''}>English</option>--%>
<%--                        <option value="ru_RU" ${locale == 'ru_RU' ? 'selected' : ''}>Русский</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--            <nav>--%>
<%--                <ul class="header">--%>
<%--                    <li>--%>
<%--                        <a href="mainWindow?action=userCabinet">--%>
<%--                            <fmt:message key="button.personal_cabinet"/>--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="mainWindow?action=viewUserBasket">--%>
<%--                            view user basket--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<hr>--%>


<%--<div id="re">--%>

<%--    <div id="sidebar-users">--%>

<%--        <div style="margin-top: 10px; margin-bottom: 2px;">--%>
<%--            &lt;%&ndash;            <fieldset style="margin-left: -2%;margin-top: 2px;">&ndash;%&gt;--%>
<%--            &lt;%&ndash;                <form action="mainWindow" method="get">&ndash;%&gt;--%>
<%--            &lt;%&ndash;                    <input style="margin-top: 0%; float: left;"&ndash;%&gt;--%>
<%--            &lt;%&ndash;                           type="submit" name="action" value="adminWorkWithUsers"/>&ndash;%&gt;--%>
<%--            &lt;%&ndash;                </form>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            </fieldset>&ndash;%&gt;--%>

<%--            <form action="mainWindow" method="get">--%>

<%--                <fieldset style="margin-left: -2%;margin-top: 10px;">--%>
<%--                    <input style="margin-top: 1%; float: left;"--%>
<%--                           type="submit" name="action" value="viewProductTableSorted"/>--%>
<%--                </fieldset>--%>
<%--            </form>--%>

<%--            <form action="mainWindow" method="get">--%>
<%--                <fieldset style="margin-left: -2%;margin-top: 10px;">--%>
<%--                    <input type="hidden" name="action" value="viewAddNewProduct">--%>
<%--                    <input style="margin-top: 1%; float: left;"--%>
<%--                           type="submit" name="action" value="addNewPaymentMethod new product"/>--%>
<%--                </fieldset>--%>
<%--            </form>--%>


<%--            <form method="post" action="mainWindow">--%>


<%--                <c:if test="${userStatusId == 1}">--%>
<%--                <fieldset style="margin-left: -2%;margin-top: 2px;">--%>
<%--                    <input style="float: left; margin-top: 0%;"--%>
<%--                           type="submit" name="action" value="delete"/>--%>
<%--                </fieldset>--%>
<%--                </c:if>--%>
<%--                &lt;%&ndash;                <fieldset style="margin-left: -2%;margin-top: 2px;">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <input style="float: left;margin-top: 0px;"&ndash;%&gt;--%>
<%--                &lt;%&ndash;                           type="submit" name="action" value="updateUserStatus"/>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </fieldset>&ndash;%&gt;--%>

<%--                &lt;%&ndash;                <c:if test="${userStatusId ==2}">&ndash;%&gt;--%>
<%--                <input type="submit" name="action" value="addProductToBasket">--%>
<%--                &lt;%&ndash;                </c:if>&ndash;%&gt;--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<!--    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\-->--%>

<%--<div id="content_wrap_user">--%>

<%--    <div class="underline_table_header">--%>
<%--        <div class="table-header">--%>
<%--            <caption>Product table</caption>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <table cellspacing="0" cellpadding="0" border="2" style="width: 100%;table-layout: fixed;">--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <div style="height:472px; overflow:auto; width: 100%;">--%>
<%--                    <table class="table_inner" cellspacing="0" cellpadding="1" border="1">--%>
<%--                        <tr>--%>
<%--                            <th>Choose for action</th>--%>
<%--                            <th>Category name</th>--%>
<%--                            <th>Brand name</th>--%>
<%--                            <th>Product name</th>--%>
<%--                            <th>Description</th>--%>
<%--                            <th>Picture</th>--%>
<%--                            <th>Cost</th>--%>

<%--                        </tr>--%>
<%--                        <c:forEach items="${products}" var="user">--%>
<%--                            <tr>--%>
<%--                                <td width="10px">--%>
<%--                                    <label style="width: 50px; float: left;">--%>

<%--                                        <input style="margin-left: -55px; float: left;"--%>
<%--                                               class="radio" type="radio"--%>
<%--                                               name="productForAction" value="${user.productId}">--%>

<%--&lt;%&ndash;                                        <input type="hidden"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                               name="productForAction" value="${user.productId}">&ndash;%&gt;--%>
<%--                                    </label>--%>

<%--                                </td>--%>
<%--                                <td>${user.category.name}</td>--%>
<%--                                <td>${user.brand.name}</td>--%>
<%--                                <td>${user.name}</td>--%>
<%--                                <td>${user.description}</td>--%>
<%--                                <td>${user.imagePath}</td>--%>
<%--                                <td>${user.cost}</td>--%>
<%--                            </tr>--%>
<%--                        </c:forEach>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</div>--%>


<%--</body>--%>
<%--</html>--%>

