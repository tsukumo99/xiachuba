package org.lanqiao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 字符集过滤器
 * @author  LZH
 */
@WebFilter("/*")
public class characterFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //前驱操作
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("filter");
        chain.doFilter(req, resp);
        //后继操作


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
