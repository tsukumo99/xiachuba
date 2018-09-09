
//刘志辉start----------------------------------------------------------------------------
$(function () {
    var pageNumber = 1;
    var pageSize = 12;
    var totalPageNumber = 5;
    var c_count = "c_count";

    //删除中间和右边元素
    $(".normal-menu-list").html("");
    $(".normal-recipe-list .list").html("");

    randomCaipuRight();
    randomCaipuMiddle();


    //中间的菜谱分页
    $(".pager a").click(function () {
            if ($(this).text() == '上一页') {
                if (pageNumber == 1) {
                    pageNumber = 1;
                    randomCaipuMiddle()
                }
                else {
                    pageNumber--;
                    randomCaipuMiddle()                }
            }
            else if ($(this).text() == "下一页") {
                if (pageNumber == totalPageNumber) {
                    pageNumber = totalPageNumber;
                    randomCaipuMiddle()                }
                else {
                    pageNumber++;
                    randomCaipuMiddle()                }
            }
            else {
                pageNumber = parseInt($(this).text());
                if (pageNumber > totalPageNumber) {
                    pageNumber = totalPageNumber;
                }
                randomCaipuMiddle()            }

    })

})
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
//随机菜谱右边
function randomCaipuRight() {
    //隐藏右边菜谱
    $(".normal-recipe-list .list").html("");
    $.ajax({
        url: "/findAllCaipuAndUserServlet",
        type: "post",
        dataType: "json",
        success: function (result) {
            var array = random(9, 0, result.length);
            for (var i = 0; i < array.length; i++) {
                var add = "<li><a href='getCaipuMessageServlet?c_name=" + result[array[i]].c_name + "' class=\"recipe-menu image-link has-border\" title=\"\" target=\"_blank\">\n" +
                    "                            <img src=" + result[array[i]].c_image + " class=\"recipe-menu-cover\" width=\"300\" height=\"140\">\n" +
                    "                            <div class=\"recipe-menu-name ellipsis\">" + result[array[i]].u_name + "</div>\n" +
                    "                        </a></li>"

                $(".normal-recipe-list .list").append(add);//右边的

            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}
//随机菜谱中间
function randomCaipuMiddle() {
    //隐藏中间菜谱
    $(".normal-menu-list").html("");
    $.ajax({
        url: "/findAllCaipuAndUserServlet",
        type: "post",
        dataType: "json",
        success: function (result) {
            var array = random(9, 0, result.length);
            for (var i = 0; i < array.length; i++) {
                var add = "<li><a href='getCaipuMessageServlet?c_name=" + result[array[i]].c_name + "' class=\"recipe-menu image-link has-border\" title=\"\" target=\"_blank\">\n" +
                    "                            <img src=" + result[array[i]].c_image + " class=\"recipe-menu-cover\" width=\"300\" height=\"140\">\n" +
                    "                            <div class=\"recipe-menu-name ellipsis\">" + result[array[i]].u_name + "</div>\n" +
                    "                        </a></li>"

                $(".normal-menu-list").append(add);//中间的

            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

//刘志辉end----------------------------------------------------------------------------
