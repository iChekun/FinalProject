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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <%--                <li>--%>
                <%--                    <a href="mainWindow?action=viewCustomerProductTable">--%>
                <%--                        <fmt:message key="label.view_product_table"/>--%>
                <%--                    </a>--%>
                <%--                </li>--%>
                <li>
                    <a href="mainWindow?action=main">
                        <fmt:message key="label.view_main_page"/>
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
                    <a href="" class="overlayLink" style="margin-top: 50px;">
                        <fmt:message key="label.order.make_order"/>
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
                    <fmt:message key="label.order.product_in_basket"/>
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
                                            <th><fmt:message key="label.text.category_name"/></th>
                                            <th><fmt:message key="label.text.brand_name"/></th>
                                            <th><fmt:message key="label.text.product_name"/></th>
                                            <th><fmt:message key="label.text.product_description"/></th>
                                            <th><fmt:message key="label.text.product_image_path"/></th>
                                            <th><fmt:message key="label.text.product_cost"/></th>
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
                                    <fmt:message key="label.order.full_cost"/>
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
                                    <fmt:message key="label.order.delete_product_from_basket"/>
                                </strong>
                            </button>

                        </p>

                    </div>
                    <c:if test="${errorMessage == null}">
                        <c:if test="${fn:length(productsInBasket) le 0}">
                            <script>
                                showAlertMessage("<fmt:message key="${empty_basket}"/>");
                            </script>
                        </c:if>
                    </c:if>
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

                <h3><fmt:message key="label.order.make_order"/></h3>

                <form enctype="multipart/form-data" method="post" action="mainWindow">

                    <label for="paymentMethodName"> <fmt:message key="label.payment_method.choose_payment"/></label>

                    <select id="paymentMethodName" name="paymentMethodId">
                        <c:forEach items="${paymentMethods}" var="paymentMethod">
                            <option value="${paymentMethod.paymentMethodId}">
                                    ${paymentMethod.name}
                            </option>
                        </c:forEach>
                    </select>


                    <button type="submit" name="action" value="addNewOrder">
                        <strong> <fmt:message key="label.confirm"/></strong>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<c:if test="${errorMessage != null}">
    <script>
        showAlertMessage("<fmt:message key="${errorMessage}"/>");
    </script>
</c:if>
<c:remove var="errorMessage"/>

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
                    <br><br>
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
                <div class="payment_method_info">
                    <strong>Оплата при получении</strong>
                    <br><br>
                    <p><strong style="text-decoration: underline;">Наличный расчет</strong> <br></p>
                    <div class="text_indent">
                        Вы можете рассчитаться наличными денежными средствами при доставке товара курьером,
                        <br> а также при получении заказа в пункте самовывоза в г. Минске.
                    </div>

                    <br>

                    <strong style="text-decoration: underline;">Пластиковой картой через терминал</strong>
                    <br><br>
                    <div class="text_indent">
                        Расчет банковской картой с использованием мобильного терминала возможен при доставке товара
                        курьером по г. Минск и при получении товара в пункте самовывоза в г. Минске.

                    </div>

                </div>
            </td>

            <td>
                <div class="store_info">
                    <strong>
                        Спасибо что зашли на наш сайт!
                    </strong>
                    <br><br>
                    У нас есть огромнейший склад на более чем 100_000 товаров!
                    <br><br>
                    <img src="pictures/sklad.jpg" alt="sklad" width="250" height="130">
                    <br><br><br>
                    Приятных Вам покупок!
                </div>
            </td>
        </tr>
    </table>


    <div class="end_page">
        &copy 2019 Online store. All Rights Reserved | Design by&nbsp; <a href="">Ilya Chekun</a>
    </div>
</div>
</body>
</html>

