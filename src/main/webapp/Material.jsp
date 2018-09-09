<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String name = URLDecoder.decode(request.getParameter("name"),"UTF-8");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>材料页</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/menu.css">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/base.js"></script>
    <script src="js/Material.js"></script>
</head>
<body id="comehere">
<div class="topbar-outer has-bottom-border">
    <div class="topbar-container">
        <div class="topbar">
            <div class="pure-g">
                <div class="pure-u-1-6">
                    <a href="" class="logo">爱厨房</a>
                </div>
                <div class="pure-u-5-6">
                    <div class="float-left">
                        <form class="search" action="/search/">
                            <span class="twitter-typeahead" style="position: relative; float: left;"><input
                                    class="tt-hint" type="text" autocomplete="off" spellcheck="off" disabled=""
                                    style="position: absolute; top: 0px; left: 0px; border-color: transparent; box-shadow: none; background: none 0% 0% / auto repeat scroll padding-box border-box rgb(255, 255, 255);"><input
                                    type="text" name="keyword" class="typeahead float-left tt-query" value=""
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
                                    <img id="img1" src="images/Material/1.png" alt="手机用户5710_l930的厨房" width="30" height="30"/>
                               </a>
                                <div class="user-nav-submenu hidden" style="position: absolute;top: 30px;" >
                                    <ul class="plain">
                                        <li><a href="mykitchen.html" data-ga-event="公共页面/导航栏/$text">我的厨房</a></li>
                                        <li><a href="mykitchen.html" data-ga-event="公共页面/导航栏/$text">我的菜单</a></li>
                                        <li><a href="setPersonalInfo.html" data-ga-event="公共页面/导航栏/$text">帐号设置</a></li>
                                        <li><a href="" data-ga-event="公共页面/导航栏/$text">发现好友</a></li>
                                        <li><a href="/removeLoginServlet">退出</a></li>
                                    </ul>
                                </div>
                            </div>
                            <a class="user-collect" href="" title="我的收藏">
                                <i class="icon"></i>
                            </a>

                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
<!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->

<div class="page-outer">
    <div class="page-container">
        <div class="pure-g">

            <!--main-panel-->

            <div class="pure-u-2-3 main-panel">
                <div class="white-bg block">
                    <div class="pure-g">
                        <div class="pure-u-1-4 search-left-nav">
                            <ul class="plain list search-left-nav-list">
                                <li><a href="Material.jsp?name=本周最受欢迎">本周最受欢迎</a></li>
                                <li><a href="Material.jsp?name=新秀菜谱">新秀菜谱</a></li>
                                <li><a href="Material.jsp?name=往期头条">往期头条</a></li>
                                <li><a href="Material.jsp?name=厨房101">厨房101</a></li>
                                <li><a href="Material.jsp?name=月度最佳">月度最佳</a></li>
                                <li><a href="Material.jsp?name=最新创建">最新创建</a></li>
                                <li><a href="Material.jsp?name=流行菜单">流行菜单</a></li>
                            </ul>
                            <div class="pop-keywords">
                                <p class="gray-font">流行搜索</p>
                                <ul class="plain list normal-font">
                                    <li><a>月饼</a></li>
                                    <li><a>牛排</a></li>
                                    <li><a>南瓜饼</a></li>
                                    <li><a>虾</a></li>
                                    <li><a>蛋糕</a></li>
                                    <li><a>蛋黄酥</a></li>
                                    <li><a>可乐鸡翅</a></li>
                                    <li><a>南瓜</a></li>
                                    <li><a>冰皮月饼</a></li>
                                    <li><a>蛋挞</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="pure-u-3-4 search-result-list">
                            <h1 class="page-title"><%=name%></h1>
                            <ul class="list normal-menu-list">
                                <!--循环20次-->
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="menu clearfix has-border">
                                        <div class="cover">
                                            <a class="image-link" target="_blank">
                                                <img src="images/Material/鸡翅.jpg" class="unveiled">
                                            </a>
                                        </div>
                                        <div class="desc">
                                            <p class="name">
                                                <a href="" target="_blank">
                                                    <span class="ellipsis">可乐鸡翅</span>
                                                </a>
                                                <i class="exclusive-icon ml5"></i>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis">
                                                <a href="" target="_blank"><span>鸡翅</span></a>、
                                                <a href="" target="_blank"><span>可乐</span></a>、
                                                <a href="" target="_blank"><span>盐</span></a>、
                                                <a href="" target="_blank"><span>料酒</span></a>
                                            </p>
                                            <p class="stats">综合评分<span class="score bold green-font">8.2</span>&nbsp;&nbsp;（<span class="bold score">6000</span>做过）</p>
                                            <p class="author">
                                                <a href="" class="gray-font" target="_blank"><span>爱吃的兔子</span></a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <div class="pager">
                                <a href="#comehere" class="prev">上一页</a>
                                <a href="">1</a>
                                <a href="">2</a>
                                <a href="">3</a>
                                <a href="">4</a>
                                <a href="">5</a>
                                <a href="#comehere" class="next">下一页</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--right-panel-->

            <div class="pure-u-1-3 right-panel">
                <div class="block">
                    <div class="title-bar">
                        <div class="title">最新发布菜谱</div>
                    </div>
                    <div class="recipe-menus">
                        <div class="normal-recipe-list">
                            <ul class="list">
                                <!--循环11次-->
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="recipe recipe-150-horizontal pure-g image-link display-block">
                                        <a href="" data-click-tracking-url data-expose-tracking-url target="_blank">
                                            <div class="cover pure-u">
                                                <img src="images/Material/龙猫馒头.jpg" width="150" height="100">
                                            </div>
                                        </a>
                                        <div class="info pure-u">
                                            <p class="name">
                                                <a href="" data-click-tracking-url data-expose-tracking-url target="_blank"><span>龙猫馒头</span></a>
                                                <i class="step-icon ml5"></i>
                                            </p>
                                            <p class="ing ellipsis" >
                                                <a href="" target="_blank">面粉</a>
                                                <a href="" target="_blank">酵母</a>
                                                <a href="" target="_blank">砂糖</a>
                                            </p>
                                            <p class="author">
                                                <a href="" class="gray-font">茶米chami</a>
                                                <a href="" class="icon icon-cooker" target="_blank"></a>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!--循环11次-->
                    </div>
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