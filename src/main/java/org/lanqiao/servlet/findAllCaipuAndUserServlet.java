package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.CaipuAndUserDaoImpl;
import org.lanqiao.entity.CaipuAndUser;
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

@WebServlet( "/findAllCaipuAndUserServlet")
public class findAllCaipuAndUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CaipuAndUserDaoImpl cau=new CaipuAndUserDaoImpl();
        List<CaipuAndUser> list=cau.findAllCaipuAndUser();

        //处理时间
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());

        //4.json发送到前端
        PrintWriter out =response.getWriter();
        JSONArray jsonArray=JSONArray.fromObject(list,jsonConfig);

        out.print(jsonArray);
        out.flush();
        out.close();

    }
}
