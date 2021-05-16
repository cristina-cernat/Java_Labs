import java.net.*;
import java.io.*;

public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String response = "Hello " + request + "!";
            out.println(response);
            out.flush();

            SocialNetwork socialNetwork = new SocialNetwork();

            if(request.equals("register")) {
                String name = in.readLine();
                Person person = new Person(name);
                socialNetwork.addPerson(person);

                out.println("Welcome, " + person.getName());
                out.flush();
            }

            if(request.equals("stop")) {
                out.println("Server stopped!");
                out.flush();
                socket.close();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
