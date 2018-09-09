
$(function () {
    // ====================================================================
    // 刘志辉  start 显示动态条数
    $.ajax({
            url: "/getAllDynamicCountServlet",
            type: "post",
            dataType:"json",
            success:function (result) {
                $(".m-menu li:eq(2) a").text("作品 "+result);
            },
            error:function () {
            }
        });

    //给动态的图片绑定弹出事件
    $(".people-home-main").on("click",".plain .dish-280 .cover img",function(){
        $(".dish-popup").show();
        //文本域清空
        $("textarea").val("");

        //模态框里的封面图片换
        $(".dish-cover img").prop("src",$(this).attr("src"));
        $(".dish-cover img").prop("id",$(this).parent().parent().parent().attr("title"));//把动态id从外面的ul传到动态中的封面图片id属性上
        //换名字
        $(".gray-font a:contains('堂妈小厨')").text($(this).parent().next().next().next().next().children().eq(0).text());
        //换中间的用户头像
        $(".dish-info .pure-u .image-link img").prop("src",$(this).parent().next().next().next().next().children().eq(0).children().eq(0).attr('src'));
        //换上面的用户头像
        $(".mb0 .avatar-right-2 .left .image-link img").prop("src",$(this).parent().next().next().next().next().children().eq(0).children().eq(0).attr('src'));
        // 隐藏窗体的滚动条
        $("body").css({ "overflow": "hidden" });
        //显示已经有的评论
        var d_id=$(this).parents("ul").prop("title");
        $("#pinglunUl li:gt(0)").remove();
        findDynamicPinglun(d_id);

    });
    // //回复,绑
    // $("#pinglunUl").on("click",".plain li div .right-top span a",function () {
    //     alert("a");
    // })

    //点关闭图标，模态框关闭
    $(".dish-popup-close").click(function () {
        $(".dish-popup").hide();
        //显示窗体的滚动条
        $("body").css({ "overflow": "visible" });
    })
    //显示所有动态
    $(".m-menu li:eq(2) a").click(function () {
            $.ajax({
                url: "/findDynamicAndUSerServlet",
                type: "post",
                dataType: "json",
                success: function (result) {
                    $("#menu-show-ul").html("");
                    $(".pure-g1").remove();
                    var arm1 = Math.floor(Math.random() * 10);
                    var arm2 = Math.ceil(Math.random() * 10);
                    $(".float-right").hide();
                    $(".messageBoard").hide();
                    $(".stats").html("你创建的<strong>" + result.length + "</strong>个作品已经被大家浏览了<strong>" + arm1 + "</strong>次，做过了<strong>" + arm2 + "</strong>次");
                    for (var i = 0; i < result.length; i++) {
                        var add = $("<ul title='"+result[i].d_id+"' class='plain pure-g1' style='float: left;margin: 0 53px 30px 0;'><div  class=\"dish-280  white-bg has-border\" data-digged=\"false\" data-id=\"143513691\" role=\"dish\">\n" +
                            "  <div class=\"cover\">\n" +
                            "    <img  class=\"showModel\" src='" + result[i].d_image + "' data-src='' alt=\"我的厨房不能没有烤箱\" width=\"280\" height=\"280\" class=\"unveiled\">\n" +
                            "  </div>\n" +
                            "  <p class=\"name ellipsis red-font\">\n" +
                            "    <a >我的厨房不能没有烤箱</a>&nbsp;\n" +
                            "  </p>\n" +
                            "  <p class=\"desc\">\n" +
                            result[i].d_xinde +
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
                            "        <img src='" + result[i].u_image + "' data-src=\"http://i2.chuimg.com/54ea92ab6f844c968a67660906ed374b_160w_160h.jpg?imageView2/1/w/30/h/30/interlace/1/q/90\" alt=\"Sunrise太阳\" width=\"30\" height=\"30\" class=\"unveiled\">" +
                            // "          Sunrise太阳" +
                            result[i].u_name +
                            "      </a>" +
                            "          <a  class=\"icon icon-cooker\" rel=\"nofollow\"></a>" +
                            "      <span class=\"location gray-font\">（上海,浦东新）</span>" +
                            "    " +
                            "    <a  rel=\"nofollow\" target=\"_blank\">" +
                            "      <img src='' class=\"float-right\" style=\"margin: 7px 10px 0 0;\">" +
                            "    </a>" +
                            "  </div>" +
                            "</div></ul>");
                        $(".mb25").after(add); //--------------------------------------------------------------------
                    }
                    $(".buttons").css("clear", "both");
                },
                error: function () {
                }
            })
    })

    var replyObject;
    var p_id;

    //发表评论，插入评论数据
    $(".mt10").click(function () {

        var textareaVal=$(this).prev().prev().val();
        //回复
        // if (textareaVal.indexOf(replyObject)==0){
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
                data: {"p_content": $(this).prev().prev().val(), "d_id": d_id},
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
    //回复评论,显示@xxx
    $(".gray-link").click(function () {
        $(this).parents("#pinglunUl").next().next().children().eq(0).val("@"+$(this).parent().prev().text()+" ");
        replyObject="@"+$(this).parent().prev().text();
        p_id=$(this).attr("title");
        alert(p_id);
    })

    //发表就显示的
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
                    "              <a title='"+result[0].p_id+"'  class=\"gray-link\" rel=\"nofollow\">回复</a>\n" +
                    "          </span>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"right-bottom\">\n" +
                    "                         "+result[0].p_content+"      \n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </li>");

                    $("#pinglunUl").append(add);

            },
            error:function () {
            }
        });
    }

    //弹出动态显示该动态存在的评论
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
                        "                                <a class=\"normal-font\">" + result[i].u_name + "</a>\n" +
                        "                                <span class=\"normal-font gray-font align-baseline\">\n" +
                        "            " + result[i].u_nowlive + " |\n" +
                        "            &nbsp; " + result[i].p_time+ " |\n" +
                        "              <a title='" + result[i].p_id + "'  class=\"gray-link\" rel=\"nofollow\">回复</a>\n" +
                        "          </span>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"right-bottom\">\n" +
                        "                         " + result[i].p_content + "       😄\n" +
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


    $.ajax({
        url:"/GetSessionServlet",
        data:{"userBean":"sessionkey"},
        dataType:"json",
        success:function (ret) {
            if(ret==null){
            }else{
                var user = ret ;
                if(user.u_id==0){
                    location.href="Backstage.html"
                }else{
                    // 将注册和登录隐藏
                    loginAngRigister();
                    showIndexMessage(user);
                }

            }
        }
    });
// 刘志辉  end
// ====================================================================
})

//获取当前时间的方法
function getNowTime() {
    var d = new Date();
    var vYear = d.getFullYear();
    var vMon = d.getMonth() + 1;
    var vDay = d.getDate();
    var h = d.getHours();
    var m = d.getMinutes();
    var se = d.getSeconds()+1;
    s=vYear+"-"+(vMon<10 ? "0" + vMon : vMon)+"-"+(vDay<10 ? "0"+ vDay : vDay)+" "+(h<10 ? "0"+ h : h)+":"+(m<10 ? "0" + m : m)+":"+(se<10 ? "0" +se : se);
    return s;
}

function loginAngRigister() {
    // 显示用户头像和收藏
    $(".user-nav").attr("style","display:block");
    $(".user-collect").attr("style","display:block");
}
function showIndexMessage(user){
    // 先将之前的隐藏
    $(".user").attr("style","display:block");

    // 获取用户的头像url
    var imageurl = user.u_image;
    // 获取用户的姓名
    var username = user.u_name;

    //$(".user-nav img").attr("src",imageurl);
    $(".pr30 h1").text(username+"的厨房");
    // $(".pic").attr("src",imageurl);

}


// =========================================================================
//点击菜谱显示所有菜谱
$(function () {
    // var kitchenName = $("#kitchenName").text();
    // var userName = kitchenName.substring(0,kitchenName.length-3);
    // $(".attention-name").text(userName);
    //显示菜谱数量
    $.ajax({
        url:"/MykitchenMenuNumServlet",
        dataType:"text",
        type:"post",
        success:function (res) {
            $(".menu-num").text(res);
        }
    })

    $(".menu-click").click(function () {
        $(".people-home-main").show();
        $(".attention").hide();
        $(".follow").hide();

        $(".mbmmm").remove();
        $(".plain-1").html("");
        $(".pure-g1").remove();

        var kitchenName = $("#kitchenName").text();
        var userName = kitchenName.substring(0,kitchenName.length-3);
        $.ajax({
            url:"/MychitchenMenuShowServlet",
            data:{"kitchenUsername":userName},
            dataType:"json",
            type:"post",
            success:function (result) {
                if(result.length == 0){
                    $("#no-menu").show();
                }else{
                    $("#yes-menu-create").show();
                    $("#yes-menu-list").show();
                    for(var i = 0;i < result.length;i++){
                        var $node = $("<li>\n" +
                            "<div class=\"recipe-280\">\n" +
                            "<div class=\"cover\"><a href='getCaipuMessageServlet?c_name="+result[i]['c_name']+"' class=\"image-link\"><img src='"+result[i]["c_image"]+"' alt=\"\" width=\"280px\" height=\"216px;\" class=\"unveiled\"></a></div>\n" +
                            "<p class=\"r-red-font\"><a href='getCaipuMessageServlet?c_name="+result[i]['c_name']+"'>"+result[i]["c_name"]+"</a></p>\n" +
                            "<div class=\"s-ellipsis\"><span>"+result[i]["didNum"]+"</span>做过 <span>"+result[i]["collectedNum"]+"</span>收藏 <a href=\"\" class=\"gray-link\">手机用户1928_t276</a></div>\n" +
                            "</div>\n" +
                            " </li>");
                        $("#menu-show-ul").append($node);
                    }
                }
            }
        })
    })

})