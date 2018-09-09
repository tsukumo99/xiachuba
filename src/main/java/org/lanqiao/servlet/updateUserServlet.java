package org.lanqiao.servlet;

import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String hometown = request.getParameter("hometown");
        String nowlive = request.getParameter("nowlive");
        String job = request.getParameter("job");
        String email = request.getParameter("email");
        String image = request.getParameter("image");
        String phone = request.getParameter("phone");
        String introduce = request.getParameter("introduce");
        String id =request.getParameter("id");

//        转换日期
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User  user = new User(Integer.parseInt(id),name,password,sex,date,hometown,nowlive,job,email,image,phone,introduce);

        UserDaoImpl userDao = new UserDaoImpl();
        int ret =  userDao.updateUserInfo(user);

        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
