import java.net.*;
import java.io.*;


public class SimpleServer {
    public static final int PORT = 9090;
    private ServerSocket serverSocket;
    private boolean running = false;

    public SimpleServer() {
    }

    public void init() {
        try{
            serverSocket = new ServerSocket(PORT);
            this.running = true;
        } catch(IOException e) {
            System.err.println("IO error " + e);
        }
    }

    public void waitForClients() {
        while(this.running) {
            System.out.println("Waiting for clients...");
            try {
                Socket socket = serverSocket.accept();
                ClientThread t = new ClientThread(socket);
                t.start();
            } catch(IOException e) {
                System.err.println("Accept failed " + e);
            }
        }
    }

    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }

}