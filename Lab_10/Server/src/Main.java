import java.io.IOException;

public class Main {
    public static void main ( String [] args ) throws IOException {
        SimpleServer server = new SimpleServer ();
        server.init();
        server.waitForClients();
    }
}
