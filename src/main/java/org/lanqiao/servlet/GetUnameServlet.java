package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @作者：dhc
 * @创建时间：10:36 2018/8/31
 * @描述：供我的厨房页加载时取出当前厨房页的用户的用户名
 */
@WebServlet("/GetUnameServlet")
public class GetUnameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kitchenUname = (String)request.getSession().getAttribute("kitchenUname");
        PrintWriter out = response.getWriter();
        out.write(kitchenUname);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
