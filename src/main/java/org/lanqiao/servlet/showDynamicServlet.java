package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.DynamicDaoImpl;
import org.lanqiao.entity.Dynamic;
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

@WebServlet("/showDynamicServlet")
public class showDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        List<Dynamic> list = new DynamicDaoImpl().showDynamic(Integer.parseInt(num),14);
        int CountDynamic = new DynamicDaoImpl().getAllDynamicCount();

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());

        JSONArray listArray = JSONArray.fromObject(list,jsonConfig);
        listArray.add(CountDynamic);
        PrintWriter out = response.getWriter();
        out.print(listArray.toString());
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
