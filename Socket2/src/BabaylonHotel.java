
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

class BabaylonHotel
{
	
	
	
   public static void main(String argv[]) throws Exception
      {
         String clientSentence,tarih,kiþi,uçak,otel,tarih1,gethttp,gün,ay,yýl,gün1,ay1,yýl1;
         String capitalizedSentence;
         ServerSocket welcomeSocket = new ServerSocket(1435);
         int f=0, l=0;
         while(true)
         {
        	 
             Socket connectionSocket = welcomeSocket.accept();
             BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
             DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
             clientSentence = inFromClient.readLine();
             System.out.println("Received: " + clientSentence);
             capitalizedSentence = clientSentence.toUpperCase() + '\n';
             
             StringTokenizer tokenizer = new StringTokenizer(clientSentence);
			 gethttp= tokenizer.nextToken();
			tarih= tokenizer.nextToken();
			tarih1= tokenizer.nextToken();
			kiþi= tokenizer.nextToken();
			  StringTokenizer stringTokenizer = new StringTokenizer(tarih, ".");
			  gün=stringTokenizer.nextToken();
			  ay=stringTokenizer.nextToken();
			  yýl=stringTokenizer.nextToken();
			  
			  StringTokenizer stringTokenizer1 = new StringTokenizer(tarih1, ".");
			  gün1=stringTokenizer1.nextToken();
			  ay1=stringTokenizer1.nextToken();
			  yýl1=stringTokenizer1.nextToken();
			  
			  int günint=Integer.parseInt(gün);
			  int ayint=Integer.parseInt(ay);
			  int yýlint=Integer.parseInt(yýl);
			  int gün1int=Integer.parseInt(gün1);
			  int ay1int=Integer.parseInt(ay1);
			  int yýl1int=Integer.parseInt(yýl1);
			  
		    
            int kiþiler=Integer.parseInt(kiþi);

         Class.forName("org.sqlite.JDBC");

         Connection connection = null;
         try
         {
        	 
        	 
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:babaylon.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.


           // statement.executeQuery("SELECT kiþi from otel where id=5");
           //statement.executeUpdate("CREATE TABLE otel (id INTEGER, tarih String default 'null', doluluk boolean default 0  )");
            
           
           /* for(int i=0;i<ids.length;i++){
                 statement.executeUpdate("INSERT INTO otel (id) values(' "+ids[i]+" ')");   
            }*/
           /* for(int i=0;i<kiþiler;i++){
            statement.executeUpdate("UPDATE otel SET doluluk='1', tarih='"+tarih+"' WHERE id=' "+ids[i]+"'");
            }
 */            //
            //statement.executeUpdate("DELETE FROM person WHERE id='1'");
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	        try {
	      	
	      
	                
	            Date date = (Date) formatter.parse(tarih);
	            Date date1 = (Date) formatter.parse(tarih1);
	            System.out.println(date);
	            System.out.println(date1);
	            if(kiþiler<=50){
	          while(date.compareTo(date1)<=0){  
	        	   System.out.println(date1);
	        	//	statement.executeQuery("SELECT id from otel where tarih=date");
	        	
		        	//if you really want and you are sure that it fits you can now cast
	        	   
	               
		        	
	        	  ResultSet resultSet2= statement.executeQuery("SELECT count (id) as klm from otel where tarih='" +date+" '");
	        	  
	   	        	int abc=resultSet2.getInt("klm");
	   	 
	   	        	
	   	  
	   	        
	        	
	   	        
	   	    //  System.out.println();
	        	
	        	
	        	 if(abc!=0){
		        	// if( count >= kiþiler){
	        		 ResultSet resultSet1= statement.executeQuery("SELECT id from otel where tarih='" +date+" '");
			        	
		        	  int countLong = resultSet1.getInt("id");
		        	  
		        	 
		        	  System.out.println(countLong);
		        		System.out.println("hjk");
			   	        
		        
		        	//  int count5 = (int)countLong;
		        	  System.out.println(countLong);
		        	  int count5=countLong-kiþiler;
		        	  if(count5>=0){
		        		
		        		 statement.executeUpdate("UPDATE otel SET id="+count5+" where tarih='" +date+" '");
		        		 // capitalizedSentence="200";
		        		  f=1;
		        	  }
		        	  else{
		        		  l=1;
		        		 
		        		 
		        	  }
		        	  }
		        		 
		        	 //}
		        	 //else
		        	//	 break;
		        	  
	        	 
	        	 else {
	        		  System.out.println("sema geldi");
	        		  int k=50-kiþiler;
	        		  if(k>=0){
		        	 System.out.println(formatter.format(date));
			            statement.executeUpdate("INSERT INTO otel  (id, tarih) values( "+k+",'" +date+" ')"); 
			            capitalizedSentence="200";
	        		  }
	        		  else   capitalizedSentence="404";
		           
		           // System.out.println(date);
		        	  }
	        	 
	        	 
	        
	        	 
	        		 Calendar c = Calendar.getInstance(); 
	 	            c.setTime(date); 
	 	            c.add(Calendar.DATE, 1);
	 	            date = c.getTime();
	        	 
	           
	        }
	            }
	            else capitalizedSentence="404";
	        }
	        
	          catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
            
           
	        
 
            /*  ResultSet resultSet = statement.executeQuery("SELECT * from otel");
              while(resultSet.next())
              {
                 // iterate & read the result set
                 System.out.println("tarih = " + resultSet.getString("tarih"));
                 System.out.println("id = " + resultSet.getInt("id"));
              
             
              }*/
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
         
            
         if((f==1 & l==1) |(f==0 & l==1))
    		 capitalizedSentence="404";
       //  else if((f==0 & l==0))
        //	 capitalizedSentence="200";
             

            outToClient.writeBytes(  capitalizedSentence+"\n");
         } 
         
            
           
         }
      }
