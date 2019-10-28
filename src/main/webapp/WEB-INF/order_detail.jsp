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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>
        <fmt:message key="label.order.detail"/>
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
                    <input type="hidden" name="orderId" value="${order.orderId}"/>
                    <input type="hidden" name="action" value="ViewOrderDetail"/>

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

                <c:if test="${actionTypeAllOrders == null}">
                    <li>
                        <a href="mainWindow?action=viewOrdersHistory">
                            <fmt:message key="label.view_buy_history"/>
                        </a>
                    </li>
                </c:if>
                <c:if test="${actionTypeAllOrders !=null}">
                    <li>
                        <a href="mainWindow?action=viewAllOrders">
                            <fmt:message key="label.view__all_buy_history"/>
                        </a>
                    </li>
                </c:if>


            </ul>
        </nav>
    </div>
</div>
<hr>


<div id="main-wrap">


    <div class="user_table_look">
        <div class="table_line">

        </div>
        <div style="margin: 15px 15px; text-decoration: underline; font-size: 19px;">
            <strong>
                <fmt:message key="order.history.detail"/>
            </strong>
        </div>
        <form action="mainWindow" method="post">
            <div class="start_table">
                <table class="table_outer">
                    <tr>
                        <td>
                            <div style="height:472px; overflow:auto; width: 100%;">
                                <table class="table_inner">
                                    <tr>
                                        <th><fmt:message key="table.message.user.name"/></th>
                                        <th><fmt:message key="table.message.user.surname"/></th>
                                        <th><fmt:message key="table.message.user.phoneNumber"/></th>
                                        <th><fmt:message key="label.buy_date"/></th>
                                        <th><fmt:message key="label.cost"/></th>
                                        <th><fmt:message key="label.payment_type"/></th>
                                        <th><fmt:message key="label.order_status"/></th>

                                        <th><fmt:message key="label.text.category_name"/></th>
                                        <th><fmt:message key="label.text.brand_name"/></th>
                                        <th><fmt:message key="label.text.product_name"/></th>
                                        <th><fmt:message key="label.text.product_description"/></th>
                                        <th><fmt:message key="label.text.product_image_path"/></th>
                                        <th><fmt:message key="label.text.product_cost"/></th>
                                    </tr>
                                    <c:forEach items="${productOrders}" var="productOrder">
                                        <tr>
                                            <td>
                                                    ${order.user.name}
                                            </td>
                                            <td>
                                                    ${order.user.surname}
                                            </td>
                                            <td>
                                                    ${order.user.contacts.phoneNumber}
                                            </td>

                                            <td>
                                                    ${productOrder.order.orderDate}
                                            </td>
                                            <td>${productOrder.order.cost}</td>
                                            <td>
                                                    ${productOrder.order.paymentMethod.name}
                                            </td>
                                            <td>
                                                    ${productOrder.order.orderStatus.name}
                                            </td>
                                            <td>${productOrder.product.category.name}
                                                <c:if test="${productOrder.product.category.name == null}">none</c:if>
                                            </td>
                                            <td>${productOrder.product.brand.name}
                                                <c:if test="${productOrder.product.brand.name == null}">none</c:if>
                                            </td>
                                            <td>
                                                    ${productOrder.product.name}
                                            </td>
                                            <td>${productOrder.product.description}</td>
                                            <td>

                                                <img src="${productOrder.product.imagePath}" alt="product_picture"
                                                     width="150" height="150">
                                            </td>
                                            <td>${productOrder.product.cost}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </td>
                    </tr>
                </table>

                <div class="table_line"></div>
                <br>

                <input type="hidden" name="nextPage" value="${nextPage}">
                <input type="hidden" name="orderId" value="${order.orderId}">
                <div class="category_buttons">

                    <button type="submit" name="action" value="invalidateOrder">
                        <strong>
                            <fmt:message key="label.invalidate_order"/>
                        </strong>
                    </button>
                    <c:if test="${sessionScope.userStatusId == 1}">
                        <p style="margin-left: 15%;margin-top: -5%;">
                            <input type="hidden" name="currentOrderStatusId" value="${currentOrderStatusId}">
                            <button type="submit" name="action" value="changeOrderStatus">
                                <strong>
                                    <fmt:message key="label.order.change_order_status"/>
                                </strong>
                            </button>
                        </p>
                    </c:if>
                </div>
            </div>
        </form>
    </div>
</div>

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
                    <img src="pictures/footer_pictures/velcom.jpg" alt="телефон" width="40" height="40">
                    <a class="contacts_info_a_position">+375-29-313-60-52 </a>

                    <br>

                    <img src="pictures/footer_pictures/mts.png" alt="телефон" width="40" height="40">
                    <a>8029-313-60-52 </a>
                    <br>
                    <img src="pictures/footer_pictures/viber.jpg" alt="телефон" width="40" height="40">
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
                    <img src="pictures/footer_pictures/sklad.jpg" alt="sklad" width="250" height="130">
                    <br><br><br>
                    <fmt:message key="footer.store_info.with_goodluck"/>
                </div>
            </td>
        </tr>
    </table>


    <div class="end_page">
        &copy 2019 Online store. All Rights Reserved | Design by&nbsp; <a>Ilya Chekun</a>
    </div>
</div>
</body>
</html>