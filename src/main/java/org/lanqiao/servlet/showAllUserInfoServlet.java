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

@WebServlet("/showAllUserInfoServlet")
public class showAllUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String num = request.getParameter("num");
            List<User> list = new UserDaoImpl().showAllUserInfo(Integer.parseInt(num), 14);

            int UserCount = new UserDaoImpl().CountUser();

            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());

            JSONArray aug = JSONArray.fromObject(list,jsonConfig);

            aug.add(UserCount);

            PrintWriter out = response.getWriter();
            out.print(aug.toString());
            out.flush();
            out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
