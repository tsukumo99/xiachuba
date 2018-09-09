$(function () {
    $.ajax({
        url:"/GetUserInfoServlet",
        type:"post",
        async:false,
        dataType:"json",
        success:function (result) {
            $("#img1").attr("src", result[0].u_image);
            $(".user img").attr("src", result[0].u_image);
            $(".pic").attr("src",result[0].u_image);

        }
    })
})