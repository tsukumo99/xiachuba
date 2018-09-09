// ===============================================================================================================================
$(function () {
    $("input[name='c_name']").keyup(function () {
        $.ajax({
            url:"/SearchC_name",
            data:{"keyword":$("input[name='c_name']").val()},
            dataType:"json",
            type:"post",
            success:function (result) {

                // console.log(result); //控制台输出json对象，用于调试
                $("#search_show").html("");
                    for( var i=0;i<result.length;i++){
                        var $node=$('<p>'+result[i].c_name+'</p>');
                        $("#search_show").append($node);
                        // $("#search_show  p").html($("#search_show  p").html()+result[i].c_name);
                        // $("#search_show ul").html($("#search_show ul").html()+result[i].c_name+"<br>");
                       }
                       $("#search_show").show();
                       if($("#search_show p").text()!="" ){
                           $("#search_show p").mouseover(function () {
                               // alert($(this).text());
                               $("input[name='c_name']").val( $(this).text());
                             });
                           $("#search_show p").click(function () {
                               $("#search_show").hide();
                            });
                        }
             }

        })

    });
    $("input[name='c_name']").blur(function () {
        $("#search_show").hide();
    })
})
