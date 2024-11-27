<%--
Document : login
Created on : Dec 12, 2022, 9:10:52 PM
--%>
48
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<% out.println("<html><body>");
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
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
flag=1;
}
}
49
if(flag==0)
{
out.println("<br><br>SORRY INVALID ID TRY AGAIN ID<br><br>");
out.println("<a href=\"login.html\">press LOGIN to RETRY</a>");
}
else
{ out.println("<br><br>VALID LOGIN ID<br><br>");
out.println("<h3><ul>");
}
out.println("</body></html>");
con.close();
%>
