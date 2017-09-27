import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Sample
    {
    public static void main(String[] args) throws ClassNotFoundException
     {
    	String tarih;
      // load the sqlite-JDBC driver using the current class loader
      Class.forName("org.sqlite.JDBC");

      Connection connection = null;
      try
      {
         // create a database connection
         connection = DriverManager.getConnection("jdbc:sqlite:babaylon.db");

         Statement statement = connection.createStatement();
         statement.setQueryTimeout(30);  // set timeout to 30 sec.


     //    statement.executeUpdate("DROP TABLE IF EXISTS person");
       //  statement.executeUpdate("CREATE TABLE person (id INTEGER, name STRING)");

       /*  int ids [] = {1,2,3,4,5};
         String names [] = {"Peter","Pallar","William","Paul","James Bond"};

         for(int i=0;i<ids.length;i++){
              statement.executeUpdate("INSERT INTO person values(' "+ids[i]+"', '"+names[i]+"')");   
         }*/

         statement.executeUpdate("UPDATE otel SET tarih='sema' WHERE id='1'");
         //statement.executeUpdate("DELETE FROM person WHERE id='1'");

           ResultSet resultSet = statement.executeQuery("SELECT * from otel");
           while(resultSet.next())
           {
              // iterate & read the result set
              System.out.println("name = " + resultSet.getString("tarih"));
              System.out.println("id = " + resultSet.getInt("id"));
           }
    
           SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
      try {
    	
    	  Scanner in=new Scanner(System.in);
                tarih=in.nextLine();
          Date date = (Date) formatter.parse(tarih);
          
          
    	 
          String dateInString = "7-Jun-2013";
          Calendar c = Calendar.getInstance(); 
          c.setTime(date); 
          c.add(Calendar.DATE, 1);
          date = c.getTime();
          
         // System.out.println(date);
          System.out.println(formatter.format(date));

      } catch (ParseException e) {
          e.printStackTrace();
      }
      }

     catch(SQLException e){  System.err.println(e.getMessage()); }       
      finally {         
            try {
                  if(connection != null)
                     connection.close();
                  }
            catch(SQLException e) {  // Use SQLException class instead.          
               System.err.println(e); 
             }
      }
  }
 }
