import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.lang.String;
import java.net.InetAddress;
import java.net.SocketException;

//getBytes()
//String(byte[])
/*
ServerSocket server = new ServerSocket(port);
Socket s  = server.accept();
 */

 // On peut configurer l'addresse IP à 127.0.0.1 par défault 

public class SendUDP{
    public static void main(String[] args)throws IOException, SocketException {
        // Création du socket
        DatagramSocket socket;
        // Création du packet contenant le socket 
        DatagramPacket packet;

        // Ip address de destination
        String ip = args[2];
        InetAddress destination = InetAddress.getByName(ip);
        // Port sur lequel le port sera envoyer
        int port = Integer.parseInt(args[0]);
        // Message à envoyer 
        String message = args[1];

        // On configure le paquet (message.getBytes => Transforme le message en un tableau de bytes )
        packet = new DatagramPacket(message.getBytes(),message.length(),destination,port);
        // On crée le socket 
        socket=new DatagramSocket();

        // On envoie le socket avec comme option le packet créé
        socket.send(packet);
        // On ferme le socket envoyé 
        socket.close();


    }    
}

 