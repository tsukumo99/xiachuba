package org.lanqiao.servlet;

import org.lanqiao.dao.impl.DynamicDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取所有动态记录数
 * 刘志辉
 */
@WebServlet("/getAllDynamicCountServlet")
public class getAllDynamicCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DynamicDaoImpl ddl=new DynamicDaoImpl();
        int count=ddl.getAllDynamicCount();
        response.getWriter().print(count);

    }
}
