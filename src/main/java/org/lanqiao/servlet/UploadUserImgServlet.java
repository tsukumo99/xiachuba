package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.lanqiao.dao.impl.UserDaoImpl;
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
 * Created by David on 2018/8/28.
 */
@WebServlet("/uploadUserImg")
public class UploadUserImgServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    /**
     * 上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> fileSrcList = UploadFile.upload(request);
        String img=fileSrcList.get(0);
        //String img=str.replace( "\\","\\\\" );
        User u=(User)request.getSession().getAttribute("sessionkey");
        int id=u.getU_id();

        User user=new User();
        user.setU_id(id);
        user.setU_image(img);
        int ret = new UserDaoImpl().addimg(user);
        //ReadVideo.readVideoTime(request.getServletContext().getRealPath("/")+fileSrcList.get(0));//获得影片时长
        JSONObject obj = new JSONObject();
        obj.put("errno",0);
        obj.put("data",JSONArray.fromObject(fileSrcList));

        response.getWriter().print(obj.toString());
    }
}
