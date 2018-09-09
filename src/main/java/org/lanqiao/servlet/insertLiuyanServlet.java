package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.entity.User;
import org.lanqiao.entity.ShowMsg;
import org.lanqiao.service.MsgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet( "/insertLiuyan")
public class insertLiuyanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg=request.getParameter("l_content");
        String otherName=request.getParameter("otherName");
//       u_name,u_image在session中获取

//        User user=new User();
//        user.setU_id(1);
//        user.setU_name("张三");
//        user.setU_image("upload\\galiStep2.jpg");
        User user =(User) request.getSession().getAttribute("sessionkey");
        ShowMsg showMsg=new MsgServiceImpl().insertMsg(msg, otherName,user);
        JSONArray jsonArray=new JSONArray().fromObject(showMsg);
        PrintWriter out=response.getWriter();
        out.print(jsonArray );
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
