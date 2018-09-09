package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.PinglunAndUserDaoImpl;
import org.lanqiao.entity.PinglunAndUser;
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

@WebServlet("/findPinglunByDidServlet")
public class findPinglunByDidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_id=request.getParameter("d_id");

        PinglunAndUser p=new PinglunAndUser();
        p.setD_id(Integer.parseInt(d_id));

        //dao
        PinglunAndUserDaoImpl d=new PinglunAndUserDaoImpl();

        List<PinglunAndUser> list=d.findPinglunByd_id(Integer.parseInt(d_id));
        System.out.println(list.get(0).getP_content());

        //out
//        JSONArray jsonArray=JSONArray.fromObject(list);
//        response.getWriter().print(jsonArray);

        //out
        //处理时间
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());

        PrintWriter out =response.getWriter();
        JSONArray jsonArray=JSONArray.fromObject(list,jsonConfig);

        out.print(jsonArray);
        out.flush();
        out.close();


    }
}
