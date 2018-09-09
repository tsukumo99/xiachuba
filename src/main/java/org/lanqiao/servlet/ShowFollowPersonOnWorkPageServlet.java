package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.queryclass.HomeFriendShow;
import org.lanqiao.service.Impl.AttentionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @作者：dhc
 * @创建时间：9:06 2018/8/31
 * @描述：当用户登录时，如果用户未关注任何用户，在作品动态页我关注的更新下显示数据库前3条用户数据显示
 */
@WebServlet("/ShowFollowPersonOnWorkPageServlet")
public class ShowFollowPersonOnWorkPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("userBean");
        List<HomeFriendShow> ret = new AttentionServiceImpl().getWorkDynamicFollowPerson(user);
        JSONArray retJson = JSONArray.fromObject(ret);
        PrintWriter out = response.getWriter();
        out.write(retJson.toString());
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
