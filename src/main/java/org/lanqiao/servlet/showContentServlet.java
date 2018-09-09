package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.LiuyanDaoImpl;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Liuyan;
import org.lanqiao.entity.ShowMsg;
import org.lanqiao.entity.User;
import org.lanqiao.entity.ShowMsg;
import org.lanqiao.service.MsgServiceImpl;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/showContent")
public class showContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String otherName=request.getParameter("otherName");

        List<ShowMsg> list =new MsgServiceImpl().showMsg( otherName);
        String jsonArray=JSONArray.fromObject(list).toString();
        PrintWriter out=response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
