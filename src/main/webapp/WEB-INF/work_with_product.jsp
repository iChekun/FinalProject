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
                    <input type="hidden" name="productForAction" value="${product.productId}"/>
                    <input type="hidden" name="action" value="viewEditProduct">
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
                <li><a href="mainWindow?action=viewProductTable">
                    <fmt:message key="label.view_product_table"/> </a>
                </li>
                </li>
            </ul>
        </nav>
    </div>
</div>
<hr>


<div id="main-wrap">
    <div class="user_table_look" style="padding: 10% 5%">
        <fmt:message key="title.brand_table.work_with_brand"/>
        <form enctype="multipart/form-data" method="post" action="mainWindow">

            <label for="category"> <fmt:message key="label.text.product_category"/></label>
            <select id="category" name="categoryId">
                <option disabled selected value> -- select an option --</option>
                <c:forEach items="${categories}" var="order">
                    <option value="${order.categoryId}"
                            <c:if test="${order.categoryId == currentCategoryId}">selected</c:if>>
                            ${order.name}
                    </option>
                </c:forEach>
                <option value><fmt:message key="label.select.none"/></option>
            </select>

            <br>

            <label for="brand"><fmt:message key="label.text.product_brand"/></label>
            <select id="brand" name="brandId">
                <option disabled selected value> -- select an option --</option>
                <c:forEach items="${brands}" var="brand">
                    <option value="${brand.brandId}"
                            <c:if test="${brand.brandId == currentBrandId}">selected</c:if>>
                            ${brand.name}</option>
                </c:forEach>
                <option value>None</option>
            </select>

            <br>
            <label for="productName"><fmt:message key="label.text.product_name"/></label>
            <input id="productName" type="text" required name="productName" value="${product.name}"/>

            <br>
            <label for="productDescription"><fmt:message key="label.text.product_description"/></label>
            <input id="productDescription" type="text" required name="productDescription"
                   value="${product.description}"/>

            <br>
            <label for="productImagePath"><fmt:message key="label.text.product_image_path"/></label>
            <input id="productImagePath" type="text" name="productImagePath" value="${product.imagePath}"/>
            <br>

            <label for="productCost"><fmt:message key="label.text.product_cost"/></label>
            <input id="productCost" type="number" min="1" step="any" required name="productCost"
                   value="${product.cost}"/>


            <div class="category_buttons">
                <p>
                    <input type="hidden" name="productId" value="${product.productId}">
                    <button type="submit" name="action" value="editProduct">
                        <strong><fmt:message key="label.change"/></strong>
                    </button>
                </p>
                <p style="margin-left: 15%;margin-top: -3.4%;">
                    <button type="submit" name="action" value="deleteProduct">
                        <strong>
                            <fmt:message key="label.delete"/>
                        </strong>
                    </button>

                </p>

            </div>

            <c:if test="${workWithProductMessage !=null}">
                <script>
                    showAlertMessage("<fmt:message key="${workWithProductMessage}"/>");
                </script>
            </c:if>

        </form>
        <c:remove var="workWithProductMessage"/>
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
<%--<c:remove var="categories"/>--%>
<%--<c:remove var="brands"/>--%>
<%--<c:remove var="product"/>--%>
</body>
</html>
