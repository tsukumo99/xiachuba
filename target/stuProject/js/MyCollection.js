$(function(){
    $.ajax({
        url:"/CountCollectionServlet",
        type:"post",
        success:function (count) {
            var $colnum = $('<div class="gray-font">'+count+'收藏</div>');
            var $colcount = $('<div class="block-title">'+count+'菜谱</div>');
            $("#collectionnum").append($colnum);
            $("#rl-recipes").append($colcount);
        },
    });

    $.ajax({
        url: "/ShowCollectionServlet",
        type: "post",
        dataType: "json",
        success: function (list) {
            for (var i=0;i<list.length;i++){
                var $node = $('<li><div class="recipe pure-g"><div class="cover pure-u"><a class="image-link" href="" target="_blank"> <img src="'+list[i].c_image+'" width="215" height="138" class="unveiled"> </a> </div> <div class="info pure-u" id="'+list[i].c_id+'"> <p class="name"> <a href="" target="_blank">'+list[i].c_name+'</a> <i class="step-icon"></i> </p> <p class="ing ellipsis">'+list[i].c_made+'</p> <p class="ing ellipsis">'+list[i].c_introduce+'</p> <p class="rl-item-action"> <input type="submit" class="gray-link" value="删除"> </p> </div> </div> </li>');
                $("#show").append($node);
                $("#show li input").click(function () {
                    var $id = $(this).closest("div").attr("id");
                    $.ajax({
                        url:"/DeleteCollectionServlet",
                        type:"post",
                        data:{"id":$id},
                        success:function (ret) {
                            if(ret=="1"){
                                location.reload();
                            }
                        }
                    })
                })
            }
        }
    });

})