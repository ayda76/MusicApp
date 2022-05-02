
package com.myapp.struts.Controller;

import Utils.ConnectionString;
import com.myapp.struts.Dao.do_Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class co_Category extends ConnectionString {

    public String Header() throws SQLException {
        return "<tr>\n"
                + "<th>کد</th>\n"
                + "<th>نام دسته</th>\n"
                + "<th>کد پدر</th>\n"
                + "<th>تاریخ ایجاد</th>\n"
                + "<th> </th>\n"
                + "<th> </th>\n"
                + "</tr>";
    }

    public String LoadTables() throws SQLException {
        String Query = "Select * from Category";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("category_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("categoryname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("parent") + "</td>\n"
                    + "<td>" + SelectToDB.getString("createdatetime") + "</td>\n"
                    + "<td><a class=\"btn btn-warning mb-2 mr-2\" href=\"../../../../MusicWeb/Category_Servlet?action=edit&CategoryID=" + SelectToDB.getString("category_id") + "\">ویرایش</a></td>\n"
                    + "<td><a  class=\"btn btn-danger mb-2 mr-2\" href=\"../../../../MusicWeb/Category_Servlet?action=delete&CategoryID=" + SelectToDB.getString("category_id") + "\">حذف</a></td>\n"
                    + "</tr>";

        }
//        System.out.println(TableFeatch);
        return TableFeatch;
    }

    
    
    public String HeaderSelect() throws SQLException {
        return "<tr>\n"
                + "<th>کد</th>\n"
                + "<th>نام دسته</th>\n"
                + "<th>کد پدر</th>\n"
                + "<th>تاریخ ایجاد</th>\n"
               
                + "<th> </th>\n"
                + "</tr>";
    }

    public String LoadTablesSelect() throws SQLException {
        String Query = "Select * from Category";
        ResultSet SelectToDB = SelectToDB(Query);
        String TableFeatch = "";

        while (SelectToDB.next()) {
            TableFeatch = TableFeatch + "<tr>\n"
                    + "<td>" + SelectToDB.getString("category_id") + "</td>\n"
                    + "<td>" + SelectToDB.getString("categoryname") + "</td>\n"
                    + "<td>" + SelectToDB.getString("parent") + "</td>\n"
                    + "<td>" + SelectToDB.getString("createdatetime") + "</td>\n"
                    +"<td><button onclick=\"myFunctionCategory('" + SelectToDB.getString("category_id") + "')\" class=\"btn\" data-dismiss=\"modal\"><i class=\"flaticon-cancel-12\"></i> انتخاب</button></td>"
                    + "</tr>";

        }
        System.out.println(TableFeatch);
        return TableFeatch;
    }
    public void Category_Insert(do_Category c) {

        String Query = "EXEC	[dbo].[Category_Insert]\n"
                + "		@categoryname = N'"+c.getCategoryname()+"',\n"
                + "		@parent = 0";
        InsertToDB(Query);

    }
    public void Category_Update(do_Category c) {

        String Query = "EXEC	[dbo].[Category_Update]\n"
                + "		@categoryname = N'"+c.getCategoryname()+"',\n"
                + "		@categoryID = N'"+c.getCategory_id()+"',\n"
                + "		@parent = "+c.getParent()+"";
        InsertToDB(Query);

    }
    public do_Category FindByID(String CategoryID){
    do_Category category = new do_Category();
    String Query = "Select * from Category where category_id = "+CategoryID;
        ResultSet SelectToDB = SelectToDB(Query);
        try {
            if(SelectToDB.next()){
                category.setCategory_id(SelectToDB.getString("category_id"));
                category.setCategoryname(SelectToDB.getString("categoryname"));
                category.setParent(SelectToDB.getString("Parent"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(co_Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
        
    
    }
    public void Category_Delete(String CategoryID){
    
    String Query = "delete Category  where category_id  =  "+CategoryID;
        InsertToDB(Query);
    }
}
