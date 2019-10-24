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
    <title><fmt:message key="title.users_table"/></title>

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
                <div class="new-select-style-locale" style="margin-right: -22%;margin-top: -1.8%;">
                    <input type="hidden" name="action" value="viewUsersTable"/>
                    <label for="locale"></label>
                    <select id="locale" name="locale" onchange="submit()">
                        <option value="en_EN" ${locale == 'en_EN' ? 'selected' : ''}>English</option>
                        <option value="ru_RU" ${locale == 'ru_RU' ? 'selected' : ''}>Русский</option>
                    </select>
                </div>
            </form>
        </div>

        <nav>
            <ul class="header" style="margin-right: -23%; margin-top: -0.4%">
                <li>
                    <a href="mainWindow?action=logout">
                        <fmt:message key="button.logout"/>
                    </a>
                </li>


                <li>
                    <a href="mainWindow?action=viewUserCabinet">
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
                        <form action="mainWindow" method="get">


                            <button type="submit" name="action" value="viewUsersTableSorted"
                                    style="float:left;height: 25px; width: 150px;">
                                <fmt:message key="button.view_users_table_sorter"/>
                            </button>


                            <br>
                            <label style="margin-top: 5%; float: left;">
                                <label style="float: left;font-size: 17px;">
                                    <fmt:message key="label.sort_filed"/>
                                </label>
                                <select name="sortBy" style=" float:left;color: black; width: 140px;">">
                                    <option value="bySurname" <c:if test="${sortBy == 'bySurname'}">selected</c:if>>
                                        <fmt:message key="userstable.sortTypeBySurname"/>
                                    </option>
                                    <option value="byBirthDate"
                                            <c:if test="${sortBy == 'byBirthDate'}">selected</c:if>>
                                        <fmt:message key="userstable.sortTypeByBirthDate"/>
                                    </option>
                                    <option value="ByName" <c:if test="${sortBy == 'ByName'}">selected</c:if>>
                                        <fmt:message key="userstable.sortTypeByName"/>
                                    </option>
                                </select>

                            </label>
                            <br>

                            <label style="float: left;margin-top: 5%;">
                                <label style="float: left;font-size: 17px;">
                                    <fmt:message key="label.sort_type"/>
                                </label><br>
                                <select name="sortType" style="width: 140px;">
                                    <option value="ASC"
                                            <c:if test="${sortType == 'ASC'}">selected</c:if>>
                                        ASC
                                    </option>
                                    <option value="DESC"
                                            <c:if test="${sortType == 'DESC'}">selected</c:if>>
                                        DESC
                                    </option>
                                </select>
                            </label>


                        </form>
                    </li>

                </ul>
            </aside>
        </div>
    </div>
    <div id="content-wrap">

        <div class="user_table_look">
            <div class="table_line">
                <caption>
                    <fmt:message key="userstable.caption"/>
                </caption>
            </div>

            <form action="mainWindow" method="post">
                <div class="start_table">
                    <table class="table_outer">
                        <tr>
                            <td>
                                <div style="height:472px; overflow:auto; width: 100%;">
                                    <table class="table_inner">
                                        <tr>
                                            <th>
                                                <fmt:message key="table.chooseForAction"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.userStatus"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.banned"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.login"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.name"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.surname"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.birthDate"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.email"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.phoneNumber"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.country"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.city"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.street"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.houseNumber"/>
                                            </th>
                                            <th>
                                                <fmt:message key="table.message.user.apartmentNumber"/>
                                            </th>
                                        </tr>
                                        <c:forEach items="${users}" var="user">
                                            <tr>
                                                <td width="10px">
                                                    <label style="width: 50px; float: left;">

                                                        <input style=" float: left;"
                                                               class="radio" type="radio"
                                                               name="userForAction" value="${user.userId}">
                                                    </label>
                                                </td>
                                                <td>
                                                    <c:if test="${user.userStatus.userStatusId == 1}">
                                                        admin
                                                    </c:if>
                                                    <c:if test="${user.userStatus.userStatusId == 2}">
                                                        customer
                                                    </c:if>
                                                </td>
                                                <td>${user.banned}</td>
                                                <td>${user.login}</td>
                                                <td>${user.name}</td>
                                                <td>${user.surname}</td>
                                                <td>${user.birthDate}</td>
                                                <td>${user.contacts.email}</td>
                                                <td>${user.contacts.phoneNumber}</td>
                                                <td>${user.contacts.address.country}</td>
                                                <td>${user.contacts.address.city}</td>
                                                <td>${user.contacts.address.street}</td>
                                                <td>${user.contacts.address.houseNumber}</td>
                                                <td>${user.contacts.address.apartmentNumber}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="table_line"></div>

                <div class="category_buttons">


                    <button type="submit" name="action" value="updateBanStatus">
                        <strong>
                            <fmt:message key="button.change_user__ban_status"/>
                        </strong>
                    </button>

                    <button type="submit" name="action" value="changeUserStatus">
                        <strong>
                            <fmt:message key="button.change_user_status"/>
                        </strong>
                    </button>
                </div>

            </form>
        </div>
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

