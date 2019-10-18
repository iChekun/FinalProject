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
    <div class="overlay" style="display: none;z-index: 2;">
        <div class="login-wrapper">
            <div class="login-content" id="loginTarget">
                <a class="close">x</a>
                <h3><fmt:message key="label.action.product_table.add_new_product"/></h3>

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
</body>
</html>
