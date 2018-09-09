package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
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
import java.util.List;

@WebServlet("/ShowCollectionServlet")
public class ShowCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u= (User) request.getSession().getAttribute("sessionkey");
        int u_id=u.getU_id();

        Caipu c=new Caipu();
        c.setU_id(u_id);

        //dao操作
        List<Caipu> list = new CollectionDaoImpl().showCollection(c);
        JsonConfig jsonConfig = new JsonConfig();
        //输出结果
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
