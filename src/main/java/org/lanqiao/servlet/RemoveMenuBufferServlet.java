package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @作者：dhc
 * @创建时间：17:10 2018/9/2
 * @描述：用来清空上一次上传菜谱保存的menuCoverPic和menuStepspic。
 */
@WebServlet("/RemoveMenuBufferServlet")
public class RemoveMenuBufferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("menuCoverPic");
        request.getSession().removeAttribute("menuStepsPic");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
