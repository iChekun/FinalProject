$(document).ready(function () {
    $("#loginLink").click(function (event) {
        event.preventDefault();
        $(".overlay").fadeToggle("fast");

    });


    $(".overlayLink").click(function (event) {
        event.preventDefault();
        // var action = $(this).attr('data-brandId');
        // var action2 = $(this).attr('data-brandName');
        // var action3 = $(this).attr('data-brandDescription');
        // var action4 = $(this).attr('data-brandImagePath');
        //
        // alert(action);
        // alert(action2);
        // alert(action3);
        // alert(action4);

        // $("#brandIdHiddenInput").val($(this).attr("data-brandId"));

        // $("#brandNameHiddenInput").val($(this).attr("data-brandName"));
        // $("#brandDescriptionHiddenInput").val($(this).attr("data-brandDescription"));
        // $("#brandImagePathHiddenInput").val($(this).attr("data-brandImagePath"));


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

