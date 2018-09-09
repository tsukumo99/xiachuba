
// var  flag=0;//没被收藏
$(function (){
    // if(flag==1){
    //     $(".collect-button").text("已收藏");
    //      $(".collect-button").css("background","grey");
    // }

    $(".collect-button").click(function () {
        var a=$(this);
        //未被收藏时，可以收藏
        if ($(this).text()=="收藏"){
        $.ajax({
            url:"/AddCollectionServlet",
            data:{"c_id":$(this).prop("title")},
            dataType:"json",
            type:"post",
            success:function (result) {
                if(result==1)
                {
                    flag=1;//被收藏
                    a.text("已收藏");
                    a.css("background","grey");
                }
            }
            }   );
        }
        //被收藏时，可以取消收藏
        else{
            $.ajax({
                url:"/DeleteCollectionServlet",
                data:{"id":$(this).prop("title")},
                dataType:"json",
                type:"post",
                success:function (result) {
                    if(result==1)
                    {
                        flag=1;//被收藏
                        a.text("收藏");
                        a.css("background","#dd3915");
                    }
                }
            }   );

        }

    })




})