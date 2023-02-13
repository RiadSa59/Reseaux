package EX1;


import java.io.*;
import java.net.*;

public class TCPServer{
    // Création du int PORT avec valeur 2022 
    private static final int PORT = 2022;

    public static void main(String[] args)throws SocketException , IOException{
        // Init d'un serveur Socket
        ServerSocket socketserver = null;
        // Init de number of clients 
        int numberofclients=0;

        try {
            //Attribution de PORT à socketserver
            socketserver = new ServerSocket(PORT);
        } catch (IOException e){
            // Message à envoyer en cas d'erreur
            System.err.println("Can't create the server");
            return;
        }
        // While (true) to keep the server Open for connections
        while(true){
            try {
                // Socketco qui représente la connexion d'un client à socketserver
                Socket socketco = socketserver.accept();
                System.out.println("Connection established");
                // On incrémente le nombre de clients
                numberofclients++;
                // Init de outputStream avec la socket de connexion afin d'afficher un message de bienvenue quand le client sera connécté
                OutputStream outputStream = socketco.getOutputStream();
                DataOutputStream data = new DataOutputStream(outputStream);
                // Print de "Hello" sur l'interface du client 
                data.writeUTF("Bienvenue sur mon serveur et au revoir");
                data.writeUTF("Nombre de clients :  "+numberofclients);
                socketco.close();

            }catch (IOException e){
                System.err.println("Can't establish the conenction"+e);
            }

        

        }


    }}





