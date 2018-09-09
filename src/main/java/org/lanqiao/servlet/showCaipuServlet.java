package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.entity.Caipu;
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

@WebServlet("/showCaipuServlet")
public class showCaipuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        List<Caipu> list  = new CaipuDaoImpl().showCaipu(Integer.parseInt(num), 14);

        int CaipuCount = new CaipuDaoImpl().getAllCaipuCount();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
        JSONArray listarray = JSONArray.fromObject(list,jsonConfig);
        listarray.add(CaipuCount);
        PrintWriter out = response.getWriter();
        out.print(listarray.toString());
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
