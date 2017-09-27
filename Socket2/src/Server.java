
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

class Server
{
   public static void main(String argv[]) throws Exception
      {
         String clientSentence,dön=null;
         String capitalizedSentence,http;
         int a=0,b=0,c=0,d=0,e=0;
         String sentence,uçak,otel,kiþi,tarih,response,response1,tarih1;
         String modifiedSentence,modifiedSentence1,modifiedSentence2,modifiedSentence3,modifiedSentence4,modifiedSentence5,modifiedSentence6,ok;
         int i=0;
         int ll=0;
         ServerSocket welcomeSocket = new ServerSocket(1433);

         while(true)
         {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
          
            clientSentence = inFromClient.readLine();
            
            StringTokenizer tokenizer = new StringTokenizer(clientSentence);
			 tarih = tokenizer.nextToken();
			 tarih1 = tokenizer.nextToken();
			kiþi= tokenizer.nextToken();
			uçak= tokenizer.nextToken();
			otel= tokenizer.nextToken();
			
            System.out.println("Received: " +tarih +'\n' +tarih1 +'\n'+kiþi +'\n'+uçak +'\n'+otel +'\n' );
         
           // outToClient.writeBytes(clientSentence);
            
           if(otel.equals("lara")){
        	   
        	        Socket clientSocket = new Socket("localhost",1434);//-----------lara-----------------
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         
            outToServer.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' '+kiþi + '\n');
            modifiedSentence1 = inFromServer.readLine();
           // StringTokenizer tokenizer5 = new StringTokenizer(modifiedSentence1);
			// http = tokenizer5.nextToken();
			ok= modifiedSentence1;
			System.out.println(ok);
            
            if(ok.equals("200")){
            	a=2;
            }
            else{  Socket clientSocket4 = new Socket("localhost",1435);//---------------babaylon-------------
            DataOutputStream outToServer4 = new DataOutputStream(clientSocket4.getOutputStream());
            BufferedReader inFromServer4 = new BufferedReader(new InputStreamReader(clientSocket4.getInputStream()));
            
         
            outToServer4.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' '+kiþi + '\n');
            modifiedSentence4 = inFromServer4.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence4);
           
            StringTokenizer tokenizer1 = new StringTokenizer(modifiedSentence4);
            
            response1 = tokenizer1.nextToken();
            
            if(response1.equals("200"))
           	 a=1;
           	 else
           		 c=1;
           	 
           	clientSocket4.close(); 
           	 
            	
            }
            clientSocket.close();
           }
            	
            	
            	
           
           
           
           
            	
           if(uçak.equals("thy")){
          	
        	        Socket clientSocket2 = new Socket("localhost",1436);//-----------------thy------------------
            DataOutputStream outToServer2 = new DataOutputStream(clientSocket2.getOutputStream());
            BufferedReader inFromServer2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
         
            outToServer2.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' '+kiþi + '\n');
            modifiedSentence2 = inFromServer2.readLine();
            StringTokenizer tokenizer6 = new StringTokenizer(modifiedSentence2);
			
			if( modifiedSentence2.equals("200"))
				b=2;
			else {
				 Socket clientSocket3 = new Socket("localhost",1437);//-------------------pegasus---------------
		            DataOutputStream outToServer3 = new DataOutputStream(clientSocket3.getOutputStream());
		            BufferedReader inFromServer3 = new BufferedReader(new InputStreamReader(clientSocket3.getInputStream()));
		         
		            outToServer3.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' ' +kiþi + '\n');
		            modifiedSentence3 = inFromServer3.readLine();
		            System.out.println("FROM SERVER: " + modifiedSentence3);
		            
		            if( modifiedSentence3.equals("200"))
						b=1;
		            else
		            	c=2;
				
		            clientSocket3.close();
				
			         }
			
				
			clientSocket2.close();
           }
				
				
				
           
           
           
           
			
          	 if(uçak.equals("pegasus")){
        	        Socket clientSocket3 = new Socket("localhost",1437);//-------------------pegasus---------------
            DataOutputStream outToServer3 = new DataOutputStream(clientSocket3.getOutputStream());
            BufferedReader inFromServer3 = new BufferedReader(new InputStreamReader(clientSocket3.getInputStream()));
         
            outToServer3.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' ' +kiþi + '\n');
            modifiedSentence3 = inFromServer3.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence3);
            
            if( modifiedSentence3.equals("200"))
				d=2;
            else{
            	  Socket clientSocket2 = new Socket("localhost",1436);//-----------------thy------------------
                  DataOutputStream outToServer2 = new DataOutputStream(clientSocket2.getOutputStream());
                  BufferedReader inFromServer2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
               
                  outToServer2.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' '+kiþi + '\n');
                  modifiedSentence2 = inFromServer2.readLine();
                  StringTokenizer tokenizer6 = new StringTokenizer(modifiedSentence2);
      			
      			if( modifiedSentence2.equals("200"))
      				d=1;
      			else c=2;
      			clientSocket2.close();
            }
            clientSocket3.close();
          	 }
          	  
          	
          	 
          	 
          	 
          	 
          	 
           if(otel.equals("babaylon")){
        	     Socket clientSocket4 = new Socket("localhost",1435);//---------------babaylon-------------
                 DataOutputStream outToServer4 = new DataOutputStream(clientSocket4.getOutputStream());
                 BufferedReader inFromServer4 = new BufferedReader(new InputStreamReader(clientSocket4.getInputStream()));
                 
              
                 outToServer4.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' '+kiþi + '\n');
                 modifiedSentence4 = inFromServer4.readLine();
                 System.out.println("FROM SERVER: " + modifiedSentence4);
                
                 StringTokenizer tokenizer1 = new StringTokenizer(modifiedSentence4);
                 
                 response1 = tokenizer1.nextToken();
                 
                 if(response1.equals("200"))
                	 e=2;
                	 else{
             	        Socket clientSocket = new Socket("localhost",1434);//-----------lara-----------------
                        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     
                        outToServer.writeBytes("GET/HTTP/1.1 "+ ' ' + tarih+ ' '+ tarih1+ ' '+kiþi + '\n');
                        modifiedSentence1 = inFromServer.readLine();
                       // StringTokenizer tokenizer5 = new StringTokenizer(modifiedSentence1);
            			// http = tokenizer5.nextToken();
            			ok= modifiedSentence1;
            			System.out.println(ok);
                        
                        if(ok.equals("200"))
                		 e=1;
                        else c=1;
                        clientSocket.close(); 
                	 }
                	clientSocket4.close(); 
                	 
                 } 
                	 
                	 
                	 
                	
           if((c==1 & a==2 & e==0) | (c==1 & a==0 & e==2))
        	   dön="otellerde yer yok";
           if((c==2 & b==2 & d==0) | (c==2 & b==0 & d==2))
        	   dön="uçaklarda yer yok";
          // if((a==2 & b==2& d==0 & e==0 & c==0) | (a==2 & d==2 & b==0 & e==0 &c==0) | (e==2 & b==2 & a==0 & d==0 &c==0) | (e==2 & c==0 & d==2 & a==0 & b==0) ) {
        //	   dön="rezervasyonunuz tamamlandý";
          // }
           
           if((a==2 & b==1 & d==0 & e==0) | (a==2 & d==1 & e==0 & b==0) | (e==2 & b==1 & a==0 & d==0) | (e==2 & d==1 & a==0 & b==0) ) {
        	   dön="rezervasyonunuz diðer uçakla tamamlandý";
           }
           if((a==1 & b==2 & d==0 & e==0) | (a==1 & d==2 & b==0 & e==0) | (e==1 & b==2 & a==0 & d==0) | (e==1 & d==2 & a==0 & b==0) ) {
        	   dön="rezervasyonunuz diðer otelle tamamlandý";
           }
           if((a==1 & b==1 & d==0 & e==0) | (a==1 & d==1 & b==0 & e==0) | (e==1 & b==1 & a==0 & d==0) | (e==1 & d==1 & a==0 & b==0) ) {
        	   dön="rezervasyonunuz diðer uçak ve diðer otelle tamamlandý";
           }
           
           
           
           
           System.out.println(a);
           System.out.println(b);
           System.out.println(c);
           System.out.println(d);
           System.out.println(e);
           
           
           
               
           
           outToClient.writeBytes(dön+"\n");
         
      }
}
      
      }

