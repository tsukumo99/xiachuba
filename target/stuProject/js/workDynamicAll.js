$(function () {

// ====================================================================
    //给动态的图片绑定弹出事件
    $(".content-middle").on("click",".plain .dish-280 .cover img",function(){

        $(".dish-popup").show();

        //模态框里的封面图片换
        $(".dish-cover img").prop("src",$(this).attr("src"));
        $(".dish-cover img").prop("id",$(this).parent().parent().parent().attr("title"));//把动态id从外面的ul传到动态中的封面图片id属性上
        //换名字
        $(".gray-font a").text($(this).parent().next().next().next().next().children().eq(0).text());
        //换中间的用户头像
        $(".dish-info .pure-u .image-link img").prop("src",$(this).parent().next().next().next().next().children().eq(0).children().eq(0).attr('src'));
        //换上面的用户头像
        $(".mb0 .avatar-right-2 .left .image-link img").prop("src",$(this).parent().next().next().next().next().children().eq(0).children().eq(0).attr('src'));
        $(".dish-cover img").prop("title",$(this).parent().parent().parent().attr("id"));//把动态id从外面的ul传到动态中的封面图片id属性上
        // 隐藏窗体的滚动条
        $("body").css({ "overflow": "hidden" });
        //显示已经有的评论----------------------------------------
        var d_id=$(this).parents("ul").prop("title");
        $("#pinglunUl li:gt(0)").remove();
        findDynamicPinglun(d_id);
    });
    $(".dish-popup-close").click(function () {
        $(".dish-popup").hide();
        //显示窗体的滚动条
        $("body").css({ "overflow": "visible" });

    })
    var nameArray =new Array();


//显示所有动态
        $(".show-list").remove();
        $.ajax({
            url: "/findDynamicAndUSerServlet",
            type: "post",
            dataType: "json",
            success: function (result) {

                var arm1 = Math.floor(Math.random() * 10);
                var arm2 = Math.ceil(Math.random() * 10);
                for (var i = 0; i < result.length; i++) {
                    var add = $("<ul title='"+ result[i].d_id+"' class='plain pure-g' style='float: left;margin: 0 53px 30px 0;'><div  class=\"dish-280  white-bg has-border\" data-digged=\"false\" data-id=\"143513691\" role=\"dish\">\n" +
                        "  <div class=\"cover\">\n" +
                        "    <img  class=\"showModel\" src='" + result[i].d_image + "' data-src='' alt=\"我的厨房不能没有烤箱\" width=\"280\" height=\"280\" class=\"unveiled\">\n" +
                        "  </div>\n" +
                        "  <p class=\"name ellipsis red-font\">\n" +
                        "    <a >我的厨房不能没有烤箱</a>&nbsp;\n" +
                        "  </p>\n" +
                        "  <p class=\"desc\">\n" +
                        result[i].d_xinde+
                        "  </p>\n" +
                        "  <div class=\"stats pure-g\">\n" +
                        "    <p class=\"pure-u-1-2\">20小时前</p>\n" +
                        "    <p class=\"pure-u-1-2 align-right\">\n" +
                        "      <span class=\"n-diggs\">1068</span>&nbsp;&nbsp;\n" +
                        "      <span class=\"n-comments\">189</span>\n" +
                        "    </p>\n" +
                        "  </div>\n" +
                        "  <div class=\"author clearfix ellipsis\">\n" +
                        "      <a  href='' title=\"Sunrise太阳\" class=\"avatar-link avatar\">\n" +
                        "        <img src='" + result[i].u_image +"'  alt=\"Sunrise太阳\" width=\"30\" height=\"30\" >" +
                        result[i].u_name +
                        "      </a>" +
                        // "          <a  class=\"icon icon-cooker\" rel=\"nofollow\"></a>" +
                        "      <span class=\"location gray-font\">（上海,浦东新）</span>" +
                        "    " +
                        "    <a  rel=\"nofollow\" target=\"_blank\">" +
                        "      <img src='' class=\"float-right\" style=\"margin: 7px 10px 0 0;\">" +
                        "    </a>" +
                        "  </div>" +
                        "</div></ul>");
                    $(".cate").after(add);
                }
                $(".buttons").css("clear", "both");


            },
            error: function () {

            }
        })
    // })
    var replyObject;
    var p_id;
    //发表评论，插入评论数据-----------------------------------------
    $(".mt10").click(function () {
        var textareaVal=$(this).prev().prev().val();
        //回复
        // if (textareaVal.indexOf(replyObject)==0){
        //     alert(p_id);
        //     $.ajax({
        //         url: "/addRepplyServlet",
        //         data: {"r_content": $(this).prev().prev().val(), "p_id": p_id},
        //         type: "post",
        //         dataType: "json",
        //         success: function (result) {
        //             if (result == "1") {
        //                 findCurrentPinglun(d_id, p_time);
        //                 $(this).prev().prev().val("");
        //             }
        //         },
        //         error: function () {
        //         }
        //     });
        // }
        //非回复
        if (textareaVal.indexOf(replyObject)==-1)
        {

            var p_time = getNowTime();
            var d_id = $(this).parent().parent().parent().prev().prev().children().children().prop("id");
            $.ajax({
                url: "/addPinglunServlet",
                data: {"p_content": textareaVal, "d_id": d_id,"p_time":p_time},
                type: "post",
                dataType: "json",
                success: function (result) {
                    if (result == "1") {
                        findCurrentPinglun(d_id, p_time);
                        $(this).prev().prev().val("");
                    }
                },
                error: function () {
                }
            });
        }

    })

    //发表就显示的-----------------------------------------------
    function findCurrentPinglun(d_id,p_time){
        $.ajax({
            url: "/findPinglunServlet",
            data:{"d_id":d_id,"p_time":p_time},
            type: "post",
            dataType:"json",
            success:function (result) {
                var add=$("<li >\n" +
                    "                        <div class=\"avatar-right-2\" role=\"comment\" data-target-url=\"/dish/143461175/comments/\" data-target-id=\"143461175\" data-comment-id=\"139412720\" data-author-name=\"阳阳爱妈妈妈妈爱阳阳\" data-author-id=\"126359651\">\n" +
                    "                            <div class=\"left\">\n" +
                    "                                <a class=\"image-link\">\n" +
                    "                                    <img src='" + result[0].u_image + "' height=\"60\" width=\"60\" class=\"unveiled\">\n" +
                    "                                </a>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"right-top info\">\n" +
                    "                                <a class=\"normal-font\">"+ result[0].u_name +"</a>\n" +
                    "                                <span class=\"normal-font gray-font align-baseline\">\n" +
                    "            "+ result[0].u_nowlive +" |\n" +
                    "            &nbsp; "+p_time+" |\n" +
                    // "              <a title='"+result[0].p_id+"'  class=\"gray-link\" rel=\"nofollow\">回复</a>\n" +
                    "          </span>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"right-bottom\">\n" +
                    "                         "+result[0].p_content+"       \n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </li>");

                $("#pinglunUl").append(add);

            },
            error:function () {
            }
        });
    }

    //弹出动态显示该动态存在的评论-------------------------------------------------
    function findDynamicPinglun(d_id){
        $.ajax({
            url: "/findPinglunByDidServlet",
            data:{"d_id":d_id},
            type: "post",
            dataType:"json",
            success:function (result) {
                for (var i=0;i<result.length;i++) {
                    var add = $("<li >\n" +
                        "                        <div class=\"avatar-right-2\" role=\"comment\" data-target-url=\"/dish/143461175/comments/\" data-target-id=\"143461175\" data-comment-id=\"139412720\" data-author-name=\"阳阳爱妈妈妈妈爱阳阳\" data-author-id=\"126359651\">\n" +
                        "                            <div class=\"left\">\n" +
                        "                                <a class=\"image-link\">\n" +
                        "                                    <img src='" + result[i].u_image + "' height=\"60\" width=\"60\" class=\"unveiled\">\n" +
                        "                                </a>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"right-top info\">\n" +
                        "                                <span class=\"normal-font gray-font align-baseline\">\n" +
                        "                                <a class=\"normal-font\">" + result[i].u_name + "</a>\n" +
                        "            " + result[i].u_nowlive + " |\n" +
                        "            &nbsp; " + result[i].p_time+ " |\n" +
                        "              <a title='" + result[i].p_id + "'  class=\"gray-link\" rel=\"nofollow\"></a>\n" +
                        "          </span>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"right-bottom\">\n" +
                        "                         " + result[i].p_content + "       \n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </li>");

                    $("#pinglunUl").append(add);
                }

            },
            error:function () {
            }
        });

    }


    function findCurrentPinglun(d_id,p_time){
        $.ajax({
            url: "/findPinglunServlet",
            data:{"d_id":d_id,"p_time":p_time},
            type: "post",
            dataType:"json",
            success:function (result) {
                var add=$("<li>\n" +
                    "                        <div class=\"avatar-right-2\" role=\"comment\" data-target-url=\"/dish/143461175/comments/\" data-target-id=\"143461175\" data-comment-id=\"139412720\" data-author-name=\"阳阳爱妈妈妈妈爱阳阳\" data-author-id=\"126359651\">\n" +
                    "                            <div class=\"left\">\n" +
                    "                                <a class=\"image-link\">\n" +
                    "                                    <img src='" + result[0].u_image + "' height=\"60\" width=\"60\" class=\"unveiled\">\n" +
                    "                                </a>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"right-top info\">\n" +
                    "                                <span class=\"normal-font gray-font align-baseline\">\n" +
                    "                                <a class=\"normal-font\">"+ result[0].u_name +"</a>\n" +
                    "            "+ result[0].u_nowlive +" |\n" +
                    "            &nbsp; "+p_time+" |\n" +
                    // "              <a class=\"gray-link\" rel=\"nofollow\">回复</a>\n" +
                    "          </span>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"right-bottom\">\n" +
                    "                         "+result[0].p_content+"       \n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </li>");

                $("#pinglunUl").append(add);

            },
            error:function () {
            }
        });
    }




// 刘志辉  end
// ====================================================================

    // 获取session的值
    $.ajax({
        url: "/GetSessionServlet",
        data: {"userBean": "sessionkey"},
        dataType: "json",
        success: function (ret) {
            if (ret == null) {
            } else {
                loginAngRigister();
                showIndexMessage(ret);
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
    // 王咸林  end
// ====================================================================

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

//获取当前时间的方法
function getNowTime() {
    var d = new Date();
    var vYear = d.getFullYear();
    var vMon = d.getMonth() + 1;
    var vDay = d.getDate();
    var h = d.getHours();
    var m = d.getMinutes();
    var se = d.getSeconds();
    s=vYear+"-"+(vMon<10 ? "0" + vMon : vMon)+"-"+(vDay<10 ? "0"+ vDay : vDay)+" "+(h<10 ? "0"+ h : h)+":"+(m<10 ? "0" + m : m)+":"+(se<10 ? "0" +se : se);
    return s;
}