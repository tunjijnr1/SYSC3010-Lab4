import java.net.*;
import java.util.Scanner;
import java.util.Random;

public class RandNumSender {

	public static void main(String[] args) 
   {
	   Random rand = new Random();
	   
	      
	      // Check the arguments
	      if( args.length != 2 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
	         //InetAddress host = InetAddress.getByName("localhost") ;
	         //int port         = 8081;

	         socket = new DatagramSocket() ;
     
	         Scanner in;
	         in = new Scanner (System.in);
	         String message = null;
	         for (int i = 0; i < 10; i++) {
				     message = String.valueOf(rand.nextInt());
				     System.out.println ("Sending: " + message);
				 	 byte [] data = message.getBytes();
	        		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		 socket.send( packet );
	         } 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

