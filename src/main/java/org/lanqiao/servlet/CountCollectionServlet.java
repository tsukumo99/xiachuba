package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.CollectionDaoImpl;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Collection;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CountCollectionServlet")
public class CountCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u= (User) request.getSession().getAttribute("sessionkey");
        int u_id=u.getU_id();

        CollectionDaoImpl collectionDaoImpl = new CollectionDaoImpl();
        String s = "SELECT COUNT(*) FROM  Collection WHERE u_id = "+u_id;

        int count = collectionDaoImpl.getCollectionCount(s);
        PrintWriter out = response.getWriter();
        out.print(count);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
