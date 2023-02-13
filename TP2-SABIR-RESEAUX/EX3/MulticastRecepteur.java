package EX3 ;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;



public class MulticastRecepteur extends Thread {
	// Initialisation de socket avec la valeur NULL
    protected MulticastSocket socket = null;
	// Initialisation du Hashmap noms
    protected HashMap<String, String> noms;
	// Initialisation de ipadresse avec la valeur NULL
    protected InetAddress ipadresse = null;

	

	public MulticastRecepteur(String address, int port) throws IOException {
		super();
		//Set de socket avec le port choisie
        this.socket = new MulticastSocket(port);
        // Set l'Addresse IP 
		this.ipadresse = InetAddress.getByName(address);
		// Set de Dict à un Dict vide 
        this.noms = new HashMap<String, String>();
        // Remplissage du Dict noms
		this.noms.put(InetAddress.getLocalHost().getHostAddress().toString(), "Test");
		
	}



	public void run(){
        // Init du packet
		DatagramPacket packet;
		// Init de de message byte[]
        byte[] message;
		
		// Catch IOException error
		try {
			socket.joinGroup(this.ipadresse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true){
			// Set Message
            message = new byte[1055];
            // Set paquet
			packet = new DatagramPacket(message, message.length);
			try {
				socket.receive(packet);
				if(!this.noms.containsKey(packet.getAddress().toString())) {
					this.noms.put(packet.getAddress().toString(), RandomName.generateName());
				}
				// Print the random Name of the sender
                System.out.print(this.noms.get(packet.getAddress().toString()) + " said : ");
				// Print the message sent 
                System.out.println(new String(packet.getData()));
			} 
            // Catch IOException Error
            catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
