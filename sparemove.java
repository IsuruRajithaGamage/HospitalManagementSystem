
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class spremove extends HttpServlet {

  
   

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
        String email = request.getParameter("email");
        
            String driverName = "com.mysql.jdbc.Driver";
            String path = "jdbc:mysql://localhost:3306/weddingnew";
            String userId = "root";
            String password = "";
            
            
            Connection conn= DriverManager.getConnection(path, userId, password);
            Statement st = conn.createStatement();
            String sql ="DELETE FROM user WHERE email='" + email + "';";
            st.executeUpdate(sql);
        }  catch (SQLException ex) {
            Logger.getLogger(spremove.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            response.sendRedirect("adminspdetails.jsp");
    }
    }

   

   
 