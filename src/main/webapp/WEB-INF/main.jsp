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
    <link rel="stylesheet" href="css/slider_main.css" type="text/css"/>
    <link rel="stylesheet" href="css/running_text_main.css" type="text/css"/>

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


<div id="main-wrap" style="min-height: 660px;margin-top: 50px;">

    <div id="sidebar">
        <aside>
            <ul>
                <li class="Schedule_left_bar_menu_main">
                    <a href=""
                       style="margin-top: 160px;margin-left: 7%; height: 50px; text-align: center; padding: 5px 5px; "
                       onclick="return false">
                        <br> <fmt:message key="label.main.categories"/>
                    </a>
                    <ul>
                        <c:forEach items="${categories}" var="category">
                            <li style="margin:-5px 7px 7px 7px;">
                                <a
                                        href="mainWindow?action=ViewCustomerProductTableWithCategory&categoryId=${category.categoryId}">
                                        ${category.name}
                                </a>
                            </li>
                        </c:forEach>

                    </ul>

                <li>
                    <a href="mainWindow?action=viewCustomerProductTable"
                       style="margin-left: 7%;height: 60px; text-align: center;margin-top: 5px; padding: 5px 5px;">
                        <br> <fmt:message key="label.main.product_table_to_customer"/>
                    </a>
                </li>

            </ul>


        </aside>
    </div>

    <div id="content-wrap">


        <c:if test="${sessionScope.userId != null && sessionScope.userStatusId != null}">
            <div class="basket">
                <a href="mainWindow?action=viewUserBasket">
                    <fmt:message key="label.view_user_basket"/>
                </a>
            </div>
        </c:if>

        <div class="sectors">

            <div class="sector_first_line">
                <fieldset>
                    <div class="slider">
                        <input class="slider__nav" type="radio" name="slider" title="slide1" checked="checked"/>
                        <input class="slider__nav" type="radio" name="slider" title="slide2"/>
                        <input class="slider__nav" type="radio" name="slider" title="slide3"/>
                        <input class="slider__nav" type="radio" name="slider" title="slide4"/>
                        <div class="slider__inner">
                            <div class="slider__contents"><i class="slider__image fa fa-codepen"></i>
                                <h2 class="slider__caption"><fmt:message key="main.base.first.online_store"/></h2>
                                <p class="slider__txt">
                                    <fmt:message key="main.base.text.first_text"/>
                                </p>
                            </div>
                            <div class="slider__contents"><i class="slider__image fa fa-mobile"></i>
                                <h2 class="slider__caption"><fmt:message key="main.base.second.mobile"/></h2>
                                <p class="slider__txt">
                                    <fmt:message key="main.base.text.second_text"/>
                                </p>
                            </div>
                            <div class="slider__contents"><i class="slider__image fa fa-television"></i>
                                <h2 class="slider__caption"><fmt:message key="main.base.third.television"/></h2>
                                <p class="slider__txt">
                                    <fmt:message key="main.base.text.third_text"/>
                                </p>
                            </div>
                            <div class="slider__contents"><i class="slider__image fa fa-cutlery"></i>
                                <h2 class="slider__caption"><fmt:message key="main.base.fourth.animal_food"/></h2>
                                <p class="slider__txt">
                                    <fmt:message key="main.base.text.fourth_text"/>
                                </p>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>


            <div class="sector_second_line_1">
                <a href="mainWindow?action=ViewCustomerProductTableWithCategory&categoryId=2">
                    <img src="pictures/product/main_adversting/adversting_phones.jpg" height="200" width="300"
                         alt="phones"/>
                </a>
            </div>


            <div class="sector_second_line_2">
                <a href="mainWindow?action=ViewCustomerProductTableWithCategory&categoryId=1">
                    <img src="pictures/product/main_adversting/adversing_tv.jpg" height="200" width="300"
                         alt="tv"/>
                </a>
            </div>


            <div class="sector_second_line_3">
                <a href="mainWindow?action=ViewCustomerProductTableWithCategory&categoryId=d7eec6be-f8d1-11e9-8e3e-6045cbb55050">
                    <img src="pictures/product/main_adversting/dog_food_adversting.jpg" height="200" width="200"
                         alt="animal_food"/>
                </a>
            </div>

        </div>
    </div>
    <h1 class="marquee"><span><fmt:message key="message.running.welcome"/></span></h1>

</div>

<c:if test="${message !=null}">
    <script>
        showAlertMessage("<fmt:message key="${message}"/>");
    </script>
</c:if>
<c:remove var="message"/>

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





