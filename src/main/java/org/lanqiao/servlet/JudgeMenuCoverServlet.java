package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @作者：dhc
 * @创建时间：14:44 2018/9/2
 * @描述：用户菜谱创建时验证封面是否存在
 */
@WebServlet("/JudgeMenuCoverServlet")
public class JudgeMenuCoverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menuCover = (String)request.getSession().getAttribute("menuCoverPic");
        PrintWriter out = response.getWriter();
        if(menuCover == null){
            out.write("fail");
        }else{
            out.write("pass");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
