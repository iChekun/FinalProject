<%--
  Created by IntelliJ IDEA.
  User: nykec
  Date: 30.09.2019
  Time: 0:23
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
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        Корзина покупок
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
    <script src="js/alert.js"></script>
</head>
<body>


<div id="header">
    <div class="two">
        <h1><fmt:message key="shopname"/></h1>
    </div>

    <div class="container">

        <div class="new-select-style-locale">
            <form style="display: inline; margin-left: 20px">
                <div class="new-select-style-locale" style="margin-left: 340px; margin-top: -25px; ">
                    <input type="hidden" name="action" value="viewUserBasket"/>
                    <label for="locale"></label>
                    <select id="locale" name="locale" onchange="submit()">
                        <option value="en_EN" ${locale == 'en_EN' ? 'selected' : ''}>English</option>
                        <option value="ru_RU" ${locale == 'ru_RU' ? 'selected' : ''}>Русский</option>
                    </select>
                </div>
            </form>
        </div>

        <nav>
            <ul class="header" style="margin-right: -25%; margin-top: 3%">
                <li>
                    <a href="mainWindow?action=viewUserCabinet">
                        <fmt:message key="button.personal_cabinet"/>
                    </a>
                </li>
                <li>
                    <a href="mainWindow?action=viewCustomerProductTable">
                        View product table
                    </a>
                </li>
                <li>
                    <a href="mainWindow?action=main">
                        view main page
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
                            Меню
                        </fieldset>
                    </li>
                    <a href="" class="overlayLink">
                        Сделать заказ
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
                    <!--<fmt:message key="title.register"/>-->
                    Продукты в корзине
                </caption>
            </div>

            <form action="mainWindow" method="post">
                <div class="start_table">
                    <table class="table_outer">
                        <tr>
                            <td colspan="2">
                                <div style="height:472px; overflow:auto; width: 100%;">
                                    <table class="table_inner">
                                        <tr>
                                            <th width="7%">Choose for action</th>
                                            <th>Category name</th>
                                            <th>Brand name</th>
                                            <th>Product name</th>
                                            <th>Description</th>
                                            <th>Picture</th>
                                            <th>Cost</th>
                                        </tr>
                                        <c:forEach items="${productsInBasket}" var="product">
                                            <tr>
                                                <td width="10px">

                                                    <input style="float: left;"
                                                           class="radio" type="radio"
                                                           name="productForAction"
                                                           value="${product.product.productId}"/>
                                                </td>
                                                <td>${product.product.category.name}
                                                    <c:if test="${product.product.category.name == null}">none</c:if>
                                                </td>
                                                <td>${product.product.brand.name}
                                                    <c:if test="${product.product.brand.name == null}">none</c:if>
                                                </td>
                                                <td>
                                                        ${product.product.name}
                                                </td>
                                                <td>${product.product.description}</td>
                                                <td>

                                                    <img src="${product.product.imagePath}" alt="product_picture"
                                                         width="150" height="150">
                                                </td>
                                                <td>${product.product.cost}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong style="float:left;font-size: 18px;text-decoration: underline">
                                    full cost
                                </strong>
                            </td>
                            <td style="text-align: center; font-weight: bold;">
                                ${productsCost}
                            </td>
                        </tr>
                    </table>

                    <div class="table_line"></div>

                    <div class="category_buttons">

                        <p>
                            <button type="submit" name="action" value="deleteProductFromBasket">
                                <strong>
                                    Удалить продукт из корзины
                                    <!--                                       <fmt:message key="table.message.save"/>-->
                                </strong>
                            </button>

                        </p>

                    </div>
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

                <h3>Сделать заказ</h3>

                <form enctype="multipart/form-data" method="post" action="mainWindow">

                    <label for="paymentMethodName">Выберите способ оплаты</label>

                    <select id="paymentMethodName" name="paymentMethodId">
                        <c:forEach items="${paymentMethods}" var="paymentMethod">
                            <option value="${paymentMethod.paymentMethodId}">
                                    ${paymentMethod.name}
                            </option>
                        </c:forEach>
                    </select>


                    <button type="submit" name="action" value="addNewOrder">
                        <strong>Заказать</strong>
                    </button>
                    <c:if test="${orderMessage != null}">
                        <script>
                            showAlertMessage("<fmt:message key="${orderMessage}"/>");
                        </script>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
    <c:remove var="orderMessage"/>
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

