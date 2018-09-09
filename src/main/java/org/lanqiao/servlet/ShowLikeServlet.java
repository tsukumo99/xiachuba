package org.lanqiao.servlet;

import org.lanqiao.dao.impl.LikeDaoImpl;
import org.lanqiao.entity.Likes;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowLikeServlet")
public class ShowLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getSession().getAttribute("sessionkey");
        int id=user.getU_id();

       int dId=Integer.parseInt(request.getParameter("d_id"));

        Likes likes=new Likes();
        likes.setU_id(id);
        likes.setD_id(dId);
        //dao操作
        List<Likes> list=new LikeDaoImpl().getUserLikes(likes);
        PrintWriter out=response.getWriter();
        out.print(list);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
