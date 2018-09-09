package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.entity.Caipu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SearchC_name")
public class searchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                //     获取数据
                String keyword=request.getParameter("keyword");
                System.out.println(keyword);
                //     调Dao的实现类
                List<Caipu> list = new CaipuDaoImpl().searchC_nameQuery(keyword);
                JSONArray jsonArray=JSONArray.fromObject(list);
                PrintWriter out=response.getWriter();
                out.print(jsonArray);
                out.flush();
                out.close();

            }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
