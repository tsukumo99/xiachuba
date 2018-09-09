package org.lanqiao.servlet;

import org.lanqiao.entity.User;
import org.lanqiao.service.Impl.AttentionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @作者：dhc
 * @创建时间：22:58 2018/8/29
 * @描述：关注按钮点击时增加关注或者取消关注的servlet
 */
@WebServlet("/AttentionServlet")
public class AttentionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //标记是取消还是增加关注
        String attentionFlag = request.getParameter("attentionFlag");
        //被关注人
        String Uname = request.getParameter("Uname");
        System.out.println(Uname+" "+attentionFlag);
        User u = (User)request.getSession().getAttribute("userBean");
        //有登录功能时换回来！！！！！！！
        //int re = new AttentionServiceImpl().addOrDeleteAttenttion(Uname,u.getU_id(),attentionFlag);
        int re = new AttentionServiceImpl().addOrDeleteAttenttion(Uname,1,attentionFlag);
        System.out.println(re);
        PrintWriter out = response.getWriter();
        out.write(String.valueOf(re));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
