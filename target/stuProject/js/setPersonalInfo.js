$(function () {
    $.ajax({
        url:"/GetUserInfoServlet",
        type:"post",
        dataType:"json",
        success:function (result) {
            $("#basic-show input").eq(0).val(result[0].u_name);
            $("#basic-show textarea").val(result[0].u_introduce);
            $("#basic-show input").eq(1).val(result[0].u_sex);
            $("#basic-show input").eq(2).val(result[0].u_email);
            $("#basic-show input").eq(4).val(result[0].u_hometown);
            $("#basic-show input").eq(5).val(result[0].u_nowlive);
            $("#basic-show input").eq(6).val(result[0].u_job);
            var birthday=(result[0].u_birthday).substring(0,10);

            $("#basic-show input").eq(3).val(birthday);

            $(".set-vatar.user_nav img").attr("src", result.u_image)

        }
    })
    var hometown = new Array();
    hometown[1] = ["通州","房山","昌平","怀柔"];
    hometown[2] = ["市南","市北","城阳","四方"];
    hometown[3] = ["红桥","塘沽","河东","河西"];
    $("select[name='hometownProvience']").change(function () {
        $("select[name='hometownCity']").html("");
        if($(this).val() == 0){
            var node = $("<option value='0'>请选择</option>");
            $("select[name='hometownCity']").append(node);
        }else{
            var city = hometown[$(this).val()];
            for(var i = 1;i <= city.length;i++){
                var node = $("<option value='"+i+"'>"+city[i-1]+"</option>");
                $("select[name='hometownCity']").append(node);
            }
        }

    })
    $("select[name='nowliveProvience']").change(function () {
        $("select[name='nowliveCity']").html("");
        if($(this).val() == 0){
            var node = $("<option value='0'>请选择</option>");
            $("select[name='nowliveCity']").append(node);
        }else{
            var city = hometown[$(this).val()];
            for(var i = 1;i <= city.length;i++){
                var node = $("<option value='"+i+"'>"+city[i-1]+"</option>");
                $("select[name='nowliveCity']").append(node);
            }
        }

    })
    $("#basic-info").click(function () {
        $("#basic-show").show();
        $(".basic-info").hide();
        $(".set-vatar").hide();
        $(".change-pwd").hide();
    })
    $("#set-avatar").click(function () {
        $.ajax({
            url:"/GetUserInfoServlet",
            type:"post",
            dataType:"json",
            success:function (result) {

                $(".set-vatar img").attr("src", result[0].u_image)
            }
        })
        $(".basic-info").hide();
        $("#basic-show").hide();
        $(".set-vatar").show();
        $(".change-pwd").hide();

    })
    $("#change-pwd").click(function () {
        $(".basic-info").hide();
        $("#basic-show").hide();
        $(".set-vatar").hide();
        $(".change-pwd").show();
    })
    $("#baseFrom").validate({
        rules: {

            email:{
                regex:/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            },
        },
        messages: {
            email:{
                regex:"请检查邮箱格式是否正确"
            }
        }})

    $(".compile").click(function () {
        $(".basic-info").show();
        $("#basic-show").hide();
    })
    $(".update").click(function () {
        $(".basic-info").hide();
        $("#basic-show").show();
        var name= $("input[name='nickname']").val();
        var introduce=$("textarea[name='selfIntroduce']").val();
        var sex=$('input[name="sex"]:checked').val();
        var email=$("input[name='email']").val();
        var birthday=$('#birthday-year option:selected' ).text()+"-"+$('#birthday-month option:selected').text()+"-"+$('#birthday-day option:selected').text();
        var hometown=$('#hometownProvience option:selected').text()+"-"+$('#hometownCity option:selected').text();
        var nowlive=$('#nowliveProvience option:selected').text()+"-"+$('#nowliveCity option:selected').text();
        var job=$('#job option:selected').text();
        $.ajax({
            url:"/updateUserInfoServlet",
            type:"post",
            data:{"name":name,"introduce":introduce,"sex":sex,"email":email,"birthday":birthday,"hometown":hometown,"nowlive":nowlive,"job":job},
            dataType:"text",
            success:function (result) {

                if(result=="1"){

                    layer.msg('设置个人信息成功',{time:2000},function() {
                            $.ajax({
                                url:"/GetUserInfoServlet",
                                type:"post",
                                dataType:"json",
                                success:function (result) {
                                    $("#basic-show input").eq(0).val(result[0].u_name);
                                    $("#basic-show textarea").val(result[0].u_introduce);
                                    $("#basic-show input").eq(1).val(result[0].u_sex);
                                    $("#basic-show input").eq(2).val(result[0].u_email);
                                    $("#basic-show input").eq(4).val(result[0].u_hometown);
                                    $("#basic-show input").eq(5).val(result[0].u_nowlive);
                                    $("#basic-show input").eq(6).val(result[0].u_job);
                                    var birthday=(result[0].u_birthday).substring(0,10);

                                    $("#basic-show input").eq(3).val(birthday);

                                    $(".set-vatar.user_nav img").attr("src", result.u_image)

                                }
                            })
                    }

                    );

                }
            }
        })
    })
    //验证新密码的格式
    $("input[name='newPwd']").keyup(function () {

        if($(this).next().prop("tagName")=="SPAN"){
            $(this).next().remove();
        }
            var str=$(this).val();
            var str1=$('input[name="currPwd"]').val();
            var regStr=/^.{6,20}$/;
            if(!regStr.test(str)){

                var $error=$('<span class="error">密码格式错误</span>');
                $(this).after($error);
            }

        });
    //验证新密码与旧密码是否一致
    $("input[name='newPwd']").blur(function () {

        if($(this).next().prop("tagName")=="SPAN"){
            $(this).next().remove();
        }

        var str=$(this).val();
        var str1=$('input[name="currPwd"]').val();
        var regStr=/^.{6,20}$/;
        if (str==str1) {
            var $error=$('<span class="error">新密码与旧密码不能一致</span>');
            $(this).after($error);
        }

    });
    //验证确认密码的格式
    $("input[name='repeatPwd']").keyup(function () {

        if($(this).next().prop("tagName")=="SPAN"){
            $(this).next().remove();
        }
        var str=$(this).val();
        var regStr=/^.{6,20}$/;
        if(!regStr.test(str)){

            var $error=$('<span class="error">密码错误</span>');
            $(this).after($error);
        }


    });
    // //验证密码输入是否正确
    // $('input[name="currPwd"]').blur(function () {
    //     if($(this).next().prop("tagName")=="SPAN"){
    //         $(this).next().remove();
    //     }
    //     var pwd1=$.md5($('input[name="currPwd"]').val());
    //     $.ajax({
    //         url:"/getUserPasswordServlet",
    //         data:{"password":pwd1},
    //         type:"post",
    //         dataType:"text",
    //
    //         success:function (result){
    //            if(result== "[]" ){
    //                var $error=$('<span class="error">密码错误</span>');
    //                $('input[name="currPwd"]').after($error);
    //
    //            }
    //         }
    //
    //     })
    //
    // });
    //验证当前密码的格式
    $("input[name='currPwd']").keyup(function () {
        if($(this).next().prop("tagName")=="SPAN"){
                     $(this).next().remove();
                }


        var str=$(this).val();
        var regStr=/^.{6,20}$/;
        if(!regStr.test(str)){
            var $error=$('<span class="error">密码格式错误</span>');
                    $(this).after($error);

        }

    });
    $("#passwordFrom").validate({
        onsubmit:true,// 是否在提交是验证
        onfocusout:true,// 是否在获取焦点时验证
        onkeyup :false,// 是否在敲击键盘时验证
        rules:{

            newPwd:{
                required:true,
                regex:/^.{6,20}$/

            },
            repeatPwd:{
                required:true,
                equalTo:"input[name='newPwd']"

            },
        },
        messages:{
            newPwd:{
                required:"请输入你的密码",
                regex:"密码格式错误"

            },
            repeatPwd:{
                required:"请输入密码",
                equalTo:"密码不一致"

            },
        },
        submitHandler:function(form){
            $(".alter").click(function () {
                var password= $.md5($('input[name="repeatPwd"]').val());
                $.ajax({
                    url:"/updateUserPasswordServlet",
                    type:"post",
                    data:{"password":password},
                    dataType:"text",
                    success:function (result) {

                        if(result=="1"){
                            layer.msg('密码修改成功',{time:2000},function() {})

                        }
                    }
                })
            })
        }

    });
    $('.fileupload').fileupload({
        url: "/uploadUserImg",
        Type: 'POST',//请求方式 ，可以选择POST，PUT或者PATCH,默认POST
        dataType: 'json',//服务器返回的数据类型
        // singleFileUploads: false,//不设置多个文件循环提交，设置后一起提交

        //add函数为选择文件后执行的操作
        add: function (e, data) {
            //获取图片路径并显示预览
            var url = getUrl(data.files[0]);
            $(".vatar img").attr("src", url)

            //绑定上传提交事件
            $("#btn1").click(function () {
                data.submit();

            });
        },
        //dropZone: $('#dropzone') //此为拖拽文件控制，暂未开发。
        done: function (e, ret) {
            if (ret.result.errno == 0) {
                layer.msg('头像上传成功',{time:2000},function() {})
                $.ajax({
                    url:"/GetUserInfoServlet",
                    type:"post",
                    async:false,
                    dataType:"json",
                    success:function (result) {
                        $("#img1").attr("src", result[0].u_image)
                    }
                })
            }

        },
    });

});
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