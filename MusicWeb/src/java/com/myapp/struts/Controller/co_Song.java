
package com.myapp.struts.Controller;

import Utils.ConnectionString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class co_Song extends ConnectionString{
    
    
    
    public String LoadLyric(String id ) throws SQLException{
        ResultSet SelectToDB = SelectToDB("Select lyric  from  Song where song_id = "+id);
        String SResult = "";
        if(SelectToDB.next()){
            SResult=SelectToDB.getString("lyric");
        }
        return SResult;
    
    }
    public String Header() throws SQLException {

        return "<tr>\n"
                + "<th>کد</th>\n"
                + "<th>نام موریک</th>\n"
                + "<th>نام خواننده</th>\n"
                + "<th>نام آلبوم</th>\n"
                + "<th>تاریخ تولید</th>\n"
                
                + "<th>دسته بندی</th>\n"
                + "<th> </th>\n"
//                + "<th> </th>\n"
                + "</tr>";
    }
    public String LoadTables() throws SQLException {
        String Query = "select s.song_id,songname , ss.fname+' '+ss.lname SingName , a.albumname,convert(date,s.createdatetime) CDates,c.categoryname from Song s\n" +
"join Album a on s.album_id = a.album_id\n" +
"join Singer ss on ss.singer_id = s.singer_id\n" +
"join Category c on c.category_id = s.category_id";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("song_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("songname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("SingName") + "</td>\n"
                    + "<td>" + SelectToDB.getString("albumname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("CDates") + "</td>\n"
                    + "<td>" + SelectToDB.getString("categoryname") + "</td>\n"
                
                     + "<td><a  class=\"btn btn-danger mb-2 mr-2\" href=\"../../../../MusicWeb/Song_Servlet?action=delete&songid=" + SelectToDB.getString("song_id") + "\">حذف</a></td>\n"
                    + "</tr>";

        }
        System.out.println(TableFeatch);
        return TableFeatch;
    }
    public String  LoadMusic(){
        String Results ="";
        try {
            String  Query = "Select * from Song ";
            ResultSet resultSet =  SelectToDB(Query);
            int i =1 ;
            
            while(resultSet.next()){
                Results=Results+
                        "<source src=\"../../../../MusicWeb/Avatarimages/"+resultSet.getString("songfile")+"\" data-track-number=\""+i+"\" />";
                i++;
            }
          
    
//    Avatarimages/20.mp3
        } catch (SQLException ex) {
            Logger.getLogger(co_Song.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.println(Results);
            return  Results;
//   
    }

    
    public String LoadHomePageMini() throws SQLException{
        String Query = "SELECT         (select count(*) from [Like] where song_id=so.song_id) LikeCounts,song_id,songname,Pic,Substring(convert(nvarchar,songduration),1,5)songduration, convert(date,so.createdatetime)createdatetime \n" +
"                        ,si.lname+' '+si.fname namefamily \n" +
"                        FROM   Song so\n" +
"                        join Singer si on so.singer_id = si.singer_id";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";
        int i = 1;
        while (SelectToDB.next()) {
        //String   imgLen = SelectToDB.getString("Pic");
  
            TableFeatch = TableFeatch + "<div class=\"play-list-row\" data-track-row=\""+i+"\">\n" +
                                        
                    "<div class=\"small-toggle-btn\">\n" +
                                        "        <i class=\"small-play-btn\"><span class=\"screen-reader-text\">"+SelectToDB.getString("namefamily")+"</span></i>\n" +
                                        "      </div>\n" +
                                        "      <div class=\"track-number\">\n" +
                                        "        "+i+".\n" +
                                        "      </div>\n" +
                                        "      <div class=\"track-title\">\n" +
                                       "<img src=\"../../../../MusicWeb/Avatarimages/"+SelectToDB.getString("Pic")+"\" height=\"30\" width=\"30\"/>" +
                                        "        <a class=\"playlist-track\" href=\"#\" data-play-track=\"1\">"+SelectToDB.getString("songname")+"</a>\n" +
                                        "        <a class=\"fa fa-file-text\" style=\"margin: 10px;\" href=\"../../../MusicWeb/Play/Lyric.jsp?ID="+SelectToDB.getString("song_id")+"\"></a> " +
                                        "        <a class=\"fa fa-thumbs-up\" style=\"margin: 10px;\" href=\"../../../MusicWeb/Like_Servlet?ID="+SelectToDB.getString("song_id")+"\">  "+SelectToDB.getString("LikeCounts")+"</a> " +
                                        
                                        
                                        "    </div>";
            i++;

        }
        System.out.println(TableFeatch);
        return TableFeatch;
        
    }
    public String LoadHomePage() throws SQLException{

String Query = "SELECT         songname,Pic,Substring(convert(nvarchar,songduration),1,5)songduration, convert(date,so.createdatetime)createdatetime \n" +
",si.lname+' '+si.fname namefamily\n" +
"FROM   Song so\n" +
"join Singer si on so.singer_id = si.singer_id";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<div class=\"item\">\n" +
                  
                                        "          <div class=\"thumb\"></div>\n" +
                                        "          <div class=\"info\">\n" +
                    
                                        "            <div class=\"name\">" + SelectToDB.getString("songname") + "</div>\n" +
                                        "            <div class=\"desc\">" + SelectToDB.getString("songduration") + "</div>\n" +
                                        "            <div class=\"desc\">" + SelectToDB.getString("namefamily") + "</div>\n" +
                                        "          </div>\n" +
                                        "        </div>";

        }
        System.out.println(TableFeatch);
        return TableFeatch;

}    

    public void Song_Delete(String song_id) {       
        
        InsertToDB("delete song where song_id =  "+song_id);
    }
    
}
