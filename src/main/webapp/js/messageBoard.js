$(function () {

    //显示留言板
    $(".m-menu  li:eq(4) a").click(function () {
        $(".people-home-main").remove();
        $(".messageBoard").show();
    });

    // 显示留言信息
    $.ajax({
        url:"/showContent",
        data: {"otherName": $(".pr30 span:eq(0)").text()},
        dataType: "json",
        type:"post",
        success:function (result) {
            for(var i=0;i<result.length;i++){
                var timew=result[i].time;
                var wTime=Time(timew);
                var $node=$('<div class="remove"><div class="content_Msg_left"><a href="mykitchen.html"><img src="'+result[i].avatar+'"/></a></div><div class="content_Msg_right_top"><a class="u_name">'+result[i].username+'</a><span class="Msg_time">'+wTime+'<span class="spear">|</span><a class="drop" title="'+result[i].msgId+'">删除</a></span><div class="content_Msg_right_bottom">'+result[i].msg+'</div></div></div>');
                $(".content_Msg").append($node);
            }
        }
    });

    //向数据库插入留言记录
    $("input[value='发言']").click(function () {
       if ($("textarea[name='l_content']").val()=="") {
             layer.msg("留言内容不可为空",{time:1000});
          }else {
               $.ajax({
                    url:"/insertLiuyan",
                    data:{"l_content":$("textarea[name='l_content']").val(),"otherName":$(".pr30 span:eq(0)").text()},
                    type:"post",
                    dataType:"json",
                    success:function (result) {
                        for(var i=0;i<result.length;i++){
                            var timew=result[i].time;
                            var wTime=Time(timew);
                            var $node=$('<div class="remove"><div class="content_Msg_left"><a href="mykitchen.html"><img src="'+result[i].avatar+'"/></a></div><div class="content_Msg_right_top"><a class="u_name">'+result[i].username+'</a><span class="Msg_time">'+wTime+'<span class="spear">|</span><a class="drop" title="'+result[i].msgId+'">删除</a></span><div class="content_Msg_right_bottom">'+result[i].msg+'</div></div></div>');
                            $(".content_Msg").prepend($node);
                        }
                    }
                });
           $("textarea[name='l_content']").val("");
       }
});
    //删除数据库记录
    $(".content_Msg").on("click",".remove",function () {
        var $node = $(this);
        $.ajax({
            url:"/deleteMsg",
            //data:{"msgId":$(this).attr("title")},
            data:{"msgId":$(this).find(".drop").attr("title")},
            dataType:"json",
            type:"post",
            async:false,
            success:function (flag) {
                if(flag){
                    $node.remove();
                    layer.msg("删除留言成功",{time:2000});
                }else {
                    layer.msg("您不能删除别人的留言哦",{time:2000})
                }
            }
        })

    })
});

function Time(timew) {
    var wTime;
    var year = Math.ceil(timew/518400);
    if(year < 100){
        wTime = year + "年前";
    }
    var month = Math.ceil(timew/43200);
    if(month < 12){
        wTime = month + "月前";
    }
    var day = Math.ceil(timew/(1440));
    if(day < 30){
        wTime = day +"天前";
    }
    var hour = Math.ceil(timew/60);
    if(hour < 24){
        wTime = hour+"小时前";
    }
    if(timew < 60){
        wTime = timew+"分钟前";
    }
    if(timew < 1){
        wTime = "刚刚";
    }
    return  wTime;
}