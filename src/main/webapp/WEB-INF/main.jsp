<%@ page contentType="text/html;charset=windows-1251;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale"
       value="${not empty param.locale ? param.locale : not empty locale ? locale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text"/>
<c:import url="WEB-INF/forms/sign_in.jsp"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="title.main"/></title>

    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/left_side_bar.css" type="text/css"/>
    <link rel="stylesheet" href="css/header.css" type="text/css"/>
    <link rel="stylesheet" href="css/search_line.css" type="text/css"/>
    <link rel="stylesheet" href="css/footer.css" type="text/css"/>
    <link rel="stylesheet" href="css/buttons_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/locale_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/logo_style.css" type="text/css"/>
    <link rel="stylesheet" href="css/main_left_bar.css" type="text/css"/>

    <link rel="icon" href="pictures/logotip.jpg" type="image/x-icon">
    <link rel="shortcut icon" href="pictures/logotip.jpg" type="image/x-icon">


    <link href='http://fonts.googleapis.com/css?family=Varela+Round|Open+Sans:400,300,600' rel='stylesheet'
          type='text/css'>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/alert.js"></script>

    <link rel="stylesheet" href="css/promtWindow.css" type="text/css"/>
    <script src="js/signIn.js"></script>
</head>
<body>


<div id="header">
    <div class="two">
        <h1><fmt:message key="shopname"/></h1>
    </div>

    <div class="container">

        <div class="new-select-style-locale">
            <form style="display: inline; margin-left: 20px">
                <input type="hidden" name="action" value="main"/>
                <div class="new-select-style-locale" style="margin-left: 340px; margin-top: -25px; ">
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
                <c:if test="${sessionScope.userId != null && sessionScope.userStatusId != null}">
                    <li>
                        <a href="mainWindow?action=logout">
                            <fmt:message key="button.logout"/>
                        </a>
                    </li>
                    <li>
                        <a href="mainWindow?action=viewUserCabinet">
                            <fmt:message key="button.personal_cabinet"/>
                        </a>
                        <input type="hidden" name="userId" value="${sessionScope.userId}">
                        <input type="hidden" name="userStatus" value="${sessionScope.userStatusId}">
                    </li>
                </c:if>
                <c:if test="${sessionScope.userId == null}">
                    <li>
                        <a href="mainWindow?action=signUpWindow">
                            <fmt:message key="button.signUp"/>
                        </a>


                    </li>
                    <li>

                        <a href="" class="overlayLink">
                            <fmt:message key="button.signIn"/>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>

<hr>


<div id="main-wrap">

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
                <li class="Schedule_left_bar_menu_main">
                    <a href="" style="margin-left: 7%;" onclick="return false">
                        categories
                    </a>
                    <ul>
                        <c:forEach items="${categories}" var="category">
                            <li style="margin-left: 2%;">
                                <a
                                        href="mainWindow?action=ViewCustomerProductTableWithCategory&categoryId=${category.categoryId}">
                                        ${category.name}
                                </a>
                            </li>
                        </c:forEach>

                    </ul>


                <li>
                    <a href="mainWindow?action=viewCustomerProductTable" style="margin-left: 7%;">
                        product table<br>to customer
                    </a>
                </li>

            </ul>
        </aside>
    </div>

<div id="content-wrap">

    <form action="" method="post">
        <div class="search">
            <input type="search" placeholder="Поиск по каталогу">
            <input type="submit" value="">
        </div>
    </form>

    <!-- корзина -->
    <c:if test="${sessionScope.userId != null && sessionScope.userStatusId != null}">
        <div class="basket">
            <a href="mainWindow?action=viewUserBasket">
                корзина
            </a>
        </div>
    </c:if>


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
                <%--                <a href=""> Ифно</a>--%>
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





