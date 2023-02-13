package EX3 ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastEnvoie extends Thread {
    
    // Initialisation des var destination , buffer et socket ( les noms sont assez explicites)
    protected InetAddress ipadresse = null;
    protected BufferedReader buffer;
    protected MulticastSocket socket = null;

    public MulticastEnvoie(String addresse , int port ) throws IOException{
		//Héritage des attributs 
        super();
        // Set de socket avec le port choisie
		this.socket = new MulticastSocket(port);
        // Set l'Addresse IP 
		this.ipadresse = InetAddress.getByName(addresse);
        //Lecture du buffer 
		this.buffer = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	public void run(){
        String message;
        DatagramPacket paquet;
		while(true){
			try {
				message = buffer.readLine();
				paquet = new DatagramPacket(message.getBytes(), message.getBytes().length, this.ipadresse, 7654);
				socket.send(paquet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}