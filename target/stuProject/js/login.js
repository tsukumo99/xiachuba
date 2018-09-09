$(function () {

    // 登录
    $("button").click(function () {
        $.post("/checkLockServlet",
            {"username":$("input[name='username']").val(),
                "password":$.md5($("input[name='password']").val())
            },
            function (ret) {
                if(ret){
                    layer.msg("登录成功",{time:3000});
                    layer.close(layer.index);
                    window.parent.location.reload();
                }else{
                    alert("用户名或密码错误") ;
                }
            },'json');
    });
    // 点击注册
    $(".l-footer a").click(function () {

        layer.open({
            title:false,
            type: 2,
            closeBtn: 0, //不显示关闭按钮
            shade: [0],
            area: ['340px', '574px'],
            offset: 'auto',
            anim: 2,
            content: ['rigister.html', 'no'],
            end:function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }
        });
    });
    // 验证用户名
    $("input[name='username']").keyup(function () {
        var regex =/\w{4,10}/;
        var username = $(this).val();
        if(!regex.test(username)){
            layer.tips('用户名不得少于4位', $(this), {
                tips: [1, 'red'],
                time:4000
            });
        }else{
            layer.closeAll('tips');
        }
    });
    //验证密码
    $("input[name='password']").keyup(function () {
        var regex =/^[a-zA-Z0-9]{6,18}/;
        var password = $(this).val();
        if(!regex.test(password)){
            layer.tips('密码不得少于6位', $(this), {
                tips: [1, 'red'],
                time:0,
                id:"password"
            });
        }else{
            layer.closeAll('tips');
        }

    });

});
