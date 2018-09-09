package org.lanqiao.servlet;

import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.entity.Caipu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteCaipuServlet")
public class deleteCaipuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  id = request.getParameter("cid");

        Caipu c = new Caipu();
        c.setC_id(Integer.parseInt(id));

        CaipuDaoImpl caipuDao = new CaipuDaoImpl();
        int ret = caipuDao.deleteCaipu(c);

        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
