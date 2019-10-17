<%@ page contentType="text/html;charset=windows-1251;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale"
       value="${not empty param.locale ? param.locale : not empty locale ? locale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text"/>
<c:import url="WEB-INF/forms/change_password.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>
        <fmt:message key="title.personaCabinet"/>
    </title>

    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/personal_cabinet_left_bar_menu.css" type="text/css"/>
    <link rel="stylesheet" href="css/header.css" type="text/css"/>
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
                    <input type="hidden" name="action" value="viewUserCabinet">
                    <input type="hidden" name="userId" value="${userId}">

                    <input type="hidden" name="userStatusId" value="${userStatusId}">
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
                    <a href="mainWindow?action=main">
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
            <aside>
                <ul>
                    <li>
                        <fieldset>
                            <fmt:message key="table.message.title.menu"/>
                        </fieldset>
                    </li>

                    <c:if test="${sessionScope.userStatusId == 1}">

                        <li class="Schedule">
                            <a href="" style="margin-left: 7%;" onclick="return false">
                                <fmt:message key="label.action.personal_cabinet.work_with_store"/>
                            </a>
                            <ul>
                                <li><a href="mainWindow?action=viewCategoriesTable">
                                    <fmt:message key="label.view_category_table"/></a>
                                </li>
                                <li><a href="mainWindow?action=viewBrandsTable">
                                    <fmt:message key="label.view_brand_table"/></a>
                                </li>
                                <li><a href="mainWindow?action=viewPaymentsMethodTable">
                                    <fmt:message key="label.view_payment_method_table"/></a>
                                </li>
                                <li><a href="mainWindow?action=viewProductTable">
                                    <fmt:message key="label.view_product_table"/></a>
                                </li>
                            </ul>
                        <li>
                            <a href="mainWindow?action=viewUsersTable">
                                <input type="hidden" name="userId" value="${userId}">
                                <input type="hidden" name="userStatusId" value="${userStatusId}">
                                <fmt:message key="personalCabinet.ref.workWithUsers"/>
                            </a>
                        </li>
                    </c:if>

                    <li>
                        <a href="mainWindow?action=viewUserBasket">
                            <fmt:message key="label.view_user_basket"/>
                        </a>
                    </li>

                    <li>
                        <a href="mainWindow?action=viewOrdersHistory">
                            <fmt:message key="label.view_buy_history"/>
                        </a>
                    </li>

                    <li>
                        <a href="" class="overlayLink">
                            <fmt:message key="label.change_password"/>
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
                    <div style="font-size: 20px; font-weight: bold; text-decoration: underline;">
                        <fmt:message key="personalCabinet.message.hello"/>
                        ${user.name}!
                    </div>
                </caption>
            </div>


            <form action="mainWindow" method="post">

                <table>
                    <tr>
                        <td rowspan="2" colspan="2">
                            <label style="text-decoration:underline;font-size: 20px; color: black; text-align: center; margin-left: 10%;">
                                <strong> <fmt:message key="table.message.personalInfo"/> </strong>
                            </label>
                        </td>

                        <td class="form-group">
                            <label for="login"><sup>*</sup>
                                <fmt:message key="table.message.user.login"/>
                            </label>
                            <input id="login" pattern="^[a-zA-Z][a-zA-Z0-9-_.]{4,13}$"
                                   required type="text" placeholder="login" name="login"
                                   value=${user.login}>
                        </td>

                    </tr>

                    <tr>
                        <td rowspan="1" class="form-group ">
                            <label for="name"><sup>*</sup>
                                <fmt:message key="table.message.user.name"/>

                            </label>
                            <input id="name" pattern=".{2,30}"
                                   required type="text" placeholder="name" name="name"
                                   value=${user.name}>
                        </td>

                        <td rowspan="1" class="form-group ">
                            <label for="surname"><sup>*</sup>
                                <fmt:message key="table.message.user.surname"/>
                            </label>
                            <input id="surname" pattern=".{2,30}"
                                   required type="text" placeholder="surname" name="surname"
                                   value=${user.surname}>
                        </td>

                        <td rowspan="1" class="form-group ">
                            <label for="birthDate"><sup>*</sup>
                                <fmt:message key="table.message.user.birthDate"/>
                            </label>
                            <input id="birthDate" required type="date" name="birthDate"
                                   value="${birthDate}">
                        </td>
                    </tr>


                    <tr>
                        <td rowspan="2" colspan="2">
                            <label style="text-decoration:underline;font-size: 20px; color: black; text-align: center; margin-left: 10%;">
                                <strong><fmt:message key="table.message.user.contactsInfo"/> </strong>
                            </label>
                        </td>

                        <td rowspan="2" colspan="1" class="form-group">
                            <label for="email"><sup>*</sup>
                                <fmt:message key="table.message.user.email"/>

                            </label>
                            <input id="email" style="width: 90%"
                                   pattern="[a-z][[a-z][0-9][-][_]]{3,15}[@][a-z]{2,10}[.][a-z]{2,4}"
                                   required
                                   type="email" placeholder="email" name="email"
                                   value="${user.contacts.email}">
                        </td>

                        <td rowspan="2" class="form-group">
                            <label for="phone_number"><sup>*</sup>
                                <fmt:message key="table.message.user.phoneNumber"/>

                            </label>
                            <input id="phone_number" pattern="^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$"
                                   required type="tel" placeholder="phone number" name="phoneNumber"
                                   value="${user.contacts.phoneNumber}">
                        </td>

                    </tr>
                    <tr></tr>
                    <tr>
                        <td rowspan="2" colspan="2">
                            <label style="text-decoration:underline;font-size: 20px; color: black; text-align: center; margin-left: 10%;">
                                <strong> <fmt:message key="table.enterAddressLabel"/> </strong>

                            </label>
                        </td>

                        <td rowspan="2">
                            <label for="country"><sup>*</sup>
                                <fmt:message key="table.message.user.country"/>

                            </label>
                            <input id="country" pattern=".{2,30}"
                                   required type="text" placeholder="country" name="country"
                                   value=${user.contacts.address.country}>
                        </td>

                        <td rowspan="2">
                            <label for="city"><sup>*</sup>
                                <fmt:message key="table.message.user.city"/>

                            </label>
                            <input id="city" pattern=".{2,30}"
                                   required type="text" placeholder="city" name="city"
                                   value=${user.contacts.address.city}>

                            <br>

                            <label for="street"><sup>*</sup>
                                <fmt:message key="table.message.user.street"/>

                            </label>
                            <input id="street" pattern=".{2,30}"
                                   required type="text" placeholder="street" name="street"
                                   value=${user.contacts.address.street}>
                        </td>


                        <td rowspan="2">
                            <label for="houseNumber"><sup>*</sup>
                                <fmt:message key="table.message.user.houseNumber"/>

                            </label>
                            <input id="houseNumber" pattern="[1-9]{1,4}"
                                   required type="number" placeholder="house number" name="houseNumber"
                                   value=${user.contacts.address.houseNumber}>
                            <br>
                            <label for="apartmentNumber"><sup>*</sup>
                                <fmt:message key="table.message.user.apartmentNumber"/>

                            </label>
                            <input id="apartmentNumber" pattern="[1-9]{1,4}"
                                   required type="number" placeholder="apartment number" name="apartmentNumber"
                                   value=${user.contacts.address.apartmentNumber}>
                        </td>
                    </tr>
                </table>

                <div class="table_line"></div>

                <div class="submit-button input-bottom">


                    <c:if test="${editPersonalInfoMessage !=null}">
                        <script>
                            showAlertMessage("${editPersonalInfoMessage}");
                        </script>
                    </c:if>

                    <p>
                        <input type="hidden" name="contactsId" value="${user.contacts.contactsId}">
                        <button type="submit" name="action" value="editUser">
                            <strong>
                                <fmt:message key="button.message.save"/>
                            </strong>
                        </button>
                    </p>

                </div>
            </form>

            <c:remove var="editPersonalInfoMessage"/>
        </div>
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

