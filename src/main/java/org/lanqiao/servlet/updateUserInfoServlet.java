package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.Impl.SetPersonalInfoServiceImpl;
import org.lanqiao.service.SetPersonalInfoService;
import org.lanqiao.util.JsonDateValueProcessor;
import org.lanqiao.util.StringToDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/updateUserInfoServlet")
public class updateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从session中获取当前登录用户的ID
         //User user = (User) request.getSession().getAttribute("userBean");
        // int id= user.getU_id();
        User user=(User)request.getSession().getAttribute("sessionkey");
        int id=user.getU_id();
        String name=request.getParameter("name");
        String sex =request.getParameter("sex");
          //String   date = request.getParameter("date");
         String hometown = request.getParameter("hometown");

         if(hometown.equals("请选择-请选择")){
             hometown=null;
         }
        String nowlive = request.getParameter("nowlive");
        if(nowlive.equals("请选择-请选择")){
           nowlive=null;
        }
         String job = request.getParameter("job");
        if(job.equals("请选择")){
            job=null;
        }
         String email = request.getParameter("email");
        String introduce=request.getParameter("introduce");
        //从前端转
        String birthday=request.getParameter("birthday");
        Date birthday1 = StringToDate.StrToDate(birthday);

        //2.封装数据
        User upUser =new User(id,name,sex,hometown,nowlive,job,email,introduce,birthday1);
        System.out.println(upUser.getU_introduce());
        //调service
        //new SetPersonalInfoServiceImpl();
        //int ret=new SetPersonalInfoServiceImpl().alterUser(upUser);
        int ret=new SetPersonalInfoServiceImpl().alterUser(upUser);


        //输出结果
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }
}
