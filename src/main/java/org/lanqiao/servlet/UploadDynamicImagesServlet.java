package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.lanqiao.dao.impl.DynamicDaoImpl;
import org.lanqiao.entity.Dynamic;
import org.lanqiao.util.UploadFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 刘志辉 on 2018/8/28.
 * 与createDynamicServlet一起插入动态数据
 */
@WebServlet("/uploadImage")
public class UploadDynamicImagesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * 上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取图片路径
        List<String> fileSrcList = UploadFile.upload(request);
        String   srcImage=fileSrcList.get(0);

        //封装数据
        Dynamic d=new Dynamic();
        d.setD_image(srcImage);
        d.setD_xinde(createDynamicServlet.xinde);
        d.setU_id(createDynamicServlet.u_id);//因为登陆注册没做好，所以先写死！！
        d.setC_id(createDynamicServlet.c_id);

        //dao
        DynamicDaoImpl ddl=new DynamicDaoImpl();
        int ret=ddl.createDynamic(d);

        //ReadVideo.readVideoTime(request.getServletContext().getRealPath("/")+fileSrcList.get(0));//获得影片时长
        //out
        JSONObject obj = new JSONObject();
        obj.put("errno",0);
        obj.put("data", JSONArray.fromObject(fileSrcList));
        response.getWriter().print(obj.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
