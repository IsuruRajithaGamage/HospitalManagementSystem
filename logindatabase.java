/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class logindatabase {
    //check client login 
    public boolean checkaLogin(String operator,String uname,String pw,String active) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/weddingnew","root","");
        Statement st=con.createStatement();
        
        String sql="SELECT * FROM user WHERE operator='"+"client"+"' AND uname='"+uname+"' AND pw='"+pw+"' AND active='"+0+"';";
        ResultSet rs=st.executeQuery(sql);
        
        return rs.next();
      }
      //check service provider login
      public boolean checkbLogin(String operator,String uname,String pw,String active) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/weddingnew","root","");
        Statement st=con.createStatement();
        
        String sql="SELECT * FROM user WHERE operator='"+"serviceprovider"+"' AND uname='"+uname+"' AND pw='"+pw+"' AND active='"+1+"';";
        ResultSet rs=st.executeQuery(sql);
        
        return rs.next();
      }
      //check admin login 
       public boolean checkcLogin(String operator,String uname,String pw) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/weddingnew","root","");
        Statement st=con.createStatement();
        
        String sql="SELECT * FROM user WHERE operator='"+"admin"+"' AND uname='"+uname+"' AND pw='"+pw+"';";
        ResultSet rs=st.executeQuery(sql);
        
        return rs.next();
      }
    
}
