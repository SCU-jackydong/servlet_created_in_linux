import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;



public class fiter implements Filter{
    public void init(FilterConfig config)throws ServletException{

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException{
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        if("madong".equals(name)&&"123456".equals(password)){
            chain.doFilter(request,response);
        }else {
            response.setContentType("text/html;charset=GBK");

            PrintWriter out =response.getWriter();
            out.print("<b>帐号或密码不对</b>");
        }
    }
}

