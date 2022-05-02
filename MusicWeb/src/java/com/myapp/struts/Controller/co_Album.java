
package com.myapp.struts.Controller;

import Utils.ConnectionString;
import com.myapp.struts.Dao.do_Album;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class co_Album extends ConnectionString {

    public String Header() throws SQLException {
        return "<tr>\n"
                + "<th>کد</th>\n"
                + "<th>نام آلبوم</th>\n"
                + "<th>وضعیت</th>\n"
                + "<th>تاریخ ایجاد</th>\n"
                + "<th> </th>\n"
                + "<th> </th>\n"
                + "</tr>";
    }

    public String LoadTables() throws SQLException {
        String Query = "Select * from Album";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";
//abum_id, albumname, status, createdatetime

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("album_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("albumname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("status") + "</td>\n"
                    + "<td>" + SelectToDB.getString("createdatetime") + "</td>\n"
                    + "<td><a class=\"btn btn-warning mb-2 mr-2\" href=\"../../../../MusicWeb/Album_Servlet?action=edit&album_id=" + SelectToDB.getString("album_id") + "\">ویرایش</a></td>\n"
                    + "<td><a  class=\"btn btn-danger mb-2 mr-2\" href=\"../../../../MusicWeb/Album_Servlet?action=delete&album_id=" + SelectToDB.getString("album_id") + "\">حذف</a></td>\n"
                    + "</tr>";

        }
        System.out.println(TableFeatch);
        return TableFeatch;
    }
    
    public String HeaderSelect() throws SQLException {
        return "<tr>\n"
                + "<th>کد</th>\n"
                + "<th>نام آلبوم</th>\n"
                + "<th>وضعیت</th>\n"
                + "<th> </th>\n"
                + "</tr>";
    }

    public String LoadTablesSelect() throws SQLException {
        String Query = "Select * from Album";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";
//abum_id, albumname, status, createdatetime

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("album_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("albumname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("status") + "</td>\n"                    
                     +"<td><button onclick=\"myFunctionAlbum('" + SelectToDB.getString("album_id") + "')\" class=\"btn\" data-dismiss=\"modal\"><i class=\"flaticon-cancel-12\"></i> انتخاب</button></td>"
                    + "</tr>";

        }
        System.out.println(TableFeatch);
        return TableFeatch;
    }

    public void Album_Insert(do_Album album) {
        String Query = "EXEC	 [dbo].[Album_Insert]\n"
                + "		@albumname = N'" + album.getAlbumname() + "',\n"
                + "		@status = " + album.getStatus() + ",\n"
                + "		@Singer_id = " + album.getSinger_id();
         InsertToDB(Query);

    }

    public void Album_Update(do_Album album) {
        String Query = "EXEC	 [dbo].[Album_Update]\n"
                + "		@albumname = N'" + album.getAlbumname() + "',\n"
                + "		@status = " + album.getStatus() + ",\n"
                + "		@album_id = " + album.getAbum_id()+ ",\n"
                + "		@Singerid = " + album.getSinger_id()+"";

        InsertToDB(Query);
    }

    public void Album_Delete(String AlbumID) {
        
        String Query = "delete Album where album_id = "+AlbumID;
        InsertToDB(Query);
        
        
        
        
    }

    public do_Album FindByID(String AlbumID) {
        do_Album a = new do_Album();
      String Query = "Select * from  Album where album_id = "+AlbumID;  
        ResultSet SelectToDB = SelectToDB(Query);
        try {
            if (SelectToDB.next()){
                a.setAbum_id(SelectToDB.getInt("album_id"));
                a.setStatus(SelectToDB.getString("Status"));
                a.setSinger_id(SelectToDB.getString("Singer_id"));
                a.setAlbumname(SelectToDB.getString("albumname"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(co_Album.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }

}
