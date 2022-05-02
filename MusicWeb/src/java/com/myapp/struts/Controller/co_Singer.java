
package com.myapp.struts.Controller;

import Utils.ConnectionString;
import com.myapp.struts.Dao.do_Singer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class co_Singer extends ConnectionString {

    public String Header() throws SQLException {

        return "<tr>\n"
                + "<th>کد</th>\n"
                + "<th>نام</th>\n"
                + "<th>نام خانوادگی</th>\n"
                + "<th>تاریخ تولد</th>\n"
                + "<th>کشور</th>\n"
                + "<th>ایمیل</th>\n"
                + "<th> </th>\n"
                + "<th> </th>\n"
                + "</tr>";
    }
    public String HeaderSeect() throws SQLException {

        return "<tr>\n"
                + "<th>کد</th>\n"
                + "<th>نام</th>\n"
                + "<th>نام خانوادگی</th>\n"                
                + "<th>کشور</th>\n"                
                + "<th></th>\n"                
                + "</tr>";
    }

public String LoadTablesSelect() throws SQLException {
        String Query = "Select * from Singer";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("singer_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("lname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("fname") + "</td>\n"
                    
                    + "<td>" + SelectToDB.getString("country") + "</td>\n"
                    +"<td><button onclick=\"myFunctionSinger('" + SelectToDB.getString("singer_id") + "')\" class=\"btn\" data-dismiss=\"modal\"><i class=\"flaticon-cancel-12\"></i> انتخاب</button></td>"
                    + "</tr>";

        }
//        System.out.println(TableFeatch);
        return TableFeatch;
    }
    public String LoadTables() throws SQLException {
        String Query = "Select * from Singer";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("singer_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("lname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("fname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("Birthday") + "</td>\n"
                    + "<td>" + SelectToDB.getString("country") + "</td>\n"
                    + "<td>" + SelectToDB.getString("email") + "</td>\n"
                    + "<td><a class=\"btn btn-warning mb-2 mr-2\" href=\"../../../../MusicWeb/Singer_Servlet?action=edit&singer_id=" + SelectToDB.getString("singer_id") + "\">ویرایش</a></td>\n"
                    + "<td><a  class=\"btn btn-danger mb-2 mr-2\" href=\"../../../../MusicWeb/Singer_Servlet?action=delete&singer_id=" + SelectToDB.getString("singer_id") + "\">حذف</a></td>\n"
                    + "</tr>";

        }
        System.out.println(TableFeatch);
        return TableFeatch;
    }

    public void Singer_InsertTo(do_Singer singer) {

        String Query = "EXEC  [dbo].[Singer_Insert]\n"
                + "		@lname = N'" + singer.getFname() + "',\n"
                + "		@fname = N'" + singer.getLname() + "',\n"
                + "		@Birthday = N'" + singer.getBirthday() + "',\n"
                + "		@sex = N'" + singer.getSex() + "',\n"
                + "		@birthplace = N'" + singer.getCountry() + "',\n"
                + "		@country = N'" + singer.getCountry() + "',\n"
                + "		@mobile = N'" + singer.getMobile() + "',\n"
                + "		@email = N'" + singer.getEmail() + "'";
        Boolean InsertToDB = InsertToDB(Query);

    }

    public void Singer_Delete(String singer_id) {

        String Query = "exec Singer_Delete " + singer_id;
        Boolean InsertToDB = InsertToDB(Query);
    }

    public do_Singer FindByIS(String singer_id) {
        do_Singer s = new do_Singer();
        String Query = "Select * from Singer\n"
                + "	where singer_id = " + singer_id;
        ResultSet SelectToDB = SelectToDB(Query);
        try {
            if(SelectToDB.next()){
                //, fname, Birthday, sex, birthplace, country, createdatetime, mobile, email,
                s.setSinger_id(SelectToDB.getString("Singer_id"));
                s.setLname(SelectToDB.getString("fname"));
                s.setFname(SelectToDB.getString("lname"));
                s.setBirthday(SelectToDB.getString("Birthday"));
                s.setSex(SelectToDB.getString("sex"));
                s.setBirthplace(SelectToDB.getString("birthplace"));
                s.setCountry(SelectToDB.getString("country"));
                s.setMobile(SelectToDB.getString("mobile"));
                s.setEmail(SelectToDB.getString("email"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(co_Singer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return s;
        
    }

    public void Singer_Update(do_Singer singer) {
        
        String Query = "EXEC  [dbo].[Singer_Update]\n"
                + "		@singid = N'" + singer.getSinger_id()+ "',\n"
                + "		@lname = N'" + singer.getFname() + "',\n"
                + "		@fname = N'" + singer.getLname() + "',\n"
                + "		@Birthday = N'" + singer.getBirthday() + "',\n"
                + "		@sex = N'" + singer.getSex() + "',\n"
                + "		@birthplace = N'" + singer.getCountry() + "',\n"
                + "		@country = N'" + singer.getCountry() + "',\n"
                + "		@mobile = N'" + singer.getMobile() + "',\n"
                + "		@email = N'" + singer.getEmail() + "'";
        Boolean InsertToDB = InsertToDB(Query);

        
        
    }

}
