package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.entity.User;
import org.lanqiao.queryclass.HomeFriendShow;
import org.lanqiao.service.Impl.AttentionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @作者：dhc
 * @创建时间：18:06 2018/8/29
 * @描述：首页加载时显示“下厨房的厨友们”模块的servlet
 */
@WebServlet("/ShowHomeFriendServlet")
public class ShowHomeFriendServlet extends HttpServlet {
    /**
     * 该方法调用
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("userBean");
        AttentionServiceImpl attentionServiceImpl = new AttentionServiceImpl();
        List<HomeFriendShow> ret;
        if(user != null){  //用户登录
            ret = attentionServiceImpl.getFriends(user.getU_id());
        }else{   //用户未登录
            ret = attentionServiceImpl.getFriends();
        }
        JSONArray retJson = JSONArray.fromObject(ret);
        response.getWriter().write(retJson.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
