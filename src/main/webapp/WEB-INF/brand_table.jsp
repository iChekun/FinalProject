<%@ page contentType="text/html;charset=windows-1251;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale"
       value="${not empty param.locale ? param.locale : not empty locale ? locale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text"/>
<c:import url="WEB-INF/forms/add_new_brand.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>
        <fmt:message key="label.text.brand_table"/>
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
        <h1><fmt:message key="shopname"/></h1>
    </div>

    <div class="container">

        <div class="new-select-style-locale">
            <form style="display: inline; margin-left: 20px">
                <div class="new-select-style-locale" style="margin-left: 340px; margin-top: -25px; ">
                    <input type="hidden" name="action" value="viewBrandsTable"/>
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
                            <fmt:message key="label.action.add_new_brand"/>
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
                    <fmt:message key="label.text.brand_table"/>
                </caption>
            </div>

            <form action="mainWindow" method="get">
                <div class="start_table">
                    <table class="table_outer">
                        <tr>
                            <td>
                                <div style="height:472px; overflow:auto; width: 100%;">
                                    <table class="table_inner">
                                        <tr style="z-index: 2;">
                                            <th width="7%"><fmt:message key="table.chooseForAction"/></th>
                                            <th><fmt:message key="categoriesTable.name"/></th>
                                            <th><fmt:message key="categoriesTable.description"/></th>
                                            <th><fmt:message key="categoriesTable.image"/></th>
                                        </tr>
                                        <c:forEach items="${brands}" var="brand">
                                            <tr>
                                                <td width="10px">

                                                    <input type="hidden" name="action"
                                                           value="viewEditBrand">

                                                    <button class="shadow-btn"
                                                            type="submit" name="brandForAction"
                                                            value="${brand.brandId}">
                                                        <span class="table_button">
                                                             <fmt:message key="label.view_more"/>
                                                        </span>
                                                    </button>
                                                </td>
                                                <td>
                                                        ${brand.name}
                                                </td>
                                                <td>${brand.description}</td>
                                                <td>
                                                        ${brand.imagePath}
                                                    <img src="${brand.imagePath}" alt="brand_picture">
                                                </td>

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






