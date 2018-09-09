package org.lanqiao.servlet;

import org.lanqiao.dao.impl.LikeDaoImpl;
import org.lanqiao.entity.Likes;
import org.lanqiao.entity.User;
import org.lanqiao.service.Impl.LikeServiceImpl;
import org.lanqiao.service.LikeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户id
        //User user = (User) request.getSession().getAttribute("userBean");
        User user=(User)request.getSession().getAttribute("sessionkey");
        int u_id=user.getU_id();
        int d_id=Integer.parseInt(request.getParameter("d_id"));
        String flag=request.getParameter("flag");

       int ret= new LikeServiceImpl().addOrCancelLike(flag,u_id,d_id);
        //输出结果
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
