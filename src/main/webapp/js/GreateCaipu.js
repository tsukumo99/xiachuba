//初始化全局变量
//总材料数
var material = 1;
//总步骤数
var steps = 1;
//图片删除成功与否标识
var deleteFlag;
//页面点击选择文件事件
$(function () {
    $(".menu-cover-click").click(function () {
        $("input[name='menuCover']").trigger("click");
    });
    $(".steps").on("click",".step-img",function () {
        $(this).prev().children().eq(1).trigger("click");
    });

})

//追加一行用料
$(function () {
    //追加一行用料
    $(".add-material").click(function () {
        var node = $("<tr>\n" +
            "<td><input type=\"text\" placeholder=\"食材：如鸡蛋\"></input></td>\n" +
            "<td><input type=\"text\" placeholder=\"用量：如1只\"></td>\n" +
            "<td class=\"delete\" style=\"width: 30px\"><img src=\"images/close-small.png\"></td>\n" +
            "</tr>")
        $("table").append(node);
        material += 1;
    })
    //追加一行
    $(".add-steps").click(function () {
        steps += 1;
        var node = $("<li>\n" +
            "<div class=\"steps-num\">"+steps+"</div>\n" +
            "<div class=\"steps-content\">\n" +
            "<textarea placeholder=\"点击添加菜谱步骤内容\"></textarea>\n" +
            "</div>\n" +
            "<div class=\"steps-img\">\n" +
            "<form action=\"/PicUploadServlet\" enctype=\"multipart/form-data\" name=\"fileUploadSteps\" method=\"post\">\n" +
            "<input type=\"hidden\" name=\"flag\" value='"+steps+"'>\n" +
            "<input type=\"file\" name=\"menu-cover\" class='picUpload'>\n" +
            "</form>" +
            "<div class=\"step-img\">\n" +
            "<!--显示预览图-->\n" +
            "<img src=\"\" class=\"close\">\n" +
            "<!--右上角关闭按钮，清除已选择文件-->\n" +
            "<i class=\"close\"></i>\n" +
            "<div class=\"tipss\">\n" +
            "<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+菜谱封面</span><br>\n" +
            "<span>最佳尺寸：1280 x 1024</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "<div class=\"steps-delete\">\n" +
            "<img src=\"images/close-small.png\">\n" +
            "</div>\n" +
            "</li>");
        $(".steps ul").append(node);

    })
})
//采用事件委托给删除一个步骤或者删除一行用料的x添加事件
$(function () {
    //删除一行用料
    $(".material").on("click",".delete",function () {
        material -= 1;
        $(this).closest("tr").remove();
    })
    //删除一个步骤(这里要先从服务器删除可能有的图片，图片删成功了才能删除该步骤)
    $(".steps").on("click",".steps-delete",function () {
        var value = parseInt($(this).closest("li").find(".steps-num").text());
        //从服务器删除可能有的步骤图
        $.ajax({
            url:"/PicDeleteServlet",
            data:{"flag":value},
            type: "post",
            async:false,
            dataType:"text",
            success:function (result) {
                if(result == "deleteSuccess"){
                    deleteFlag = "deleteSuccess";
                }
            }
        });
        if(deleteFlag == "deleteSuccess"){
            $(this).closest("li").siblings().each(function () {
                var curValue = parseInt($(this).closest("li").find(".steps-num").text());
                if(curValue > value){
                    $(this).closest("li").find(".steps-num").text(curValue - 1);
                }
            });
            steps -= 1;
            $(this).closest("li").remove();
        }
    })
});
/*
* 段鸿川
* 创建菜谱功能
* */
$(function () {
    //页面中间用户头像和名字的显示
    $.ajax({
        url:"/GetSessionServlet2",
        type:"post",
        dataType:"json",
        success:function (result) { //nolog
            //加入登录功能后换回来
            //$(".Uname").text(result.u_name);
            //$(".UAvatar").css("src",result.u_image);
            $(".Uname").text("张三");
            $(".UAvatar").css("src","images/photo/login.JPG");
        }
    })
})

//获取图片地址
function getUrl(file) {
    var url = null;
    if (window.createObjectURL != undefined) {
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) {
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) {
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}

//图片预览和上传
$(function () {
    //封面
    $(".picUploadCover").change(function () {
        //在上传之前先删除以前可能有的
        $.ajax({
            url:"/PicDeleteServlet",
            data:{"flag":"0"},
            type: "post",
            async:false,
            dataType:"text",
            success:function (result) {
                if(result == "deleteSuccess"){
                    deleteFlag = "deleteSuccess";
                }
            }
        });
        //删除成功，才进行重新上传
        if(deleteFlag == "deleteSuccess"){
            var url = getUrl(this.files[0]);
            var $form = $(this).parent();
            var formData = new FormData();
            formData.append("flag","0");
            formData.append("fileCover",$(this)[0].files[0]);
            $.ajax({
                url:"/PicUploadServlet",
                data:formData,
                type:"post",
                cache:false,
                processData:false,
                contentType:false,
                success:function () {
                    if(url){
                        $($form).parents(".menu-cover").css("height","auto");
                        $($form).parents(".menu-cover").find(".tips").hide();
                        $form.next().children().eq(0).css("width","658px").attr("src",url);
                    }
                },
                error:function (result) {

                }
            })
        }

    })
    //步骤
    $(".steps").on("change",".picUpload",function (e) {
        var stepNum = $(this).closest("li").find(".steps-num").text();
        //在上传之前先删除以前可能有的
        $.ajax({
            url:"/PicDeleteServlet",
            data:{"flag":stepNum},
            type: "post",
            async:false,
            dataType:"text",
            success:function (result) {
                if(result == "deleteSuccess"){
                    deleteFlag = "deleteSuccess";
                }
            }
        });
        if(deleteFlag == "deleteSuccess"){
            var url = getUrl(this.files[0]);
            var $form = $(this).parent();
            var formData = new FormData();
            formData.append("flag",stepNum);
            formData.append("fileSteps",$(this)[0].files[0]);
            $.ajax({
                url:"/PicUploadServlet",
                data:formData,
                type:"post",
                cache:false,
                processData:false,
                contentType:false,
                success:function () {
                    if(url){
                        $($form).parents(".steps-img").css("height","auto");
                        $($form).parents(".steps-img").find(".tipss").hide();
                        $form.next().children().eq(0).css("width","300px").attr("src",url);
                    }
                },
                error:function (result) {

                }
            })
        }

    })
})
//每次进入创建菜谱页面，都先清空session中存的上一次创建菜谱的menuCoverPic和menuStepsPic
$(function () {
    $.ajax({
        url:"/RemoveMenuBufferServlet",
        type:"post",
        dataType:"json",
        success:function () {
            
        }
    })
})
//菜谱上传，写入数据库
//数据验证：标题必须有、封面图必须有、用料必须有一个且用量可以没有、步骤必须有一个
var coverExist;
$(function () {
    $("#createMenu").click(function () {
        //菜谱标题
        var menuTitle = $("input[name='menu-title']").val();
        //验证封面是否存在
        $.ajax({
            url:"/JudgeMenuCoverServlet",
            type:"post",
            async:false,
            dataType:"text",
            success:function (result) {
                if(result == "pass"){
                    coverExist = "pass";
                }else {
                    coverExist = "fail";
                }
            }
        })
        //菜谱描述
        var description = $("#description").val();
        //用料（至少有一个，不能没有食材）
        var materials = "";
        var judgeMaterial = "pass";
        $(".material tr").each(function () {
            var food = $(this).children().eq(0).children().eq(0).val();
            var much = $(this).children().eq(1).children().eq(0).val();
            if(food == ""){  //没填某项食材
                judgeMaterial = "fail";
                return false;
            }else {
                if($(this).index() != 0){
                    materials += "|";
                }
                materials += food;
                materials += " ";
            }
            if(much == ""){

            }else{
                materials += much;
            }
        })
        //步骤（至少一个步骤，不能没有步骤说明）
        var stepsDes = "";
        var judgeDes = "pass";
        $("#steps-ul li").each(function () {
            var stepDes = $(this).find("textarea").val();
            if(stepDes == ""){
                judgeDes = "fail";
                return false;
            }else{
                if($(this).index() != 0){

                    stepsDes += "|";
                }
                stepsDes += stepDes;
            }
        })
        //验证
        var judgeMsg = "";
        if(menuTitle == ""){
            judgeMsg += "标题不能为空"
        }
        if(coverExist == "fail"){
            judgeMsg += ",必须有封面图"
        }
        if(materials == 0){
            judgeMsg += "至少有一个用料"
        }else{
            if(judgeMaterial == "fail"){
                judgeMsg += ",必须有用料"
            }
        }
        if(steps == 0){
            judgeMsg += ",至少有一个步骤"
        }else {
            if(judgeDes == "fail"){
                judgeMsg += ",必须有步骤描述"
            }
        }
        if(judgeMsg != ""){
            layer.msg(judgeMsg,{time:3000});
        }else { //验证通过上传数据
            var menu = {"menuTitle":menuTitle,"menuDescription":description,"menuMaterial":materials,"menuSteps":stepsDes,"stepsNum":steps};
            $.ajax({
                url:"/CreateMenuServlet",
                type:"post",
                data:menu,
                success:function (result) {
                    if(result == "success"){
                        window.location.href = "getCaipuMessageServlet?c_name="+$("input[name='menu-title']").val();
                    }else{
                        layer.msg("创建菜谱失败！");
                        window.location.href = "createCaipu.html";
                    }
                },
                error:function () {
                    layer.msg("创建菜谱失败！");
                    window.location.href = "createCaipu.html";
                }
            })
        }
    })
})