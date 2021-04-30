
package Servlet;

import Database.logindatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class loginservlet extends HttpServlet {

    
   

   
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logindatabase db=new logindatabase();
        String operator = request.getParameter("operator");
        String uname = request.getParameter("uname");
        String pw = request.getParameter("pw");
        String active = request.getParameter("active");
       
        try {
            //client
            if(db.checkaLogin(operator,uname, pw,active)){
                response.sendRedirect("chome.jsp");
                HttpSession sess=request.getSession();
                sess.setAttribute("uname",uname);
                
            }
            //service povider
            else if(db.checkbLogin(operator,uname, pw,active)){
                response.sendRedirect("sphome.jsp");
                HttpSession sess=request.getSession();
                sess.setAttribute("uname", uname);
                
            }
            //admin
             else if(db.checkcLogin(operator,uname, pw)){
                response.sendRedirect("admincdetails.jsp");
                HttpSession sess=request.getSession();
                sess.setAttribute("uname", uname);
                
            }
            
            else
                response.sendRedirect("error.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        }catch(){
        } 
        
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
