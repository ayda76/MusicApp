package Utils;



//import javax.naming.Context;
//import javax.naming.InitialContext;
import java.sql.*;

public class ConnectionString {
    private Connection connection;
    private PreparedStatement preparedStatement;
   /* private String cnsConnectionString(){
        String Sresult = null;
        try {
            Context ctx = new InitialContext();
            String dbUrl= (String) ctx.lookup("java:comp/env/dbUrl");

            Sresult= dbUrl;



        } catch (Exception e ) {

        }

        return  Sresult;
    }*/
    public ConnectionString() {
        ConnectSqlServer();
    }

    public Boolean ConnectSqlServer(){
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection =  DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QVQ230T\\SQLEXPRESS;databaseName=MusicPlayer;user=sa;password=1");
            connection.setAutoCommit(true);
            return true;
        }
        catch (Exception e) {

            System.out.println("No Connect -> "+e.getMessage());
            return false;

        }

    }
    public void DisconnectSqlServer(){

        try {
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet SelectToDB(String Query){
        try {
            System.out.println(Query);
            preparedStatement = connection.prepareStatement(Query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Errors SelectToDB:"+Query);
            e.printStackTrace();
            return null;
        }
    }



    public Boolean InsertToDB(String Query){
        Boolean Result;
        try {
            System.out.println(Query);
            preparedStatement = connection.prepareStatement(Query);
            preparedStatement.execute();

            Result = true;

        } catch (SQLException e) {
            System.out.println("Errors InsertToDB:"+Query);
            e.printStackTrace();
            Result = false;
        }

        return  Result;


    }

    public String UpdateStatements(PreparedStatement preparedStatement,String Query) {

        try {

            PreparedStatement QPreapertStatement = connection.prepareStatement(Query);
            QPreapertStatement=preparedStatement;
            preparedStatement = connection.prepareStatement(Query);
            return String.valueOf(preparedStatement.executeUpdate());



        } catch (SQLException e) {
            System.out.println("Errors UpdateToDB:"+Query);
            e.printStackTrace();
            return "0";

        }
    }
    public String UpdateToDB(String Query){

        try {
            System.out.println(Query);

            preparedStatement = connection.prepareStatement(Query);
            return String.valueOf(preparedStatement.executeUpdate());



        } catch (SQLException e) {
            System.out.println("Errors UpdateToDB:"+Query);
            e.printStackTrace();
            return "0";

        }


    }

}
