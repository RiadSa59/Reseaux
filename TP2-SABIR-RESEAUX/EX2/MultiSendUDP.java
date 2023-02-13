package EX2;
import java.net.*;

public class MultiSendUDP {
	
	public static void main (String[] args) throws Exception
	{
		// Init message 
		String message = args[0];
		// Init socket
		DatagramSocket socket;		
		// Init paquet
		DatagramPacket paquet;
		// Init port at 7654
		int port = 7654;

		// Set destination IP 
		InetAddress destination = InetAddress.getByName("224.0.0.1");
		// Set paquet
		paquet = new DatagramPacket (message.getBytes(),message.length() , destination, port);
		// Set Socket 
		socket = new DatagramSocket();
		// Send Paquet 
		socket.send(paquet);
		// Close Socket 
		socket.close();
	}

}

