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

@WebServlet("/getUserImageServlet")
public class getUserImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取数据
        String u_id=request.getParameter("u_id");
        //2.封装数据
        User u=new User();
        u.setU_id(Integer.parseInt(u_id));
        //3.dao
        UserDaoImpl usl=new UserDaoImpl();
        User u1=usl.getUserImage(u);
        String srcImage=u1.getU_image();
        //4.out
        response.getWriter().print(srcImage);
    }
}
