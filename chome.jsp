<%-- 
    Document   : chome
    Created on : sep 20, 2020, 11:15:36 PM
    Author     : User
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
<title>Client Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
        <style>
            table, tr, td {
  border: 5px solid white;
  color:white;
  font-size: 30px;
}
        </style>
</head>
<body>
<div class="header">
<div class="header_wrapper">
	<div class="wrap">
<div class="header_top">
<div class="logo">
<img src="images/logo.png" alt="" />
</div><br><br><div>
					<span class="login100-form-title p-b-55">
						Welcome to the Client section
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button><a href="login.jsp">Log out</a></button>
					</span></div>


					
<div class="menu">
	<ul>
		<li><a href="chome.jsp">Service Providers Posts</a></li>
    	
    	
    	
    	<div class="clear"></div>
    </ul>
     <span class="left-ribbon"> </span> 
      <span class="right-ribbon"> </span>    
 </div>
</div>
</div>
</div>
<br><br>
    <span class="login100-form-title p-b-55">
						Service Providers Posts
					</span>
	<div class="limiter">
		<div class="container-login100">
			<div >
				
					<span >		
	 <%
            
                String driverName = "com.mysql.jdbc.Driver";
                String path = "jdbc:mysql://localhost:3306/weddingnew";
                String userId = "root";
                String password = "";
                
                try {
                Class.forName(driverName);
                } catch (ClassNotFoundException e) {
                e.printStackTrace();
                }
                
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;
                
            %>
           
            <%
            try{ 
                
            connection = DriverManager.getConnection(path, userId, password);
            statement=connection.createStatement();
            
            resultSet = statement.executeQuery("SELECT * FROM upload");
            while(resultSet.next()){

            %>
                
            <div align="center">
                
                <table  > 
                    <tr  align="center"><td>Service : <br><%=resultSet.getString("service")%></td></tr>
                    <tr align="center"><td>Title : <br><%=resultSet.getString("title")%></td></tr>
                    <tr align="center"><td>Description : <br><%=resultSet.getString("caption") %></td></tr>
                    <tr align="center"><td>Price : <br><%=resultSet.getString("price")%></td></tr>
                   
                    <tr align="center">
                        <td>
                        <form method="POST" action="postphoto.jsp" align="center">
                            <span  class="label"> View Post Photo </span>
                            <br>
                           <input type="hidden" name="postid" value="<%=resultSet.getString("postid")%>">
                            <input  type="submit" value="View Photo">
                        </form>
                        </td>
                    </tr>
                   
                    <br>
                    <br>
                
         <% 
            }

            } catch (Exception e) {
            e.printStackTrace();
            }
            %>
            </table>
            </div>	
            </span>

					
					
					

						
					</div>
</body>
</html>
