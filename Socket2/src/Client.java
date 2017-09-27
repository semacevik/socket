import java.io.*;
import java.net.*;

class Client 
{
 public static void main(String argv[]) throws Exception
 {
  String sentence,sentence1,sentence2,sentence3,sentence5;
  String modifiedSentence=null;
  BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));

  Socket clientSocket = new Socket("localhost",1433);
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  System.out.println("giriþ tarihi:");
   sentence = inFromUser.readLine();
  System.out.println("çýkýþ tarihi:");
  BufferedReader inFromUser5 = new BufferedReader( new InputStreamReader(System.in));
  sentence5 = inFromUser5.readLine();
  System.out.println("kaç kiþi:");
  BufferedReader inFromUser1 = new BufferedReader( new InputStreamReader(System.in));
  sentence1 = inFromUser1.readLine();
  System.out.println("thy mi pegasus mu?:");
  BufferedReader inFromUser2 = new BufferedReader( new InputStreamReader(System.in));
  sentence2 = inFromUser2.readLine();
  System.out.println("lara mý babaylon mu?:");
  BufferedReader inFromUser3 = new BufferedReader( new InputStreamReader(System.in ));
  sentence3 = inFromUser3.readLine();
  
  System.out.println(sentence +' ' +sentence5+ ' '+ sentence1+ ' '+ sentence2+ ' '+sentence3);
  
  outToServer.writeBytes(sentence +' ' +sentence5+ ' '+ sentence1+ ' '+ sentence2+ ' '+sentence3+ "\n");
  
  System.out.println("FROM SERVER: " + modifiedSentence);
  clientSocket.close();
 }
}