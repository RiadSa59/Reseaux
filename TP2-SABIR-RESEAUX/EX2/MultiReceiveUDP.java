package EX2;

import java.net.*;  



public class MultiReceiveUDP {
	
	public static void main (String[] args) throws Exception
	{
		// Init paquet 
		DatagramPacket paquet;
		// Init socket 
		MulticastSocket socket;

		// Set socket with port 7654
		socket = new MulticastSocket(7654);
		// Socket JoinGroup 224.0.0.1
		socket.joinGroup(InetAddress.getByName("224.0.0.1"));
		// Set Paquet
		paquet = new DatagramPacket(new byte[512],512);
		// Keep receiving paquets
		while(true)
		{
		socket.receive(paquet);
		System.out.println("New message received! \n\nAdresse : "+ paquet.getAddress()+
		"\nPort    : "+            paquet.getPort()+
		"\nSize    : " +          paquet.getLength());
		byte array[] = paquet.getData();
		String message = new String (array);
		System.out.println("Message : " + message);
		
		}

	}

}
