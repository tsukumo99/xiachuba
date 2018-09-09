$(function () {
    var pageNumber = 1;
    var pageSize = 12;
    var totalPageNumber = 0;
    var c_count = "c_count";
    var c_createtime = "c_createtime";
    var flag = 1;// 1按流行度排序，0按时间排序

    //隐藏中间菜谱
    $(".normal-menu-list li").hide();

    //加载时，就更新中间的第一页，默认以流行度排序
    sort(c_count, pageSize, pageNumber);
    //加载时，就更新右边的
    randomCaipu();
    //点击换一批，就换一批推荐
    $(".right-action a").click(function () {
        randomCaipu();
    })

    //中间的菜谱分页
    $(".pager a").click(function () {
        if (flag == 1) {
            totalPageNumber = Math.ceil(totalPageNumber / pageSize)
            if ($(this).text() == '上一页') {
                if (pageNumber == 1) {
                    pageNumber = 1;
                    sort(c_count, pageSize, pageNumber);
                }
                else {
                    pageNumber--;
                    sort(c_count, pageSize, pageNumber);
                }
            }
            else if ($(this).text() == "下一页") {
                if (pageNumber == totalPageNumber) {
                    pageNumber = totalPageNumber;
                    sort(c_count, pageSize, pageNumber);
                }
                else {
                    pageNumber++;
                    sort(c_count, pageSize, pageNumber);
                }
            }
            else {
                pageNumber = parseInt($(this).text());
                if (pageNumber > totalPageNumber) {
                    pageNumber = totalPageNumber;
                }
                sort(c_count, pageSize, pageNumber);
            }
        }
        else {
            totalPageNumber = Math.ceil(totalPageNumber / pageSize)
            if ($(this).text() == '上一页') {
                if (pageNumber == 1) {
                    pageNumber = 1;
                    sort(c_createtime, pageSize, pageNumber);
                }
                else {
                    pageNumber--;
                    sort(c_createtime, pageSize, pageNumber);
                }
            }
            else if ($(this).text() == "下一页") {
                if (pageNumber == totalPageNumber) {
                    pageNumber = totalPageNumber;
                    sort(c_createtime, pageSize, pageNumber);
                }
                else {
                    pageNumber++;
                    sort(c_createtime, pageSize, pageNumber);
                }
            }
            else {
                pageNumber = parseInt($(this).text());
                if (pageNumber > totalPageNumber) {
                    pageNumber = totalPageNumber;
                }
                sort(c_createtime, pageSize, pageNumber);
            }
        }
    })

    //点击中间选择按时间排序
    $(".mb30 a:eq(1)").click(function () {
        flag = 0;
        pageNumber = 1;
        sort(c_createtime, pageSize, pageNumber);

    })

    //点击中间选择按流行排序
    $(".mb30 a:eq(0)").click(function () {
        flag = 1;
        pageNumber = 1;
        sort(c_count, pageSize, pageNumber);

    })

    function sort(field, pageSize, pageNumber) {
        //隐藏中间菜谱
        $(".normal-menu-list li").remove();
        //默认中间以流行度排序
        $.ajax({
            url: "/sortCaipuServlet",
            type: "post",
            data: {"sortfield": field, "pageSize": pageSize, "pageNumber": pageNumber},
            dataType: "json",
            success: function (result) {
                totalPageNumber = result[result.length - 1];
                for (var i = 0; i < result.length - 1; i++) {
                    var add = "<li style='list-style-type:none;'>\n" +
                        "                                    <div class=\"menu clearfix has-border\">\n" +
                        "                                        <div class=\"cover\">\n" +
                        "                                            <a href='getCaipuMessageServlet?c_name=" + result[i].c_name + "' class=\"image-link\" target=\"_blank\">\n" +
                        "                                                <img style='width: 215px;height:136px;' src=" + result[i].c_image + " class=\"unveiled\">\n" +
                        "                                            </a>\n" +
                        "                                        </div>\n" +
                        "                                        <div class=\"desc\">\n" +
                        "                                            <p class=\"name\">\n" +
                        "                                                <a href='getCaipuMessageServlet?c_name=" + result[i].c_name + "' target=\"_blank\">\n" +
                        "                                                    <span class=\"ellipsis\">" + result[i].c_name + "</span>\n" +
                        "                                                </a>\n" +
                        "                                            </p>\n" +
                        "                                            <div class=\"stats\">\n" +
                        "                                                <p class=\"time green-font\">20菜谱</p>\n" +
                        "                                                <a class=\"gray-link\"> " + result[i].u_name + "</a>\n" +
                        "                                                &nbsp;&nbsp;创建&nbsp;&nbsp;&nbsp;\n" +
                        "                                                <span class=\"n-collects\">" + result[i].c_count + " 收藏</span>\n" +
                        "                                            </div>\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "                                </li>";
                    $(".normal-menu-list").append(add);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }

    function randomCaipu() {
        //隐藏右边菜谱
        $(".recipe-menus a").remove();
        $.ajax({
            url: "/findAllCaipuAndUserServlet",
            type: "post",
            dataType: "json",
            success: function (result) {
                var array = random(9, 0, result.length);
                for (var i = 0; i < array.length; i++) {
                    var add = "<a href='getCaipuMessageServlet?c_name=" + result[array[i]].c_name + "' class=\"recipe-menu image-link has-border\" title=\"\" target=\"_blank\">\n" +
                        "                            <img src=" + result[array[i]].c_image + " class=\"recipe-menu-cover\" width=\"300\" height=\"140\">\n" +
                        "                            <div class=\"recipe-menu-name ellipsis\">" + result[array[i]].u_name + "</div>\n" +
                        "                        </a>"

                    $(".recipe-menus").append(add);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }

    //取某一范围的随机数 end最大值，len长度，start开始值
    function random(len, start, end) {
        var arr = [];

        function creat(start, end) {
            var numlen = end - start;
            return parseInt(Math.random() * numlen + start)
        }

        while (arr.length < len) {
            var num = creat(start, end);
            if (arr.indexOf(num) == -1) {
                arr.push(num);
            }
        }
        return arr;
    }


    // 王咸林===============================================================
    // 获取session的值
    $.ajax({
        url: "/GetSessionServlet",
        data: {"userBean": "sessionkey"},
        dataType: "json",
        success: function (ret) {
            if (ret == null) {
            } else {
                // 将注册和登录隐藏
                var user = ret;
                loginAngRigister();
                showIndexMessage(user);
            }
        }
    });
    // 点击登录，显示登录弹窗
    $(".user-action a:eq(0)").click(function () {

        layer.open({
            title: false,
            type: 2,
            closeBtn: 1, //不显示关闭按钮
            shade: [0],
            area: ['340px', '590px'],
            offset: 'auto',
            anim: 2,
            content: ['login.html', 'no']
        });

    });
// 点击注册，显示注册弹窗
    $(".user-action a:eq(1)").click(function () {
        layer.open({
            title: false,
            type: 2,
            closeBtn: 1, //不显示关闭按钮
            shade: [0],
            area: ['340px', '550px'],
            offset: 'auto',
            anim: 2,
            content: ['rigister.html', 'no'], //iframe的url，no代表不显示滚动条
        });
    });



});
function showIndexMessage(user){
    // 先将之前的隐藏
    $(".user").attr("style","display:block");
    // 获取用户的头像url
    var imageurl = user.u_image;
    // 更换导航栏的用户头像
    // $(".user-nav img").attr("src",imageurl);
}
function loginAngRigister() {
    $(".a-login").css("display", "none");
    // 显示用户头像和收藏
    $(".user-nav").attr("style", "display:block");
    $(".user-collect").attr("style", "display:block");
}