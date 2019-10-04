
import java.net.*;

public class RandNumReceiver {

	private final static int PACKETSIZE = 100 ;
	//private final static String SENDER_IP = "10.0.0.21";
	private final static String SENDER_IP = "localhost";

	public static void main( String args[] )
	{ 
	      
	      // Check the arguments
	      if( args.length != 1 )
	      {
	         System.out.println( "usage: UDPReceiver port" ) ;
	         return ;
	      }
	      
	      try
	      {
	         // Convert the argument to ensure that is it valid
	         int port = Integer.parseInt( args[0] ) ;
	         //int port = 8081;

	         // Construct the socket
	         DatagramSocket rxSocket = new DatagramSocket( port ) ;
	         //DatagramSocket txSocket = new DatagramSocket( port , InetAddress.getByName(SENDER_IP)) ;

	         for( ;; )
	         {
		        System.out.println( "Receiving on port " + port ) ;
		        DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	            rxSocket.receive( packet ) ;

	            System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()).trim() ) ;
	       
	        }  
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
  }
}

