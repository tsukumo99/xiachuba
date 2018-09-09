package org.lanqiao.servlet;

import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.entity.Caipu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getCaipuMessageServlet")
public class getCaipuMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取菜名
        String c_name=request.getParameter("c_name");

        //超链接传值要控制字符编码
        c_name= new String(c_name.getBytes("ISO-8859-1"),"utf-8");
        //封装数据
        Caipu cp=new Caipu();
        cp.setC_name(c_name);
        //dao,根据菜名 查出菜的记录
        CaipuDaoImpl caipuDaoImpl=new CaipuDaoImpl();
        List<Caipu> list=caipuDaoImpl.findCaipuByfield(cp);
        System.out.println(list.get(0).getC_name());

        request.setAttribute("Caipulist",list);

        //out
        request.getRequestDispatcher("Showstep.jsp").forward(request,response);
    }
}
