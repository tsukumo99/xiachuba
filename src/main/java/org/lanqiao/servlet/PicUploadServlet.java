package org.lanqiao.servlet;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @作者：dhc
 * @创建时间：14:06 2018/9/1
 * @描述：
 * 1.该servlet用于创建菜谱页，创建菜谱页每次选择图片直接上传，上传到服务器后，将图片地址先保存到session，和上传所有文字时一起写入数据库，因为可能用户会删除已选图片。
 * 2.图片封面保存于：menuCoverPic中.
 * 3.图片步骤因不确定哪一步有图片，用map来保存，保存于menuStepsPic,key为步骤数，value为步骤图地址，无步骤图时
 * value值为空字符串“”。
 * 4.所有图片保存于upload文件夹
 * 5.把写入结果传给前端，成功才显示预览，否则提示(写回字符串"true"或"false")。
 * 6.前端传图的同时需要传一个标识name="flag"，用来表示是封面图还是步骤图，“0”为封面，其他为步骤（前端用一个name为flag的隐藏input标签来实现）
 * 7.在这里保存步骤图，注意在创建菜谱的servlet需要进行处理，循环获得某一个步骤的图，如果获得是空，该步骤路径置为空字符串。
 */
@WebServlet("/PicUploadServlet")
public class PicUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //判断upload文件夹是否存在，不存在则创建
        String uploadPath = request.getServletContext().getRealPath("/") + "upload";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } // 解析request请求
        /**
         * 不仅接受图片并保存，还需要接受标识（标识是菜谱封面还是步骤数）
         * flag为0表示菜谱封面，其他为步骤
         */
        String flag = "";
        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()) { // 如果是表单域 ，就是非文件上传元素
                String value = item.getString("UTF-8"); // 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
                if (item.getFieldName().equals("flag")) {// 对应form中属性的名字
                    flag = value;
                }
            } else {
                try {
                    //对文件名进行日期处理
                    String fileName = new File(item.getName()).getName();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmsssss");
                    fileName = simpleDateFormat.format(new Date()) + (int) (Math.random() * 1000) + fileName.substring(fileName.lastIndexOf("."));

                    String savePath = uploadPath + File.separator + fileName;
                    System.out.println(savePath);
                    //写入upload文件夹下
                    File saveFile = new File(savePath);
                    item.write(saveFile);// 把上传的内容写到一个文件中
                    //将文件存储路径写入session中
                    //String savePath = filePath.substring(filePath.indexOf("upload"), filePath.length());
                    if ("0".equals(flag)) { //传过来的是封面
                        //还需要先取出menuCoverPic的值，看是否存在，如果存在则证明是用户重新上传封面，需要先删除原来封面文件
                        //在这里也不做删除，而是每次上传前先访问PicDeleteServlet,如果已经存在封面图就把封面图删了
                        request.getSession().setAttribute("menuCoverPic", savePath);
                    } else {//传过来的是步骤数
                        int stepsNum = Integer.parseInt(flag);
                        //先取出存步骤图的map
                        Map<Integer, String> steps = (HashedMap) request.getSession().getAttribute("menuStepsPic");
                        if(steps == null){
                            steps = new HashedMap();
                        }
                        //还需先判断steps中是否存在key为stepsNum，如果存在则证明用户重新选择了步骤图，那么还需要删除对应的图片
                        //在这里不做删除，在前端每次选择步骤图时，先访问PicDeleteServlet,删除原来的步骤图（如果存在的话）
                        steps.put(stepsNum, savePath);
                        System.out.println(steps.get(1));
                        request.getSession().setAttribute("menuStepsPic", steps);
                    }
                    out.write(flag);
                } catch (Exception e) {
                    out.write("false");
                    System.out.println("文件为空");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
