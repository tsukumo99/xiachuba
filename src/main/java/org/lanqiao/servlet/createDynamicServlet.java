package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.lanqiao.dao.impl.DynamicDaoImpl;
import org.lanqiao.entity.Dynamic;
import org.lanqiao.entity.User;
import org.lanqiao.util.UploadFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 插入动态数据与UploadDynamicImagesServlet一起
 * 刘志辉
 */
@WebServlet("/createDynamicServlet")
public class createDynamicServlet extends HttpServlet {
    static String xinde;
    static int c_id;
    static int u_id;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取数据
        xinde=request.getParameter("xinde");
        c_id=Integer.parseInt(request.getParameter("c_id"));
        User user = (User) request.getSession().getAttribute("sessionkey");
        u_id=user.getU_id();



    }
}
