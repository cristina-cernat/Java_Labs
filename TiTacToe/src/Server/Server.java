package Server;
/** @author Cernat Cristina */
import java.io.*;
import java.net.*;
public class Server {
    private ServerSocket serverSocket;
    private int numPlayers;

    private ServerSideConnection player1;
    private ServerSideConnection player2;

    public Server() {
        System.out.println("---SERVER---");
        numPlayers = 0;

        try{
            serverSocket = new ServerSocket(9090);
        } catch (IOException ex) {
            System.out.println("IO exception from server constructor");
        }
    }

    public void acceptConnections() {
        try {
            System.out.println("Waiting for connections..");
            while(numPlayers < 2) {
                Socket socket = serverSocket.accept();
                numPlayers++;
                System.out.println("Player #" + numPlayers + " has connected");

                ServerSideConnection serverSideConnection = new ServerSideConnection(socket, numPlayers);

                if(numPlayers == 1) {
                    player1 = serverSideConnection;
                } else {
                    player2 = serverSideConnection;
                }

                Thread thread = new Thread(serverSideConnection);
                thread.start();

            }
            System.out.println("We now have 2 players, no more connections!");
        } catch (IOException ex) {
            System.out.println("IO ex from acceptConnection");

        }
    }



    public static void main(String[] args) {
        Server server = new Server();
        server.acceptConnections();
    }
}
