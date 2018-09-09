package org.lanqiao.servlet;

import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.dao.impl.DynamicDaoImpl;
import org.lanqiao.entity.Caipu;
import org.lanqiao.entity.Dynamic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteDynamicServlet")
public class deleteDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  id = request.getParameter("did");
        Dynamic d = new Dynamic();
        d.setD_id(Integer.parseInt(id));
        DynamicDaoImpl dynamicDao = new DynamicDaoImpl();
        int ret = dynamicDao.deleteDynamic(d);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
