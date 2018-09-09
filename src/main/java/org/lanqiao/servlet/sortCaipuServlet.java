package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.CaipuAndUserDaoImpl;
import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.entity.Caipu;
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

@WebServlet("/sortCaipuServlet")
public class sortCaipuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String sortfield=request.getParameter("sortfield");
        String pageNumber=request.getParameter("pageNumber");
        String pageSize=request.getParameter("pageSize");

        System.out.println(sortfield);
        System.out.println(pageNumber);
        System.out.println(pageSize);
        //2.封装数据

        //3.Dao
        CaipuAndUserDaoImpl cau=new CaipuAndUserDaoImpl();
        List<CaipuAndUser> list= cau.findAllCaipuAndUserSort(sortfield,Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
        int count=cau.getAllCaipuAndUserCount();//菜谱记录数

//        CaipuDaoImpl cdl=new CaipuDaoImpl();
//        List<Caipu> list= cdl.findAllCaipuAndSort(sortfield,Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
//        int count=cdl.getAllCaipuCount();//菜谱记录数

        //处理时间
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());

        //4.json发送到前端
        PrintWriter out =response.getWriter();
        JSONArray jsonArray=JSONArray.fromObject(list,jsonConfig);

        jsonArray.add(count);//将菜谱记录数封装进数组中

        out.print(jsonArray);
        out.flush();
        out.close();


    }
}
