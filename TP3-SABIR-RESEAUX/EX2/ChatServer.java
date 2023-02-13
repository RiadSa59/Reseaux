import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatServer {

    //Port 
    public static final int PORT = 2022;

    // Création de la sokcet du serveur 
    private ServerSocket serverSocket;
    // Création de la liste des threads des  clients 
    private List<ClientThread> clientThreads = new ArrayList<ClientThread>();

    // Add Client to clientThreads 
    public void connect(Socket socket) {
        try {
            clientThreads.add(new ClientThread(socket));
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    // Disconnect Client by removing him from clientThreads
    public void disconnect(ClientThread client) {
        Iterator<ClientThread> itr = clientThreads.iterator();
        while(itr.hasNext()) {
            if (itr.next().equals(client))
                itr.remove();
            break;
        }
    }


    // Méthode pour envoyer le message à toutes les sockets connéctées au serveur à part celle du client qui l'a envoyé 
    public void broadcast(ClientThread activeClient, String message) {
        for(ClientThread client: clientThreads) {
            if(!client.equals(activeClient))
                client.sendMessage(message);
        }
    }

    // Init du serveur (même que celle de TCPServer )
    public void process() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on " + PORT);
            while(true) {
                Socket socket = serverSocket.accept();
                connect(socket);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }
    }


    // Méthode main pour lancer le serveur 
    public static void main(String[] args) {
       // On lance le serveur 
        new ChatServer().process();
    }
    
    private class ClientThread extends Thread {
        // Socket du client 
        private Socket clientSocket;
        // Input du client 
        private BufferedReader input;
        // Output vu par le client 
        private PrintWriter output;
    
        // Init de ClientThread avec l'attribut socket 
        public ClientThread(Socket socket) throws IOException {
            this.clientSocket = socket;
            // L'input du client afin qu'il puisse envoyer un message 
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Output qui permettera de lire les messages des autres clients 
            output = new PrintWriter(clientSocket.getOutputStream(),true);
            // Méthode start de thread
            start();
        }
        
        // Méthode pour lire les messages envoyés par les autres clients 
        public void readMessage(String message) {
            broadcast(this, message);
        }


        // Méthode pour envoyer un message aux autres clients 
        public void sendMessage(String message) {
            output.println(message);
        }
        // Déconnecter le client du serveur 
        public void close() {
            try {
                if(input != null)
                    input.close();
                if(output != null)
                    output.close();
                if(clientSocket != null)
                    clientSocket.close();
                disconnect(this);
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }
        // Intéraction Client - Serveur 
        public void run() {
            String message;
            try {
                while(true) {
                    message = input.readLine();
                    if(message == null) {
                        close();
                        break;
                    }
                    readMessage(message);
                }
            } catch (IOException e) {
                System.out.print(e.getMessage());
            } finally {
                close();
            }
        }
    
    }


    

}