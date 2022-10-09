
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/zhuce")
public class zhuce extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/servlet66?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    static final String USER="root";
    static final String PASS ="Madong1314.com";

    public zhuce(){
        super();
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String account=request.getParameter("account");
        String password=request.getParameter("password");


        Connection connection =null;
        Statement statement =null;
        response.setContentType("text/html;charset=UTF-8");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("数据库连接成功");

            statement = connection.createStatement();
            System.out.println(name);
            String sql="INSERT into tb1 (name,age,account,password) VALUE ('" +
                    name +
                    "' , "+
                    age +
                    ", '" +
                    account +
                    "','" +
                    password +
                    "');";

            System.out.println(sql);

            statement.execute(sql);



            statement.close();
            connection.close();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("madong:20");
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int a =666;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String account=request.getParameter("account");
        String password=request.getParameter("password");


        Connection connection =null;
        Statement statement =null;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("数据库连接成功");

            statement = connection.createStatement();

            String aa ="select account from tb1;";
            ResultSet rs = statement.executeQuery(aa);

            while(rs.next()) {
                // 通过字段检索

                String account1 = rs.getString("account");
                if(account.equals(account1))
                {
                      a =777;
                    out.print("帐号已经被注册");
                   // String site = new String("http://10.0.0.222:8080/zhuce.html");
                   // response.setStatus(response.SC_MOVED_TEMPORARILY);
                    //response.setHeader("Location", site);
                      break;
                }

            }

                String sql="INSERT into tb1 (name,age,account,password) VALUE ('" +
                    name +
                    "' , "+
                    age +
                    ", '" +
                    account +
                    "','" +
                    password +
                    "');";


            if(a==666)
            {
                statement.execute(sql);
                out.print("注册成功");
               // String site = new String("http://10.0.0.222:8080/login.html");
               // response.setStatus(response.SC_MOVED_TEMPORARILY);
                //response.setHeader("Location", site);
            }
            else {

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
