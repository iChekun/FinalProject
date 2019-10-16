$(document).ready(function () {


    $("#loginLink").click(function (event) {
        event.preventDefault();
        $(".overlay").fadeToggle("fast");

    });


    $(".overlayLink").on("click", function () {

        event.preventDefault();
        var action = $(this).attr('data-brandId');
        // alert(action);

        // тут передали id пользователя из data-userId в hidden поле модалки
        $("#brandIdHiddenInput").val($(this).attr("data-brandId"));


        // показыzаем модалку
        $(".overlay").fadeToggle("fast");
    });


    $(".close").click(function () {
        $(".overlay").fadeToggle("fast");
    });

    $(document).keyup(function (e) {
        if (e.keyCode == 27 && $(".overlay").css("display") != "none") {
            event.preventDefault();
            $(".overlay").fadeToggle("fast");
        }
    });
});


$(document).ready(function () {

    $(".brandLink").on("click", function () {
        $("#brandIdHiddenInput").val($(this).attr("data-brandId"));
        $("#formId").submit();
    });
});

