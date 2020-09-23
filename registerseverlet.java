/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Database.registerdatabase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "registerservlet", urlPatterns = {"/registerservlet"})
public class registerservlet extends HttpServlet {

  
    

   
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String operator = request.getParameter("operator");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String service = request.getParameter("service");
        String tnum = request.getParameter("tnum");
        String uname = request.getParameter("uname");
        String pw = request.getParameter("pw");
        
        PrintWriter out = response.getWriter();
        registerdatabase rb = new registerdatabase();
        
        try{
            rb.input(operator,name,email,service,tnum,uname,pw);
            response.sendRedirect("login.jsp");
        }
        catch(Exception e){
            out.println(e);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
