package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet( "/GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("userBean");
        User user=(User)request.getSession().getAttribute("sessionkey");
        int id=user.getU_id();

        User u=new User();
        u.setU_id(id);
        //dao操作
        List<User> list=new UserDaoImpl().getUserInfo(u);

        JsonConfig jsonConfig=new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());//转换date类型
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);

        PrintWriter out=response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
