package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @作者：dhc
 * @创建时间：10:35 2018/8/31
 * @描述：当用户点击某个a标签跳转到我的厨房页，将这个用户名存起来
 */
@WebServlet("/SetUnameServlet")
public class SetUnameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kitchenUname = request.getParameter("kitchenUname");
        request.getSession().setAttribute("kitchenUname",kitchenUname);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
