$(function () {
    $(".showModel").click(function () {
        $(".dish-popup").show();
        // 隐藏窗体的滚动条
        $("body").css({ "overflow": "hidden" });
    })
    $(".dish-popup-close").click(function () {
        $(".dish-popup").hide();
        //显示窗体的滚动条
        $("body").css({ "overflow": "visible" });
    })


    //动态窗体弹出加载的状态
    $(".showModel").click(function () {
        $.ajax({
            url:"/ShowLikeServlet",
            type:"post",
            data:{"d_id":$(this).parent().parent().parent().attr("id")},
            dataType:"text",
            success:function (result) {
                if(!(result== "[]" )){
                    var value= $("#like a").text("取消赞");
                    $("#like a").css("background-color","#ddd");
                    var cloneNode=$(".digg-user").eq(0).clone(true);
                    $.ajax({
                        url:"/GetUserInfoServlet",
                        type:"post",
                        dataType:"json",
                        success:function (result) {
                            cloneNode.children().children().attr("src",result[0].u_image);
                            $(".digg-user").eq(0).before(cloneNode)
                        }
                    })
                }
            }
        })

    })
    $("#like").click(function () {
        var textZan=$(this).children().eq(0);
        var textZan2=$(this).children().eq(0);
        var value = $(this).children().eq(0).text();
        var flag;

        if(value == "赞"){
            flag = "like";
            $.ajax({
                url:"/like",
                type:"post",
                data:{"d_id":$(this).parent().prev().children().eq(0).prop("id"),"flag":flag},
                dataType:"text",
                success:function (result) {
                    if(result=="1"){
                        textZan.text("取消赞");
                        textZan.css("background-color","#ddd");
                        var cloneNode=$(".digg-user").eq(0).clone(true);
                        $.ajax({
                            url:"/GetUserInfoServlet",
                            type:"post",
                            dataType:"json",
                            success:function (result) {
                                cloneNode.children().children().attr("src",result[0].u_image);
                                $(".digg-user").eq(0).before(cloneNode)
                            }
                        })

                    }
                }
            })
        }

    else{
            flag = "liked";
            $.ajax({
                url:"/like",
                type:"post",
                data:{"d_id":$(this).parent().prev().children().eq(0).prop("id"),"flag":flag},
                dataType:"text",
                success:function (result) {
                    if(result=="1"){
                        textZan2.text("赞");
                        textZan2.css("background-color","#dd3915");
                        var ModNode=$(".digg-user").eq(0).detach();
                    }
                }
            })
        }


        })

        })

