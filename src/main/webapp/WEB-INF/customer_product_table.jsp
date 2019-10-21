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
        <fmt:message key="label.customer_product_table"/>
    </title>

    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/left_side_bar.css" type="text/css"/>

    <link rel="stylesheet" href="css/category_table.css" type="text/css"/>
    <link rel="stylesheet" href="css/header.css" type="text/css"/>
    <link rel="stylesheet" href="css/footer.css" type="text/css"/>
    <link rel="stylesheet" href="css/buttons_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/locale_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/logo_style.css" type="text/css"/>

    <link rel="stylesheet" href="css/product_table_to_customer.css" type="text/css"/>
    <link rel="stylesheet" href="css/buy_button_style.css" type="text/css"/>

    <link rel="icon" href="pictures/logotip.jpg" type="image/x-icon">
    <link rel="shortcut icon" href="pictures/logotip.jpg" type="image/x-icon">


    <script src="js/change_text.js"></script>

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
                    <input type="hidden" name="action" value="viewCustomerProductTable"/>
                    <label for="locale"></label>
                    <select id="locale" name="locale" onchange="submit()">
                        <option value="en_EN" ${locale=='en_EN' ?    'selected' : ''}>English
                        </option>
                        <option value="ru_RU" ${locale=='ru_RU' ?'selected' : ''}>Русский
                        </option>
                    </select>
                </div>
            </form>
        </div>

        <nav>
            <ul class="header" style="margin-right: -23%; margin-top: 3%">

                <c:if test="${userId!=null}">
                    <li>
                        <a href="mainWindow?action=viewUserBasket">
                            <fmt:message key="label.view_user_basket"/>
                        </a>
                    </li>
                </c:if>
                <li>
                    <a style="margin-right: 50px" href="mainWindow?action=main">
                        <fmt:message key="button.go_home"/>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<hr>


<div id="main-wrap">


    <form action="mainWindow" method="get">
        <div id="sidebar">
            <aside>
                <ul>
                    <li class="catalog_name_style">
                        <fieldset>
                            <img style="float: left;"
                                 src="pictures/calatog.png" height="50" width="50" alt="catalog"/>
                            Каталог товаров
                        </fieldset>
                    </li>
                    <li>
                        <fieldset style="padding: 7px;">
                            <label for="category"> <fmt:message key="label.text.product_category"/></label>
                            <br><br>
                            <select id="category" name="categoryId">
                                <option disabled selected value> -- select an option --</option>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.categoryId}"
                                            <c:if test="${category.categoryId == currentCategoryId}">selected</c:if>>
                                            ${category.name}
                                    </option>
                                </c:forEach>
                                <option value><fmt:message key="label.select.none"/></option>
                            </select>
                        </fieldset>
                    </li>
                    <li style="margin-top:25px;">
                        <fieldset style="padding: 7px;">
                            <label for="brand"><fmt:message key="label.text.product_brand"/></label>
                            <br><br>
                            <select id="brand" name="brandId">
                                <option disabled selected value> -- select an option --</option>
                                <c:forEach items="${brands}" var="brand">
                                    <option value="${brand.brandId}"
                                            <c:if test="${brand.brandId == currentBrandId}">selected</c:if>>
                                            ${brand.name}</option>
                                </c:forEach>

                                <option value><fmt:message key="label.select.none"/></option>

                            </select>
                        </fieldset>
                        ${currentBrandId}
                    </li>
                    <%--                    <li>--%>
                    <%--                        3. скролл по цене--%>
                    <%--                    </li>--%>

                    <li>
                        <p style="margin-top: 25px;">
                            <button type="submit" name="action"
                                    style="height: 30px;padding: 2px; margin: 5px; text-aling:center;"
                                    value="viewCustomerProductTableWithBrandAndCategory">
                                <strong>
                                    показать
                                </strong>
                            </button>
                        </p>

                    </li>
                </ul>
            </aside>

        </div>
    </form>
    <div id="content-wrap">

        <div class="customer_product_table">
            <div class="table_line"></div>
            <form action="mainWindow" method="post">
                <table>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>


                    <c:forEach varStatus="count" items="${products}" var="product">

                        <c:if test="${ (count.count % 3) == 1 }">
                            <tr></tr>
                        </c:if>

                        <td>
                            <div class="product">
                                <div class="product-img">
                                    <a href="#">
                                        <img src="${product.imagePath}" alt="product_picture"
                                             width="131" height="196">
                                    </a>
                                </div>
                                <p class="product-title">
                                    <a href="#">
                                        <strong>${product.brand.name}</strong>
                                            ${product.name}
                                    </a>
                                </p>
                                <p class="product-desc">
                                        ${product.description}
                                </p>

                                <p class="product-price">Price: €${product.cost}</p>


                                <p class="buy_product">


                                    <button class="btn" type="submit"
                                            name="productForAction"
                                            value="${product.productId}">
                                        <fmt:message key="label.customer_product_table.put_in_basket"/>
                                    </button>
                                    <input type="hidden" name="action" value="addProductToBasket">
                                </p>

                            </div>
                        </td>
                    </c:forEach>

                </table>
                <c:if test="${errorMessage !=null}">
                    <script>
                        showAlertMessage("<fmt:message key="${errorMessage}"/>");
                    </script>
                </c:if>
            </form>
            <div class="table_line"></div>
        </div>
    </div>
    <c:remove var="errorMessage"/>
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