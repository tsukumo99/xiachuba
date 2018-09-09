package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.queryclass.MykitchenMenuShow;
import org.lanqiao.service.Impl.MenuServiceImpl;
import org.lanqiao.service.Impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @作者：dhc
 * @创建时间：9:33 2018/9/3
 * @描述：用于我的厨房中菜谱的显示，传回的数据是一个List<MykitchenMenuShow>
 */
@WebServlet("/MychitchenMenuShowServlet")
public class MychitchenMenuShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kitchenUsername = request.getParameter("kitchenUsername");
        PrintWriter out = response.getWriter();
        out.write(new MenuServiceImpl().listMykitchenMenu(kitchenUsername));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
