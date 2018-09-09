package org.lanqiao.servlet;

import org.lanqiao.dao.impl.CollectionDaoImpl;
import org.lanqiao.entity.Caipu;
import org.lanqiao.entity.Collection;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/DeleteCollectionServlet")
public class DeleteCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u= (User) request.getSession().getAttribute("sessionkey");
        int u_id=u.getU_id();

        String c_id = request.getParameter("id");
        Collection collection = new Collection();
        collection.setC_id(Integer.parseInt(c_id));
        collection.setU_id(u_id);
        int ret = new CollectionDaoImpl().deleteCollection(collection);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
