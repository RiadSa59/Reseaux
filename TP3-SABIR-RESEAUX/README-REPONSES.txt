Exercice 1 : 
 Q1 . Les étapes de traitement d'une requête TCP entre un server et un client sont les suivantes :
    Du côté du serveur : 
    1- Créer une socket serveur TCP 
    2- Associer la socket à une adresse IP et un numéro de port TCP loceaux
    3- définir la taille de la file d'attente pour les nouvelles connexions
    4- Permettre à l'application ( côté serveur ) de prendre connaissance d'une nouvelle connexion
    5- Obtention d'un canal de communication/dialogue par l'application (côté serveur)
    Du côté client :
    1- Créer uen socket 
    2- Associer la socket à une adresse ou un numéro de port (locaux) particuliers.
    3- Établir une connexion entre la socket client et le serveur 


Q2 . une exception IOException est levée en cas d’échec de la connexion du client au serveur.
     une exception IOException est levée en cas d'échec de la création du serveur avec le port associé.
     une exception IOException est levée en cas d'échec de la création de la socket côté Serveur ou Client .


Q3 . Soit par des tests ce qui sera un peu long et compliqué .
    Ou Bien on compile notre TCPServer.java puis on l'exécute et on établit une connexion
    à ce dernier à travers telnet en tapant la commande suivante dans notre terminal:
    telnet 127.0.0.1 2022 ; tel que 127.0.0.1 l'adresse de loopback et 2022 le port associé à notre serveur .

Q4 . pour garder le serveur ouvert on crée une boucle infinie avec un while(true){} et on peut garder les traces dans un fichier log.txt et avec une var numberofclients qu'on incrémentera à chaque connexion.

Exercice 2 :

Q1- 
Le plus simple est de déporter la boucle read/write dans un nouveau thread, ce qui permet donc au
thread principal de retourner immédiatement effectuer l’accept suivant. Pour faire tourner la boucle
dans un thread, il faut créer une classe MonThread héritant de la classe Thread, possédant une méthode
run dans laquelle on place la boucle. Pour passer la socket à ce thread, il suffit d’ajouter une variable de
classe Socket client, et un constructeur qui prend la socket en paramètre et la stocke dans la variable
de classe.
Pour lancer le thread proprement dit, il suffit alors de créer une instance de la classe MonThread en
lui passant la socket en paramètre, puis d’appeler sa méthode start, c’est cette méthode qui créera le
thread qui appelera la méthode run, en parallèle du thread principal qui s’empressera alors de retourner
appeler select.


Q2 - Les primitives permettant de recevoir des chaines de caractères sur une Socket sont les appels sendto et readfrom se font octet par octet. 
On ne lis qu’un octet à la fois il s'agit de la manière la plus simple d’être plus efficace, c’est d’utiliser
des BufferedReader et PrintStream de Java 1 , construits à partir des InputStream et OutputStream.

Q3 - il suffit d’écrire non seulement sur la socket qui a envoyé le message, mais aussi à toutes les autres sockets. Il  faut donc stocker les sockets
clientes pour pouvoir itérer dessus, à l’aide d’un object set de la classe Set par exemple ou une classe Incluse de ChatServer comme ClientsThreads.

Q4 - Pour garder la trace de toutes les connexion ayant eu lieu on utilise d'une var numberofclients et un fichier log.

Q5 -Pour s'assurer du bon fonctionnement de l'application on implémente une méthode disconnect côté client . 


