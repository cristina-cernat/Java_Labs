package Server;
/** @author Cernat Cristina */
import java.io.*;
import java.net.Socket;

public class ServerSideConnection implements Runnable {
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private int playerID;
    private final String[] board = new String[9];

    public ServerSideConnection(Socket socket, int id) {
        this.socket = socket;
        playerID = id;

        for(int i = 0; i < 9; i++) {
            board[i] = " ";
        }

        try {
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("IO ex from constructing ssc");
        }
    }

    @Override
    public void run() {
        try{
            dataOut.writeInt(playerID);
            for(int i = 0; i < 9 ;i++) {
                dataOut.writeUTF(board[i]);
            }
            dataOut.flush();

            while (true) {
                if(playerID == 1) {
                    String player1Button = dataIn.readUTF();
                    System.out.println("Player 1 clicked button " + player1Button);

                }
                else {
                    String player2Button = dataIn.readUTF();
                    System.out.println("Player 2 clicked button " + player2Button);
                }

            }
        } catch (IOException e) {
            System.out.println("IO ex from run() in ssc");
        }

    }

    public void sendButton(char c, int position) {
        try{
            dataOut.writeChar(c);
            dataOut.writeInt(position);
            dataOut.flush();
        } catch (IOException ex) {

        }

    }
}
