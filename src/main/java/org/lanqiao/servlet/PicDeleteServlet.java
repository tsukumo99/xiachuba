package org.lanqiao.servlet;

import org.apache.commons.collections.map.HashedMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.PrinterGraphics;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @作者：dhc
 * @创建时间：9:51 2018/9/2
 * @描述：这个servlet用于删除步骤时，如果这个步骤已经选择了步骤图，就需要将服务器的这个步骤图删了，同时将session中对应的属性值
 * 删了，（同时还用于在重新选择封面和步骤图时，删除原来的的封面图和步骤图）
 */
@WebServlet("/PicDeleteServlet")
public class PicDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //前端传过来name=flag的标识，
        //“0”标识封面图，这时首先去session取menuCoverPic,如果为空，什么都不做，如果有值，删除这个图片，并移出session中这个属性
        //“123...”标识步骤图，到menuStepPic这个map中去取key为这个flag的值，如果取不到，什么都不做，取到了，删除对应图片，并将这个
        //key，value对删了
        String flag = request.getParameter("flag");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        File file = null;
        if("0".equals(flag)){
            String menuCoverPic = (String)session.getAttribute("menuCoverPic");
            if(menuCoverPic != null){
                //移出session属性menuCoverPic
                session.removeAttribute("menuCoverPic");
                //删除文件
                file = new File(menuCoverPic);

            }
        }else{
            int f = Integer.parseInt(flag);
            Map<Integer,String> step = (HashedMap)session.getAttribute("menuStepsPic");
            //该步骤已经有图了，
            String filePath = null;
            if(step != null){
                filePath = step.get(f);
            }
            if(filePath != null){
                //移除这个步骤，重新给menuStepPic赋值
                step.remove(f);
                session.removeAttribute("menuStepPic");
                session.setAttribute("nemuStepPic",step);
                //删除文件
                file = new File(filePath);
                }
            }
        if(file == null || file.delete()){
            out.write("deleteSuccess");
            System.out.println("delete success");
        }else {
            out.write("deleteFail");
            System.out.println("delete fail");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
