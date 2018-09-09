package org.lanqiao.servlet;

import org.lanqiao.dao.impl.CaipuDaoImpl;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @作者：dhc
 * @创建时间：10:15 2018/9/3
 * @描述：我的厨房页中菜谱数量显示
 */
@WebServlet("/MykitchenMenuNumServlet")
public class MykitchenMenuNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User s=(User)request.getSession().getAttribute("sessionkey");
        int menuNum = new CaipuDaoImpl().getMenuNum(new UserDaoImpl().getIdByUsername(s.getU_name()));
        response.getWriter().write(String.valueOf(menuNum));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
