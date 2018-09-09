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

@WebServlet("/deleteUserInfoServlet")
public class deleteUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userid");
        User user = new User();
        user.setU_id(Integer.parseInt(id));

        int  ret =  new UserDaoImpl().deleteUserInfo(user);

        PrintWriter out = response.getWriter();

        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
