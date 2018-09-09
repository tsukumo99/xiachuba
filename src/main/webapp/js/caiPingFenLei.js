$(function () {
    // 获取session的值
    $.ajax({
        url: "/GetSessionServlet",
        data: {"userBean": "sessionkey"},
        dataType: "json",
        success: function (ret) {
            if (ret == null) {
            } else {
                // 将注册和登录隐藏
                var user = ret;
                loginAngRigister();
                showIndexMessage(user);
            }
        }

    });
    // 点击登录，显示登录弹窗
    $(".user-action a:eq(0)").click(function () {

        layer.open({
            title:false,
            type: 2,
            closeBtn: 1, //不显示关闭按钮
            shade: [0],
            area: ['340px', '590px'],
            offset: 'auto',
            anim: 2,
            content: ['login.html', 'no']
        });

    });
// 点击注册，显示注册弹窗
    $(".user-action a:eq(1)").click(function () {
        layer.open({
            title:false,
            type: 2,
            closeBtn: 1, //不显示关闭按钮
            shade: [0],
            area: ['340px', '550px'],
            offset: 'auto',
            anim: 2,
            content: ['rigister.html', 'no'], //iframe的url，no代表不显示滚动条
        });
    });

});

function loginAngRigister() {
    $(".a-login").css("display","none");
    // 显示用户头像和收藏
    $(".user-nav").attr("style","display:block");
    $(".user-collect").attr("style","display:block");
}
function showIndexMessage(user){
    // 先将之前的隐藏
    $(".user").attr("style","display:block");
    // 获取用户的头像url
    var imageurl = user.u_image;
    // 更换导航栏的用户头像
    // $(".user-nav img").attr("src",imageurl);
}


