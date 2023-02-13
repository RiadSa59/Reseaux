
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.lang.String;
import java.net.*;

//getBytes()
//String(byte[])
/*
ServerSocket server = new ServerSocket(port);
Socket s  = server.accept();
 */

public class ReceiveUDP{
    public static void main(String[] args)throws SocketException,IOException{
        // Socket id
        DatagramSocket socketid;
        // Init paquet NULL
        DatagramPacket packet = null;
        // Message reçu
        String messsagerecu;

        // On initialise le socket à partir d'un argument entrer en paramètre
        socketid = new DatagramSocket(Integer.parseInt(args[0]));

        // Try / Catch pour définir packet 
        try {
        packet = new DatagramPacket(new byte[400] ,400); 
        } catch(Exception error){
            error.printStackTrace();
        }
        // Notre socket reçoit le paquet envoyer par l'autre machine ou loopback
        socketid.receive(packet);
        // On return le message reçu dans message recu
        messsagerecu = new String(packet.getData());
        // On print notre message 
        System.out.println(messsagerecu);

        // On ferme le socket 
        socketid.close();
    }    
}

 