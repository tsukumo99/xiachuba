package org.lanqiao.servlet;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @作者：dhc
 * @创建时间：17:05 2018/8/29
 * @描述：客户端获取到保存到Session中登录用户User对象的Servlet
 */
@WebServlet("/GetSessionServlet2")
public class GetSessionServlet2 extends HttpServlet {
    /**
     * 登录获取到用户对象json类型字符串，未登录获得null
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nolog = "nologin";
        //String key = request.getParameter("userBean");
        //System.out.println(key);
        User user = (User) request.getSession().getAttribute("userBean");
        PrintWriter out = response.getWriter();
        if(user != null){
            JSONObject retUser = JSONObject.fromObject(user);
            out.write(retUser.toString());
        }else{
            out.write(nolog);
            out.close();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
