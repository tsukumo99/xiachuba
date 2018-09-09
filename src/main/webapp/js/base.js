$(function () {
    $("#img1").hover(function () {
            $(".user-nav-submenu").show();

        },function () {
            $(".user-nav-submenu").hide();
        }
    )
    $(".user-nav-submenu").hover(function () {
            $(this).show();
        },function () {
            $(this).hide();
        }
    )



})