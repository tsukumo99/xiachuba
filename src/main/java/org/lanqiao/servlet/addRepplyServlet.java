package org.lanqiao.servlet;

import org.lanqiao.dao.impl.ReplyDaoImpl;
import org.lanqiao.entity.Reply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addRepplyServlet")
public class addRepplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String r_content=request.getParameter("r_content");
            String p_id=request.getParameter("p_id");//评论id
            String u_id=request.getParameter("u_id");//当前用户id
            String o_id=request.getParameter("o_id");//要回复的对象的id


            Reply r=new Reply();
            r.setR_content(r_content);
            r.setP_id(Integer.parseInt(p_id));
            r.setU_id(Integer.parseInt(u_id));
            r.setO_id(Integer.parseInt(o_id));

            ReplyDaoImpl rdl=new ReplyDaoImpl();
            rdl.addReply(r);

            response.getWriter().print(rdl);

    }
}
