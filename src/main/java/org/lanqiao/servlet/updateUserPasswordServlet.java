package org.lanqiao.servlet;

import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateUserPasswordServlet")
public class updateUserPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从session中获取当前登录用户的ID
        //User user = (User) request.getSession().getAttribute("userBean");
        User user=(User)request.getSession().getAttribute("sessionkey");
        int id=user.getU_id();
        //封装数据
        User u=new User();
        u.setU_id(id);

        String password=request.getParameter("password");
        u.setU_password(password);
        //dao操作
        int ret=new UserDaoImpl().alterPassword(u);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request, response);
    }
}
