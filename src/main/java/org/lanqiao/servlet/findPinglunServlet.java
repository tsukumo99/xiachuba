package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.PinglunAndUserDaoImpl;
import org.lanqiao.dao.impl.PinglunDaoImpl;
import org.lanqiao.entity.Pinglun;
import org.lanqiao.entity.PinglunAndUser;
import org.lanqiao.entity.User;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/findPinglunServlet")
public class findPinglunServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_id=request.getParameter("d_id");//当前动态
//        String u_id=request.getParameter("u_id");//当前用户，session获得
        String p_time=request.getParameter("p_time").trim();//发表评论的时间
        User u=(User)request.getSession().getAttribute("sessionkey");
        int u_id=u.getU_id();

        System.out.println(p_time);
        //将时间转为date
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=null;
        try {
             date=sDateFormat.parse(p_time);
        }
        catch(Exception e){
            System.out.println("时间转换错误！！");
        }

        //封装数据
        PinglunAndUser pl=new PinglunAndUser();
        pl.setD_id(Integer.parseInt(d_id));
        pl.setU_id(u_id);
        pl.setP_time(date);

        //dao
        PinglunAndUserDaoImpl pldi=new PinglunAndUserDaoImpl();
        List<PinglunAndUser> list= pldi.findPinglun(pl);
        System.out.println(list.get(0).getU_image());

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
