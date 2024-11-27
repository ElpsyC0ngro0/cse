/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
41
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class login extends HttpServlet {
/**
* Processes requests for both HTTP
* <code>GET</code> and
* <code>POST</code> methods.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
public void service(HttpServletRequest req,HttpServletResponse resp)
throws ServletException,IOException
{
PrintWriter pw=resp.getWriter();
pw.println("<html><body>");
String id=req.getParameter("id");
String pwd=req.getParameter("pwd");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection
con=DriverManager.getConnection("jdbc:oracle:thin:@172.16.53.70:1521:orcl","exam1","exam1");
Statement stmt=con.createStatement();
String sqlstmt="select id,pwd from login";
ResultSet rs=stmt.executeQuery(sqlstmt);
int flag=0;
while(rs.next())
{
if(id.equals(rs.getString(1))&&pwd.equals(rs.getString(2)))
{
42
flag=1;
}
}
if(flag==0)
{
pw.println("<br><br>SORRY INVALID ID TRY AGAIN ID<br><br>");
pw.println("<a href=\"login.html\">press LOGIN to RETRY</a>");
}
else
{
pw.println("<br><br>VALID LOGIN ID<br><br>");
pw.println("<h3><ul>");
}
pw.println("</body></html>");
}
catch(Exception e)
{
resp.sendError(500,e.toString());
}
}
}
