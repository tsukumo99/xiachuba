package miaodiyun.huiDiao;

import miaodiyun.httpApiDemo.IndustrySMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("phone");
        IndustrySMS.execute(str);


        String yzm = IndustrySMS.smsContent;
        PrintWriter out = response.getWriter();
        out.print(yzm);
        out.flush();
        out.close();
//        try {
//            IndustrySMS.execute(str);
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
