
$(function () {
    var nameflag=false;
    var phoneflag=false;
    var paswdflag=false;
    var yzmflag;

    $("input[name='username']").keyup(function () {
        var regename =/\w{4,10}/;
        var username = $(this).val();
        if(!regename.test(username)){
            layer.tips('用户名不得少于4位', $(this), {
                tips: [1, 'red'],
                time:4000
            });
        }else{
            layer.closeAll('tips');
            nameflag=true;
        }
    });

    $("input[name='phone']").keyup(function () {
        var regephone =/^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
        var phone = $(this).val();
        if(!regephone.test(phone)){
            layer.tips('请输入正确的手机号', $(this), {
                tips: [1, 'red'],
                time:4000
            });
        }else{
            layer.closeAll('tips');
            phoneflag = true;
        }
    });

    $("input[name='password']").keyup(function () {
        var regepassw =/\w{6,20}/;
        var password = $(this).val();
        if(!regepassw.test(password)){
            layer.tips('密码长度不能小于6位', $(this), {
                tips: [1, 'red'],
                time:4000
            });
        }else{
            layer.closeAll('tips');
        }
    });

    $("input[name='repassword']").keyup(function () {
        var pass1 = $("input[name='password']").val();
        var pass2 = $(this).val();
        if(pass1!=pass2){
            layer.tips('两次输入密码不一致', $(this), {
                tips: [1, 'red'],
                time:4000
            });
        }else{
            layer.closeAll('tips');
            paswdflag=true;
        }
    });

    $(".message span:eq(0)").click(function () {
        // 发送验证码短信
        $.post("/MessageServlet",
            {"phone":$("input[name='phone']").val()});
             layer.msg("短信已发送");
    });


    $("input[name='code']").blur(function () {
        $.ajax({
            url:"/MessageServlet",
            type:"post",
            success:function (yzm) {
                var num = yzm.replace(/[^0-9]/ig,"");
                var getyzm = $("input[name='code']").val();
                if (num == getyzm){
                    yzmflag = true;
                }else{
                    yzmflag = false;
                }
            }
        })
    });



    $("button").click(function () {

        if (nameflag && phoneflag && paswdflag && yzmflag){

        $.post("/insertUserInfo",
            {"username":$("input[name='username']").val(),
            "phone":$("input[name='phone']").val(),
            "password":$.md5($("input[name='password']").val())
        },function (ret) {
            if(ret=="1"){
                layer.msg('注册成功',{time:1000},function () {
                    window.location.href= "login.html";
                });
            }
        },'text')
    }
        else{
            layer.msg("注册失败",{time:1000});
        }

});
});