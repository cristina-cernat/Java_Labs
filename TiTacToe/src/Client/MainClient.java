package Client;
/** @author Cernat Cristina */
public class MainClient {
    public static void main(String[] args) {

        Player p = new Player(350, 300);
        p.connectToServer();
        p.setupFrame();
    }
}
