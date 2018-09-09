package org.lanqiao.servlet;

import org.lanqiao.dao.impl.CollectionDaoImpl;
import org.lanqiao.entity.Collection;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddCollectionServlet")
public class AddCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得数据
        User u= (User) request.getSession().getAttribute("sessionkey");
        int u_id=u.getU_id();
//        String uid =request.getParameter("userid");
        String cid =request.getParameter("c_id");


        //2.封装对象
        Collection c = new Collection();
        c.setU_id(u_id);
        c.setC_id(Integer.parseInt(cid));



        //3.dao操作
        int ret= new CollectionDaoImpl().addCollection(c);

//        request.setAttribute("ret",ret);
//
//        request.getSession().setAttribute("ret",ret);
//        request.getRequestDispatcher("Showstep.jsp").forward(request,response);

//        //4.输出结果
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
