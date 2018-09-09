package org.lanqiao.servlet;

import org.lanqiao.dao.impl.LiuyanDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/deleteMsg")
public class deleteMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int  l_id=Integer.parseInt(request.getParameter("msgId"));
            int  userId =new  LiuyanDaoImpl().QueryU_idByMsgid(l_id);

            User user =(User)request.getSession().getAttribute("sessionkey");
            int u_id=user.getU_id();

              boolean flag=false;
              if(userId==u_id){
                   int ret= new  LiuyanDaoImpl().deleteLiuyan(l_id);
                   if(ret==1){
                       flag=true;
                   }
               }
            PrintWriter out=response.getWriter();
            out.print(flag);
            out.flush();
            out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
