<%@ page contentType="text/html;charset=windows-1251;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="locale"
       value="${not empty param.locale ? param.locale : not empty locale ? locale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="text"/>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="title.register"/></title>

    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/left_side_bar.css" type="text/css"/>
    <link rel="stylesheet" href="css/header.css" type="text/css"/>
    <link rel="stylesheet" href="css/search_line.css" type="text/css"/>
    <link rel="stylesheet" href="css/footer.css" type="text/css"/>
    <link rel="stylesheet" href="css/buttons_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/locale_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/logo_style.css" type="text/css"/>
    <link rel="stylesheet" href="css/user_table_look.css" type="text/css"/>
    <link rel="stylesheet" href="css/tables.css" type="text/css"/>

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
                    <input type="hidden" name="action" value="signUpWindow">
                    <label for="locale"></label>
                    <select id="locale" name="locale" onchange="submit()">
                        <option value="en_EN" ${locale == 'en_EN' ? 'selected' : ''}>English</option>
                        <option value="ru_RU" ${locale == 'ru_RU' ? 'selected' : ''}>Русский</option>
                    </select>
                </div>
            </form>
        </div>

        <nav>
            <ul class="header"  style="margin-right: -23%; margin-top: 3%">
                <li>
                    <a href="mainWindow?action=main" >
                        <fmt:message key="button.go_home"/>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<hr>


<div id="main-wrap">

    <div class="user_table_look">

        <div class="table_line">
           <strong style="margin-left: 6%; font-size: 23px;">
               <fmt:message key="title.register"/>
           </strong>
        </div>


        <form action="mainWindow" method="post">

            <table>
                <tr>
                    <td rowspan="2" colspan="2">
                        <label style="font-size: 20px; color: black; text-align: center; margin-left: 10%;">
                            <strong> <fmt:message key="table.message.personalInfo"/></strong>

                        </label>
                    </td>

                    <td class="form-group">
                        <label for="login"><sup>*</sup>
                            <fmt:message key="table.message.user.login"/>

                        </label>
                        <input id="login" pattern="^[a-zA-Z][a-zA-Z0-9-_.]{4,13}$"
                               required type="text" placeholder="login" name="login">
                    </td>

                    <td rowspan="1" class="form-group">
                        <label for="password"><sup>*</sup>
                            <fmt:message key="table.message.user.password"/>

                        </label>
                        <input id="password" pattern="^[a-zA-Z][a-zA-Z0-9-_.]{6,15}$"
                               required type="password" name="password">
                    </td>

                    <td rowspan="1" class="form-group">
                        <label for="password_confirm"><sup>*</sup>
                            <fmt:message key="table.message.user.confirmedPassword"/>

                        </label>
                        <input id="password_confirm" pattern="^[a-zA-Z][a-zA-Z0-9-_.]{6,15}$"
                               required type="password" name="confirmedPassword">
                    </td>
                </tr>

                <tr>
                    <td rowspan="1" class="form-group ">
                        <label for="name"><sup>*</sup>
                            <fmt:message key="table.message.user.name"/>

                        </label>
                        <input id="name" pattern=".{2,30}"
                               required type="text" placeholder="name" name="name">
                    </td>

                    <td rowspan="1" class="form-group ">
                        <label for="surname"><sup>*</sup>
                            <fmt:message key="table.message.user.surname"/>

                        </label>
                        <input id="surname" pattern=".{2,30}"
                               required type="text" placeholder="surname" name="surname">
                    </td>

                    <td rowspan="1" class="form-group ">
                        <label for="birtDate"><sup>*</sup>
                            <fmt:message key="table.message.user.birthDate"/>

                        </label>
                        <input id="birtDate" required type="date" name="birthDate">
                    </td>
                </tr>


                <tr>
                    <td rowspan="2" colspan="2">
                        <label style="font-size: 20px; color: black; text-align: center; margin-left: 10%;">
                            <strong><fmt:message key="table.message.user.contactsInfo"/></strong>
                        </label>
                    </td>

                    <td rowspan="2" colspan="2" class="form-group">
                        <label for="email"><sup>*</sup>
                            <fmt:message key="table.message.user.email"/>

                        </label>
                        <input id="email" style="width: 45%"
                               pattern="[a-z][[a-z][0-9][-][_]]{3,15}[@][a-z]{2,10}[.][a-z]{2,4}"
                               required type="email" placeholder="email" name="email">
                    </td>

                    <td rowspan="2" class="form-group">
                        <label for="phone_number"><sup>*</sup>
                            <fmt:message key="table.message.user.phoneNumber"/>

                        </label>
                        <input id="phone_number" pattern="^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$"
                               required type="tel" placeholder="phone number" name="phoneNumber">
                    </td>

                </tr>
                <tr></tr>
                <tr>
                    <td rowspan="2" colspan="2">
                        <label style="font-size: 20px; color: black; text-align: center; margin-left: 10%;">
                            <strong> <fmt:message key="table.enterAddressLabel"/> </strong>

                        </label>
                    </td>

                    <td rowspan="2">
                        <label for="country"><sup>*</sup>
                            <fmt:message key="table.message.user.country"/>

                        </label>
                        <input id="country" pattern=".{2,30}"
                               required type="text" placeholder="country" name="country">
                    </td>

                    <td rowspan="2">
                        <label for="city"><sup>*</sup>
                            <fmt:message key="table.message.user.city"/>

                        </label>
                        <input id="city" pattern=".{2,30}"
                               required type="text" placeholder="city" name="city">

                        <br>

                        <label for="street"><sup>*</sup>
                            <fmt:message key="table.message.user.street"/>

                        </label>
                        <input id="street" pattern=".{2,30}"
                               required type="text" placeholder="street" name="street">
                    </td>


                    <td rowspan="2">
                        <label for="houseNumber"><sup>*</sup>
                            <fmt:message key="table.message.user.houseNumber"/>

                        </label>
                        <input id="houseNumber" pattern="[1-9]{1,4}"
                               required type="number" placeholder="house number" name="houseNumber">
                        <br>
                        <label for="apartmentNumber"><sup>*</sup>
                            <fmt:message key="table.message.user.apartmentNumber"/>

                        </label>
                        <input id="apartmentNumber" pattern="[1-9]{1,4}"
                               required type="number" placeholder="apartment number" name="apartmentNumber">
                    </td>
                </tr>
            </table>

            <div class="table_line"></div>

            <div class="submit-button input-bottom">


                <c:if test="${signUpMessage !=null}">-->
                    <script>
                        showAlertMessage("<fmt:message key="${signUpMessage}"/>");
                    </script>
                </c:if>

                <p>
                    <button type="submit" name="action" value="signUp">
                        <strong>
                            <fmt:message key="table.message.save"/>
                        </strong>
                    </button>
                </p>

            </div>
        </form>


    </div>

    <c:remove var="signUpMessage"/>

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
</body>
</html>

