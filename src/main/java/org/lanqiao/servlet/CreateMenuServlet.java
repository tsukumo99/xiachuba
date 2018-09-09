package org.lanqiao.servlet;

import org.apache.commons.collections.map.HashedMap;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.Caipu;
import org.lanqiao.entity.User;
import org.lanqiao.service.Impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * @作者：dhc
 * @创建时间：15:29 2018/9/2
 * @描述：菜谱数据提交
 */
@WebServlet("/CreateMenuServlet")
public class CreateMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Caipu caipu = new Caipu();
        HttpSession session = request.getSession();
        String menuTitle = request.getParameter("menuTitle");
        String menuDescription = request.getParameter("menuDescription");
        String menuMaterial = request.getParameter("menuMaterial");
        String menuSteps = request.getParameter("menuSteps");
        int stepsNum = Integer.parseInt(request.getParameter("stepsNum"));
        //获得封面图
        String menuCoverPic = (String)session.getAttribute("menuCoverPic");
        String menuCover = "upload\\"+menuCoverPic.substring(menuCoverPic.indexOf("2"));
        //根据步骤数来获得步骤图片
        Map<Integer,String> stepCover = (HashedMap)session.getAttribute("menuStepsPic");
        String menuStepsCover = "";
        if(stepCover != null){
            for (int i = 1; i <= stepsNum; i++) {
                String temp = stepCover.get(i);
                //如果不是第一步，并且当前步骤图字符串最后一个不是‘|’,就加上这个分隔符
                if(i != 1){
                    menuStepsCover += "|";
                }
                if(temp != null){
                    menuStepsCover += "upload\\"+temp.substring(temp.indexOf("2"));
                }else{
                    menuStepsCover += " ";

                }
            }
        }else{
            for (int i = 1; i <= stepsNum; i++) {
                if(i != 1){
                    menuStepsCover += "|";
                }
                menuStepsCover += " ";
            }
        }

        User username = (User)session.getAttribute("sessionkey");
        //实现登录功能后改回来
        int uid = new UserDaoImpl().getIdByUsername(username.getU_name());

        //封装数据
        caipu.setU_id(uid);
        caipu.setC_name(menuTitle);
        caipu.setC_introduce(menuDescription);
        caipu.setC_made(menuMaterial);
        caipu.setC_step(menuSteps);
        caipu.setC_image(menuCover);
        caipu.setC_step_image(menuStepsCover);
        int re = new MenuServiceImpl().createMenu(caipu);

        PrintWriter out = response.getWriter();
        if(re == 1){
            out.write("success");
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
