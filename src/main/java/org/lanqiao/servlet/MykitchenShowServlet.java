package org.lanqiao.servlet;

import net.sf.json.JSONObject;
import org.lanqiao.entity.User;
import org.lanqiao.queryclass.KitchenShow;
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
 * @创建时间：9:51 2018/8/30
 * @描述：厨房页右上角页面加载时显示的servlet
 */
@WebServlet("/MykitchenShowServlet")
public class MykitchenShowServlet extends HttpServlet {
    /**
     * 给客户端传回当前厨房页是别人的还是自己的，关注人数、被关注人数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("userBean");
        String username = request.getParameter("uname");
        //登录功能实现后改回来
        //KitchenShow ks = new AttentionServiceImpl().getKitchenShowInfo(username,u.getU_name());
        KitchenShow ks = new AttentionServiceImpl().getKitchenShowInfo(username,"张三");
        JSONObject re = JSONObject.fromObject(ks);
        PrintWriter out = response.getWriter();
        out.write(re.toString());
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
