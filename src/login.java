import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/login")
public class login extends HttpServlet {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/servlet66?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    static final String USER="root";
    static final String PASS ="Madong1314.com";

    public login(){
        super();
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int a=666;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection connection =null;
        Statement statement =null;

        String account=request.getParameter("account");
        String password=request.getParameter("password");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("数据库连接成功");
System.out.println(account);
            statement = connection.createStatement();

            String aa ="select account,password from tb1;";
            ResultSet rs = statement.executeQuery(aa);

            while(rs.next()) {
                // 通过字段检索
                String password1=rs.getString("password");
                String account1 = rs.getString("account");
                if(account.equals(account1)&&password1.equals(password))
                {
                    a=777;

                }


            }
            if(a==666){
                out.print("帐号或密码不对");
                String site1 = new String("http://10.0.0.222:8080/login.html");
               // response.setStatus(response.SC_MOVED_TEMPORARILY);
                //response.setHeader("Location", site1);
            }
            else {
                out.print("登录成功");
               // String site = new String("http://10.0.0.222:8080/main_UI.html");

                //response.setStatus(response.SC_MOVED_TEMPORARILY);
               // response.setHeader("Location", site);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(connection!=null)
                    connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
