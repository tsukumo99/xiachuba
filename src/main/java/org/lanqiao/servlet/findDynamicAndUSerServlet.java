package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.impl.DynamicAndUserDaoImpl;
import org.lanqiao.entity.DynamicAndUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findDynamicAndUSerServlet")
public class findDynamicAndUSerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 DynamicAndUser
        DynamicAndUserDaoImpl d=new DynamicAndUserDaoImpl();
        List<DynamicAndUser> list=d.findAllDynamicAndUser();

        //将动态转为数组，再转为字符串
        JSONArray array = JSONArray.fromObject(list);
        String jsonstr = array.toString();

        //将字符串发送到前端
        response.getWriter().print(jsonstr);

    }
}
