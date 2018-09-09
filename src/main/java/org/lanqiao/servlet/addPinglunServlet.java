package org.lanqiao.servlet;

import org.lanqiao.dao.impl.PinglunDaoImpl;
import org.lanqiao.entity.Pinglun;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/addPinglunServlet")
public class addPinglunServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_content=request.getParameter("p_content");//评论内容
        String p_time=request.getParameter("p_time");//评论时间

        //将p_time转为date
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=null;
        try {
            date=sDateFormat.parse(p_time);
        }
        catch(Exception e){
            System.out.println("时间转换错误！！");
        }

        String did=request.getParameter("d_id");//评论的动态
        int d_id=Integer.parseInt(did);
        User u=(User)request.getSession().getAttribute("sessionkey");
        int u_id=u.getU_id();

        //封装
        Pinglun pl=new Pinglun();
        pl.setP_content(p_content);
        pl.setD_id(d_id);
        pl.setU_id(u_id);
        pl.setP_time(date);


        PinglunDaoImpl pld=new PinglunDaoImpl();
        int i= pld.addPinglun(pl);

        response.getWriter().print(i);


    }
}
