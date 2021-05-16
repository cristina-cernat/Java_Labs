import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SimpleClient {

    private final String[] requests = {"register", "login", "stop", "exit"};
    private final static String serverAddress = "127.0.0.1";
    private final static int PORT = 9090;

    public static void main (String[] args) throws IOException {

        SimpleClient client = new SimpleClient();
        try (Socket socket = new Socket(serverAddress, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server
            String request = "World";
            out.println(request);
            String response = in.readLine ();
            System.out.println(response);

            while(true) {
                String req = client.readRequestFromKeyboard();
                if(req.equals("exit")) {
                    break;
                } else if(req.equals("0")) {
                    System.out.println("Invalid command!");
                } else {
                    client.sendRequestToServer(request);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

    private String readRequestFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        for(String i : requests) {
            if(text.equals(i)) {
                return text;
            }
        }
        return "0";
    }


    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    public void sendRequestToServer(String request) throws IOException {

        try (Socket socket = new Socket(serverAddress, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(request);
            out.flush();

            if (request.equals("register")) {
                String person = this.readFromKeyboard();
                out.println(person);
                out.flush();

                String response = in.readLine();
                System.out.println(response);
            }

            if (request.equals("login")) {
                String tryNumber = this.readFromKeyboard();
                out.println(tryNumber);
                out.flush();

                String response = in.readLine();
                System.out.println(response);
            }

            if (request.equals("stop")) {
                String response = in.readLine();
                System.out.println(response);
            }

        } catch (UnknownHostException e) {
            System.err.println("Server not found " + e);
            System.exit(1);
        }
    }

}