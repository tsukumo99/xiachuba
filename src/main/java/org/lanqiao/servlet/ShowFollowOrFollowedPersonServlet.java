package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
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
 * @创建时间：17:18 2018/8/30
 * @描述：用于我的厨房页中点击关注人数和被关注人数数字点击时显示的servlet
 */
@WebServlet("/ShowFollowOrFollowedPersonServlet")
public class ShowFollowOrFollowedPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kitchenUsername = request.getParameter("kitchenUsername");
        int uid = new UserDaoImpl().getIdByUsername(kitchenUsername);
        String flag = request.getParameter("flag");
        System.out.println(flag);
        System.out.println(kitchenUsername);
        List<User> ret = new AttentionServiceImpl().getKitchenFollowOrFollowedPersion(uid,flag);
        JSONArray retJson = JSONArray.fromObject(ret);
        PrintWriter out = response.getWriter();
        out.write(retJson.toString());
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
