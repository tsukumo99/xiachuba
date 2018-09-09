package org.lanqiao.servlet;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insertUserInfo")
public class insertUserInfoServlet extends javax.servlet.http.HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得表单数据
        String u_name =request.getParameter("username");
        String u_phone =request.getParameter("phone");
        String u_password =request.getParameter("password");
        //2.封装对象
        User user = new User();
        user.setU_name(u_name);
        user.setU_phone(u_phone);
        user.setU_password(u_password);
        //3.dao操作
        int ret= new UserDaoImpl().insertUesrInfo(user);
        //4.输出结果
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
