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
                    <input type="hidden" name="action" value="viewEditBrand">
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
                <li><a href="mainWindow?action=viewBrandsTable">
                <fmt:message key="label.view_brand_table"/></a>
                </li>
                </li>
            </ul>
        </nav>
    </div>
</div>
<hr>


<div id="main-wrap">
    <div class="user_table_look" style="padding: 10% 5%">
        <strong style="margin-left: 10%;margin-bottom: 15%;font-size: 145%;text-decoration: underline;">
            <fmt:message key="title.brand.work_with_brand"/>
        </strong>
        <form enctype="multipart/form-data" method="post" action="mainWindow">

            <label style="font-size: 100%; font-weight: bold;" for="brandNameInput"><fmt:message key="label.text.brand_name"/></label>
            <input id="brandNameInput"
                   required type="text" placeholder="name" name="brandName" value="${brand.name}">

            <br>
            <label style="font-size: 100%; font-weight: bold;" for="brandDescriptionInput"><fmt:message key="label.text.brand_description"/></label>
            <input id="brandDescriptionInput"
                   required type="text" placeholder="description" name="brandDescription" value="${brand.description}">

            <br>
            <label style="font-size: 100%; font-weight: bold;" for="brandImagePathInput"><fmt:message key="label.text.brand_image_path"/></label>
            <input id="brandImagePathInput"
                   type="text" placeholder="description" name="brandImagePath" value="${brand.imagePath}">


            <br>
            <div class="category_buttons">

                <input type="hidden" name="brandId" value="${brand.brandId}">
                <button type="submit" name="action" value="editBrand">
                    <strong><fmt:message key="label.change"/></strong>
                </button>

                <p style="margin-left: 15%;margin-top: -3.4%;">
                    <button type="submit" name="action" value="deleteBrand">
                        <strong>
                            <fmt:message key="label.delete"/>
                        </strong>
                    </button>
                </p>

            </div>
            <c:if test="${errorMessage !=null}">
                <script>
                    showAlertMessage("<fmt:message key="${errorMessage}"/>");
                </script>
            </c:if>
            <c:remove var="errorMessage"/>

        </form>
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




