<%@ page import="org.lanqiao.entity.Caipu" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% List<Caipu> list= (List<Caipu>)request.getAttribute("Caipulist");
        int c_id=list.get(0).getC_id();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>步骤页</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/Showstep.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/base.js"></script>
    <script src="js/Showstep.js"></script>
    <script src="js/addImg.js"></script>
    <script src="js/search.js"></script>
</head>
<body>
<div class="topbar-outer has-bottom-border">
    <div class="topbar-container">
        <div class="topbar">
            <div class="pure-g">
                <div class="pure-u-1-6">
                    <a href="" class="logo">爱厨房</a>
                </div>
                <div class="pure-u-5-6">
                    <div class="float-left">
                        <form class="search" action="/getCaipuMessageServlet2" method="post">
                            <span class="twitter-typeahead" style="position: relative; float: left;"><input
                                    class="tt-hint" type="text" autocomplete="off" spellcheck="off" disabled=""
                                    style="position: absolute; top: 0px; left: 0px; border-color: transparent; box-shadow: none; background: none 0% 0% / auto repeat scroll padding-box border-box rgb(255, 255, 255);"><input
                                    type="text" name="c_name" class="typeahead float-left tt-query" value=""
                                    placeholder="搜索菜谱、食材" autocomplete="off" spellcheck="false" dir="auto"
                                    style="position: relative; vertical-align: top; background-color: transparent;"><span
                                    style="position: absolute; left: -9999px; visibility: hidden; white-space: nowrap; font-family: sans-serif; font-size: 16px; font-style: normal; font-variant: normal; font-weight: 400; word-spacing: 0px; letter-spacing: 1px; text-indent: 0px; text-rendering: auto; text-transform: none;"></span><span
                                    class="tt-dropdown-menu"
                                    style="position: absolute; top: 100%; left: 0px; z-index: 100; display: none;"></span></span>
                            <input type="hidden" name="cat" value="1001">
                            <input type="submit" value="搜菜谱" class="button float-left">
                        </form>
                    </div>
                    <div class="float-left">
                        <ul class="site-nav plain pure-g">
                            <li class="pure-u"><a href="home_page.html" data-ga-event="公共页面/导航栏/$text">首页</a></li>
                            <li class="topbar-cats pure-u">
                                <a href="caiPingFenLei.html" class="block-link" data-ga-event="公共页面/导航栏/$text"><span id="span1">菜谱分类</span></a>
                                <div  class="topbar-cats-submenu hidden" style="display: none;">
                                    <div class="topbar-cats-submenu-bg">
                                        <ul class="plain">
                                            <li class="topbar-cat-head">常用主题</li>
                                            <li><a href="" title="家常菜菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">家常菜</a></li>
                                            <li><a href="" title="快手菜菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">快手菜</a></li>
                                            <li><a href="" title="下饭菜菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">下饭菜</a></li>
                                            <li><a href="" title="早餐菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">早餐</a></li>
                                            <li><a href="" title="减肥菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">减肥</a></li>
                                            <li><a href="" title="汤羹菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">汤羹</a></li>
                                            <li><a href="" title="烘焙菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">烘焙</a></li>
                                            <li><a href="" title="小吃菜谱大全"
                                                   data-ga-event="公共页面/导航栏/$text">小吃</a></li>
                                        </ul>
                                        <ul class="plain">
                                            <li class="topbar-cat-head">常见食材</li>
                                            <li><a href="" title="猪肉做法大全" data-ga-event="公共页面/导航栏/$text">猪肉</a>
                                            </li>
                                            <li><a href="" title="鸡肉做法大全" data-ga-event="公共页面/导航栏/$text">鸡肉</a>
                                            </li>
                                            <li><a href="" title="牛肉做法大全" data-ga-event="公共页面/导航栏/$text">牛肉</a>
                                            </li>
                                            <li><a href="" title="鱼做法大全"
                                                   data-ga-event="公共页面/导航栏/$text">鱼</a></li>
                                            <li><a href="" title="鸡蛋做法大全" data-ga-event="公共页面/导航栏/$text">鸡蛋</a>
                                            </li>
                                            <li><a href="" title="土豆做法大全" data-ga-event="公共页面/导航栏/$text">土豆</a>
                                            </li>
                                            <li><a href="" title="茄子做法大全" data-ga-event="公共页面/导航栏/$text">茄子</a>
                                            </li>
                                            <li><a href="" title="豆腐做法大全"
                                                   data-ga-event="公共页面/导航栏/$text">豆腐</a></li>
                                        </ul>
                                        <ul class="plain">
                                            <li class="topbar-cat-head">时令食材</li>
                                            <li>
                                                <a href="" title="秋葵做法大全" data-ga-event="公共页面/导航栏/$text">秋葵</a>
                                                <span class="topbar-cat-score">
                        10.0
                    </span>
                                            </li>
                                            <li>
                                                <a href="" title="丝瓜做法大全" data-ga-event="公共页面/导航栏/$text">丝瓜</a>
                                                <span class="topbar-cat-score">
                        10.0
                    </span>
                                            </li>
                                            <li>
                                                <a href="" title="西瓜做法大全" data-ga-event="公共页面/导航栏/$text">西瓜</a>
                                                <span class="topbar-cat-score">
                        10.0
                    </span>
                                            </li>
                                            <li>
                                                <a href="" title="苦瓜做法大全" data-ga-event="公共页面/导航栏/$text">苦瓜</a>
                                                <span class="topbar-cat-score">
                        10.0
                    </span>
                                            </li>
                                            <li>
                                                <a href="" title="西柚做法大全" data-ga-event="公共页面/导航栏/$text">西柚</a>
                                                <span class="topbar-cat-score">
                        10.0
                    </span>
                                            </li>
                                            <li>
                                                <a href="" title="空心菜做法大全"
                                                   data-ga-event="公共页面/导航栏/$text">空心菜</a>
                                                <span class="topbar-cat-score">
                        9.9
                    </span>
                                            </li>
                                            <li>
                                                <a href="" title="葡萄做法大全" data-ga-event="公共页面/导航栏/$text">葡萄</a>
                                                <span class="topbar-cat-score">
                        9.9
                    </span>
                                            </li>
                                            <li>
                                                <a href="" title="冬瓜做法大全" data-ga-event="公共页面/导航栏/$text">冬瓜</a>
                                                <span class="topbar-cat-score">
                        9.8
                    </span>
                                            </li>
                                        </ul>
                                        <div class="topbar-cats-submenu-bottom"><a href=""
                                                                                   data-ga-event="公共页面/导航栏/$text">查看全部分类</a>
                                        </div>

                                    </div>
                                </div>
                            </li>
                            <li class="pure-u"><a href="Menu.html" data-ga-event="公共页面/导航栏/$text">菜单</a>
                            </li>
                            <li class="pure-u"><a href="workDynamicAll.html" data-ga-event="公共页面/导航栏/$text"
                                                  rel="nofollow">作品动态</a></li>
                        </ul>
                    </div>
                    <div class="float-right clearfix">

                        <div class="user-action">
                            <div class="user-nav">
                                <a class="user-avatar avatar" href="/cook/130169432/"
                                   data-ga-event="公共页面/导航栏/$text">
                                    <img id="img1" src="images/Showstep/1.png" alt="手机用户5710_l930的厨房" width="30" height="30"/>
                               </a>
                                <div class="user-nav-submenu hidden" style="position: absolute;top: 30px;" >
                                    <ul class="plain">
                                        <li><a href="mykitchen.html" data-ga-event="公共页面/导航栏/$text">我的厨房</a></li>
                                        <li><a href="mykitchen.html"
                                               data-ga-event="公共页面/导航栏/$text">我的菜单</a></li>
                                        <li><a href="setPersonalInfo.html" data-ga-event="公共页面/导航栏/$text">帐号设置</a></li>
                                        <li><a href="" data-ga-event="公共页面/导航栏/$text">发现好友</a></li>
                                        <li><a href="/removeLoginServlet">退出</a></li>
                                    </ul>
                                </div>
                            </div>
                            <a class="user-collect" href="MyCollection.html" title="我的收藏">
                                <i class="icon"></i>
                            </a>

                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
<div id="search_show">
</div>
<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->

<div class="page-outer">
    <div class="page-container">
        <div class="pure-g">
            <div class="pure-u-2-3 main-panel">
                <div itemscope itemtype="">
                    <h1 class="page-title" itemprop="name">${requestScope.Caipulist.get(0).c_name}
                    <i class="exclusive-icon"></i>
                    </h1>
                    <div class="block recipe-show">
                        <div class="cover image expandable block-negative-margin">
                            <img src="${requestScope.Caipulist.get(0).c_image}" itemprop="image" width="660">
                        </div>
                        <div class="container pos-r pb20 has-bottom-border">
                            <div class="stats clearfix">
                                <div class="score float-left" itemprop="aggregateRating" itemscope itemtype="">
                                    <span class="number" itemprop="ratingValue">8.2</span>
                                    <meta itemprop="bestRating" content="10">
                                    <meta itemprop="ratingCount" content="84">
                                    <span class="title">综合评分</span>
                                </div>
                                <div class="cooked float-left">
                                    <span class="number">97</span>
                                    <span class="title">人做过这道菜</span>
                                </div>
                                <div class="collect pure-g align-right">
                                    <%--<%--%>
                                        <%--int ret=(int)request.getSession().getAttribute("ret");--%>
                                      <%--if (ret==1){--%>
                                    <%--%>--%>
                                    <%--<a  class="button large-button collect-button" style="background-color: darkgrey">已收藏</a>--%>
                                    <%--<%}--%>
                                    <%--else{--%>
                                    <%--%>--%>
                                    <a title="<%=c_id%>" class="button large-button collect-button">收藏</a>
                                    <%--<%}%>--%>
                                </div>
                            </div>
                        </div>
                        <div class="rate-dialog block-negative-margin"></div>
                        <div class="author" itemprop="author" itemtype="">
                            <a href="" class="avatar-link avatar">
                                <img src="images/Showstep/touxiang.jpg" width="60" height="60">
                                &nbsp;<span itemprop="name">_慧绘美食记_</span>
                            </a>
                            <a href="" class="icon icon-cooker" rel="nofollow"></a>
                        </div>
                        <div class="desc mt30" itemprop="description">
                            ${requestScope.Caipulist.get(0).c_introduce}
                        </div>
                        <h2>用料&nbsp;</h2>
                        <div class="ings">
                            <table>
                                <tbody>
                                <%
                                  String c_made=list.get(0).getC_made();
                                  String[] str_made=c_made.split("\\|");//分隔符
                                %>
                                <%--豆腐 150g|鸡蛋 1个|虾皮 1把|芝士 适量|蚝油 半勺|葱花 少许|酱油 少许|盐、黑胡椒 适量--%>
                                <!--循环获取完菜谱材料的次数-->
                                <%for (int i=0;i<str_made.length;i++){
                                    if(str_made[i].split(" ").length==2){
                                        String[] str_made2=str_made[i].split(" ");
                                %>
                                <tr itemprop="recipeIngredient">
                                    <td class="name"><a href="/category/2316/">
                                        <%=str_made2[0]%>
                                    </a></td>
                                    <td class="unit"><%=str_made2[1]%>
                                    </td>
                                </tr>
                                <%}

                                else{%>
                                <tr itemprop="recipeIngredient">
                                    <td class="name"><a href="/category/2316/">
                                        <%=str_made[i]%>
                                    </a></td>
                                    <td class="unit">
                                    </td>
                                </tr>
                                <%}}%>

                                </tbody>
                            </table>
                        </div>
                        <h2 id="steps">抹茶红豆牛奶哈斯面包的做法</h2>
                        <div class="steps">
                            <!--有序列表-->
                            <ol>
                                <%
                                    List<Caipu> list1= (List<Caipu>) request.getAttribute("Caipulist");
                                    String c_step=list1.get(0).getC_step();
                                    String c_step_image=list1.get(0).getC_step_image();
                                    String[] str_step=c_step.split("\\|");//分隔符
                                    String[] str_image=c_step_image.split("\\|");//分隔符

                                for (int i=0;i<str_step.length;i++){
                                %>
                                <li class="container">
                                    <p class="text"><%=str_step[i]%></p>
                                    <p></p>
                                    <img src="<%=str_image[i]%>" width="300">
                                </li>
                                <%}%>

                            </ol>

                                <p class="links">
                                    <a href="createDynamic.html" class="button large-button w100" rel="nofollow">上传你做的超快手酱炒金针菇</a>
                                </p>

                        </div>

                    </div>
                </div>
            </div>

            <div class="ad">
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao1.jpg"></a>
                    </div>
                    <p>手撕面包加盟</p>
                </div>
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao2.jpg"></a>
                    </div>
                    <p>电饭锅做面包</p>
                </div>
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao3.jpg"></a>
                    </div>
                    <p>电饭锅做蛋糕</p>
                </div>
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao4.jpg"></a>
                    </div>
                    <p>飞利浦面条机</p>
                </div>
            </div>
            <div class="ad">
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao5.jpg"></a>
                    </div>
                    <p>专利申请</p>
                </div>
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao6.jpg"></a>
                    </div>
                    <p>如何做奶茶</p>
                </div>
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao7.jpg"></a>
                    </div>
                    <p>一点点奶茶加盟</p>
                </div>
                <div class="ad_item">
                    <div class="ad_img">
                        <a><img src="images/Showstep/guanggao8.jpg"></a>
                    </div>
                    <p>豆芽机</p>
                </div>
            </div>
            <div class="recipe-menus block mb50">
                <div class="title-bar">
                    <h3 class="title">被大家加入到以下菜单</h3>
                </div>
                <div class="content">
                    <a href="" class="recipe-menu image-link has-border" title="" target="_blank">
                        <img src="images/Showstep/jiachangcai.jpg" width="300" height="140">
                        <div class="recipe-menu-name ellipsis">家常菜</div>
                    </a>
                </div>
                <div class="content">
                    <a href="" class="recipe-menu image-link has-border" title="" target="_blank">
                        <img src="images/Showstep/kuaishoucai.jpg" width="300" height="140">
                        <div class="recipe-menu-name ellipsis">快手菜</div>
                    </a>
                </div>
                <div class="content">
                    <a href="" class="recipe-menu image-link has-border" title="" target="_blank">
                        <img src="images/Showstep/xiafancai.jpg" width="300" height="140">
                        <div class="recipe-menu-name ellipsis">下饭菜</div>
                    </a>
                </div>
                <div class="content">
                    <a href="" class="recipe-menu image-link has-border" title="" target="_blank">
                        <img src="images/Showstep/33xiaochu.jpg" width="300" height="140">
                        <div class="recipe-menu-name ellipsis">33小厨</div>
                    </a>
                </div>
                <div class="content">
                    <a href="" class="recipe-menu image-link has-border" title="" target="_blank">
                        <img src="images/Showstep/chuangyicai.jpg" width="300" height="140">
                        <div class="recipe-menu-name ellipsis">创意菜</div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>


<!--======================================================================================================================================================  -->
<div class="footer-outer">
    <div class="footer-container">


        <div class="pure-g buttons">
            <a href="" class="button">入驻下厨房市集</a>
            <a href="" class="button">广告合作</a>
        </div>

        <div class="pure-g">
            <div class="pure-u-3-4">
                <a data-ga-event="公共页面/footer/$text" href="" target="_blank" title="美食生活杂志">美食生活杂志</a>
                &nbsp;
                <a href="" target="_blank" title="厨房工作" rel="nofollow">厨房工作</a> &nbsp;
                <a data-ga-event="公共页面/footer/$text" href="" target="_blank" title="社区指导原则" rel="nofollow">社区指导原则</a>
                &nbsp;
                <a data-ga-event="公共页面/footer/$text" href="" target="_blank"
                   title="下厨房出版的书" rel="nofollow">下厨房出版的书</a> &nbsp;
                <a data-ga-event="公共页面/footer/$text" href="" target="_blank" title="帮助中心" rel="nofollow">帮助中心</a>
                &nbsp;
                <a data-ga-event="公共页面/footer/$text" href="" target="_blank" title="联系我们"
                   rel="nofollow">联系我们</a> &nbsp;
                <a data-ga-event="公共页面/footer/$text" href="javascript:void(0)" title="意见反馈" rel="nofollow"
                   id="feedbackButton">意见反馈</a> &nbsp;
                <a data-ga-event="公共页面/footer/$text" href="" target="_blank" title="隐私声明"
                   rel="nofollow">隐私声明</a>
            </div>
            <div class="pure-u-1-4 align-right">
                <div class="social-likes">
                    <a href="" target="_blank" rel="nofollow">
                        <img src="https://s.chuimg.com/simpleicons/sinaweibo.svg" alt="微博" title="微博">
                    </a>
                    &nbsp;
                    <a href="" target="_blank" rel="nofollow">
                        <img src="https://s.chuimg.com/simpleicons/twitter.svg" alt="Twitter" title="Twitter">
                    </a>
                </div>
            </div>
        </div>
        <div class="pure-g">
            <div class="pure-u-3-4">
                Copyright © xiachufang.com &nbsp;
                京B2-20180499 &nbsp;
                <a href="" class="gray-link" target="_blank"
                   rel="nofollow">京ICP备13009078号-1</a> &nbsp;
                京公网安备11010802022310号
                <br>
                违法和不良信息举报电话：010-52800126 &nbsp;
                举报邮箱：talk@xiachufang.com
            </div>
            <div class="pure-u-1-4 align-right">
                唯有美食与爱不可辜负
            </div>
        </div>

    </div>
</div>


</body>
</html>