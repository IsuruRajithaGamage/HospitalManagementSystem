/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class registerdatabase {
     String url = "jdbc:mysql://localhost:3306/weddingnew";
        String username = "root";
        String password = "";
    
    public void input(String operator, String name, String email, String service, String tnum, String uname, String pw) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            String quary="INSERT INTO user(operator,name,email,service,tnum,uname,pw) VALUES ('" + operator + "','" + name + "','" + email + "','" + service + "','" + tnum + "','" + uname + "','" + pw + "')";
            st.executeUpdate(quary);
    }
}
