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
        product table
    </title>

    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/personal_cabinet_left_bar_menu.css" type="text/css"/>
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
                            show user basket
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

    <div id="sidebar">
        <div class="left_bar_menu_cabinet_style">
            <form action="mainWindow" method="get">
                <aside>
                    <ul>
                        <li>
                            <fieldset>
                                <fmt:message key="table.message.title.menu"/>
                            </fieldset>
                        </li>
                        <li>
                            <label for="category">Product category</label>
                            <select id="category" name="categoryId">
                                <c:forEach items="${categories}" var="order">
                                    <option value="${order.categoryId}"
                                            <c:if test="${order.categoryId == currentCategoryId}">selected</c:if>>
                                            ${order.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </li>
                        <li>
                            <label>Product brand</label>
                            <c:forEach items="${brands}" var="brand">
                                <%--                                <option value="${brand.brandId}"--%>
                                <%--                                        <c:if test="${brand.brandId == currentBrandId}">selected</c:if>>--%>
                                <%--                                        ${brand.name}</option>--%>

                                <p><input type="checkbox" name="brandId" value="${brand.brandId}">${brand.name}</p>
                            </c:forEach>


                            <%--                            <label for="brand">Product brand</label>--%>
                            <%--                            <select id="brand" name="brandId">--%>
                            <%--                                <c:forEach items="${brands}" var="brand">--%>
                            <%--                                    <option value="${brand.brandId}"--%>
                            <%--                                            <c:if test="${brand.brandId == currentBrandId}">selected</c:if>>--%>
                            <%--                                            ${brand.name}</option>--%>
                            <%--                                </c:forEach>--%>
                            <%--                            </select>--%>
                        </li>
                        <li>
                            3. скролл по цене
                        </li>

                        <li>
                            <p>
                                <button type="submit" name="action"
                                        value="viewCustomerProductTableWithBrandAndCategory">
                                    <strong>
                                        показать
                                    </strong>
                                </button>
                            </p>
                        </li>
                    </ul>
                </aside>
            </form>
        </div>
    </div>
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
                                        В корзину
                                    </button>
                                    <input type="hidden" name="action" value="addProductToBasket">
                                </p>
                                    <%--                                <p class="buy_product">--%>
                                    <%--                                <div class="button">--%>
                                    <%--                            <span>--%>

                                    <%--                                <button--%>
                                    <%--                                        type="submit" name="productForAction" value="${product.productId}">--%>
                                    <%--                                    buy--%>
                                    <%--                                </button>--%>

                                    <%--                                <input type="hidden" name="action" value="addProductToBasket">--%>

                                    <%--                            </span></div>--%>

                            </div>
                        </td>
                    </c:forEach>

                </table>
                <c:if test="${addProductMessage !=null}">
                    <script>
                        showAlertMessage("<fmt:message key="${addProductMessage}"/>");
                    </script>
                </c:if>
            </form>
            <div class="table_line"></div>
        </div>
    </div>
    <c:remove var="addProductMessage"/>
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
                    <img src="pictures/contacts_mobile/velcom.jpg" alt="телефон" width="40" height="40">
                    <a class="contacts_info_a_position">+375-29-313-60-52 </a>

                    <br>

                    <img src="pictures/contacts_mobile/mts.png" alt="телефон" width="40" height="40">
                    <a>8029-313-60-52 </a>
                    <br>
                    <img src="pictures/contacts_mobile/viber.jpg" alt="телефон" width="40" height="40">
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