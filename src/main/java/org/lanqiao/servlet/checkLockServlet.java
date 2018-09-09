package org.lanqiao.servlet;

import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkLockServlet")
public class checkLockServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取表单数据
        String username =request.getParameter("username");
        String password =request.getParameter("password");

        //2.封装数据
        User user = new User();
        user.setU_name(username);
        user.setU_password(password);

        //3.dao
        User retUser = new UserDaoImpl().checkLockUser(user);//用户所有属性

        if(retUser!=null){
            request.getSession().setAttribute("sessionkey",retUser);
            response.getWriter().print(true);
        }else{
            response.getWriter().print(false);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
