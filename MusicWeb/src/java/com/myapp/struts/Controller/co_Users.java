
package com.myapp.struts.Controller;

import Utils.ConnectionString;
import com.myapp.struts.Dao.do_Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class co_Users extends ConnectionString {

    public String Header() throws SQLException {

        return "<tr>\n"
                + "<th>کد کاربری </th>\n"
                + "<th>نام  </th>\n"
                + "<th> نام خانوادگی </th>\n"
                + "<th> ایمیل </th>\n"
                + "<th> موبایل </th>\n"
                + "<th> تاریخ ایجاد </th>\n"
                + "<th> </th>\n"
                + "<th class=\"no-content\"></th>\n"
                + "</tr>";
    }

    public String LoadTables() throws SQLException {
        String Query = "Select * from Users";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";

        while (SelectToDB.next()) {

            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("user_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("lname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("fname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("email") + "</td>\n"
                    + "<td>" + SelectToDB.getString("mobile") + "</td>\n"
                    + "<td>" + SelectToDB.getString("createdatetime") + "</td>\n"
                    + "<td><a class=\"btn btn-warning mb-2 mr-2\" href=\"../../../../MusicWeb/Users_Servlet?action=edit&UserID=" + SelectToDB.getString("user_id") + "\">ویرایش</a></td>\n"
                    + "<td><a  class=\"btn btn-danger mb-2 mr-2\" href=\"../../../../MusicWeb/Users_Servlet?action=delete&UserID=" + SelectToDB.getString("user_id") + "\">حذف</a></td>\n"
                    + "</tr>";

        }
//        System.out.println(TableFeatch);
        return TableFeatch;
    }
    public do_Users Login(String UserName , String password)  {
    do_Users u = new  do_Users();
                
        String QString  = "SELECT *    FROM Users where username='"+UserName+"' and password = '"+password+"'";
        ResultSet SelectToDB = SelectToDB(QString);
        try {
            if(SelectToDB.next()){
                
                u.setFname(SelectToDB.getString("fname"));
                u.setLname(SelectToDB.getString("Lname"));
                u.setEmail(SelectToDB.getString("Email"));
                u.setMobile(SelectToDB.getString("Mobile"));
                u.setUsername(SelectToDB.getString("Username"));
                u.setPassword(SelectToDB.getString("password"));
                u.setUser_id(Integer.valueOf(SelectToDB.getString("User_id")));
                u.setUserType(Integer.valueOf(SelectToDB.getString("RoleID")));
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(co_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    
    }
    public do_Users FindByIDs(String UserID)  {
        
        do_Users u = new  do_Users();
                
        String QString  = "Select * from Users where user_id = "+UserID;
        ResultSet SelectToDB = SelectToDB(QString);
        try {
            if(SelectToDB.next()){
                
                u.setFname(SelectToDB.getString("fname"));
                u.setLname(SelectToDB.getString("Lname"));
                u.setEmail(SelectToDB.getString("Email"));
                u.setMobile(SelectToDB.getString("Mobile"));
                u.setUsername(SelectToDB.getString("Username"));
                u.setPassword(SelectToDB.getString("password"));
                u.setUser_id(Integer.valueOf(SelectToDB.getString("User_id")));
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(co_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public String Users_InsertTo(do_Users u) {

        String Query = "EXEC [dbo].[Users_Insert]\n"
                + "		@username = N'" + u.getUsername() + "',\n"
                + "		@password = N'" + u.getPassword() + "',\n"
                + "		@lname = N'" + u.getLname() + "',\n"
                + "		@fname = N'" + u.getFname() + "',\n"
                + "		@status = N'1',		\n"
                + "		@email = N'" + u.getEmail() + "',\n"
                + "		@mobile = N'" + u.getMobile() + "'";
        Boolean InsertToDB = InsertToDB(Query);
        return "";
    }

    public void Users_Delete(String UserID) {

        String Query = "exec Users_Delete " + UserID;
        InsertToDB(Query);
    }

    public void Users_Updte(do_Users users) {
       String Query = "EXEC [dbo].[Users_Update]\n"
                + "		@username = N'" + users.getUsername() + "',\n"
                + "		@password = N'" + users.getPassword() + "',\n"
                + "		@lname = N'" + users.getLname() + "',\n"
                + "		@fname = N'" + users.getFname() + "',\n"
                + "		@status = N'1',		\n"
                + "		@email = N'" + users.getEmail() + "',\n"
                + "		@UserID = N'" + users.getUser_id() + "',\n"
                + "		@mobile = N'" + users.getMobile() + "'";
        Boolean InsertToDB = InsertToDB(Query);
        
    }

}
