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
<c:import url="WEB-INF/forms/add_new_product.jsp"/>

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
                        <a href="" class="overlayLink">
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
<c:if test="${errorMessage !=null}">
    <script>
        showAlertMessage("<fmt:message key="${errorMessage}"/>");
    </script>
</c:if>
<c:remove var="errorMessage"/>


<hr>
<div id="footer">
    <table>
        <tr style="text-decoration: underline;">
            <th><fmt:message key="footer.phone_for_call"/></th>
            <th><fmt:message key="footer.terms_of_payment"/></th>
            <th><fmt:message key="footer.about_shop"/></th>
        </tr>

        <tr>
            <td>
                <div class="contacts_info">
                    <br>
                    <fmt:message key="footer.order_processing"/>
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
                    <strong> <fmt:message key="footer.payment.pay_receipt"/></strong>
                    <br><br>
                    <p><strong style="text-decoration: underline;"> <fmt:message key="footer.payment_cash"/></strong>
                        <br></p>
                    <div class="text_indent">
                        <fmt:message key="footer.payment_text_cash"/>
                    </div>

                    <br>

                    <strong style="text-decoration: underline;"> <fmt:message key="footer.payment_card"/></strong>
                    <br><br>
                    <div class="text_indent">
                        <fmt:message key="footer.payment_text_card"/>
                    </div>

                </div>
            </td>

            <td>
                <div class="store_info">
                    <strong>
                        <fmt:message key="footer.store_info.thanks_for_visit"/>
                    </strong>
                    <br><br>
                    <fmt:message key="footer.store_info.about_storage"/>
                    <br><br>
                    <img src="pictures/sklad.jpg" alt="sklad" width="250" height="130">
                    <br><br><br>
                    <fmt:message key="footer.store_info.with_goodluck"/>
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

