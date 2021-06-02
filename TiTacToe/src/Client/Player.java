package Client;
/** @author Cernat Cristina */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.List;

public class Player extends JFrame implements ActionListener{
    private final int width;
    private final int height;
    private final Container content;

    private final JPanel titlePanel = new JPanel();
    private final JPanel buttonsPanel = new JPanel();
    private final JLabel text = new JLabel();
    private final JButton[] buttonsArray = new JButton[9];
    private int playerID;
    private int otherPlayer;


    private final String[] board = new String[9];

    private ClientSideConnection clientSideConnection;



    public class ClientSideConnection {
        private DataOutputStream dataOut;

        public ClientSideConnection() {
            System.out.println("---CLIENT---");
            try {
                Socket socket = new Socket("localhost", 9090);
                DataInputStream dataIn = new DataInputStream((socket.getInputStream()));
                dataOut = new DataOutputStream(socket.getOutputStream());

                playerID = dataIn.readInt();
                System.out.println("Connected to server as Player #" + playerID);

                for(int i = 0; i < 9; i++) {
                    board[i] = dataIn.readUTF();
                }

//                for(int i = 0; i < 9; i++) {
//                    System.out.println("value " + i + board[i]);
//                }

            } catch (IOException ex) {
                System.out.println("IO ex from creating client socket");
            }
        }

        public void sendButton(char c, int position) {
            try {
                dataOut.writeChar(c);
                dataOut.writeInt(position);
                dataOut.flush();
            } catch (IOException ex) {
                System.out.println("IO ex from sending button data");
            }

        }

    }



    public Player (int w, int h){
        width = w;
        height = h;
        content = this.getContentPane();
    }


    public void setupFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setTitle("Tic-Tac-Toe");

        content.setBackground(new Color(55, 60, 80));
        content.setLayout(new BorderLayout());

        // set title text
        text.setBackground(new Color(50, 50, 50));
        text.setForeground(new Color(180, 245, 250));
        text.setFont(new Font("Tekton Pro", Font.PLAIN, 25));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Player #" + playerID);
        text.setOpaque(true);

        // set buttons
        buttonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.setBackground(new Color(255, 200, 200));

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0, width, height/5);
        titlePanel.add(text);

        content.add(titlePanel, BorderLayout.NORTH);


        for(int i = 0; i<9; i++) {
            buttonsArray[i] = new JButton(" ");
            buttonsPanel.add(buttonsArray[i]);
            buttonsArray[i].setFocusable(false);
            buttonsArray[i].addActionListener(this);
        }


        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        content.add(buttonsPanel, BorderLayout.CENTER);

        if (playerID == 1) {
            text.setText("Player #1, X");
            otherPlayer = 2;

        } else {
            text.setText("Player #2, 0");
            otherPlayer = 1;

        }


        this.setVisible(true);
    }


    public void check() {
        //check X win
        if((buttonsArray[0].getText().equals("X"))
                && (buttonsArray[1].getText().equals("X"))
                && (buttonsArray[2].getText().equals("X"))) {
            xWins(0,1,2);
        }
        if((buttonsArray[3].getText().equals("X"))
                && (buttonsArray[4].getText().equals("X"))
                && (buttonsArray[5].getText().equals("X"))) {
            xWins(3,4,5);
        }
        if((buttonsArray[6].getText().equals("X"))
                && (buttonsArray[7].getText().equals("X"))
                && (buttonsArray[8].getText().equals("X"))) {
            xWins(6,7,8);
        }
        if((buttonsArray[0].getText().equals("X"))
                && (buttonsArray[3].getText().equals("X"))
                && (buttonsArray[6].getText().equals("X"))) {
            xWins(0,3,6);
        }
        if((buttonsArray[1].getText().equals("X"))
                && (buttonsArray[4].getText().equals("X"))
                && (buttonsArray[7].getText().equals("X"))) {
            xWins(1,4,7);
        }
        if((buttonsArray[2].getText().equals("X"))
                && (buttonsArray[5].getText().equals("X"))
                && (buttonsArray[8].getText().equals("X"))) {
            xWins(2,5,8);
        }
        if((buttonsArray[0].getText().equals("X"))
                && (buttonsArray[4].getText().equals("X"))
                && (buttonsArray[8].getText().equals("X"))) {
            xWins(0,4,8);
        }
        if((buttonsArray[2].getText().equals("X"))
                && (buttonsArray[4].getText().equals("X"))
                && (buttonsArray[6].getText().equals("X"))) {
            xWins(2,4,6);
        }


        //check O win
        if((buttonsArray[0].getText().equals("O"))
                && (buttonsArray[1].getText().equals("O"))
                && (buttonsArray[2].getText().equals("O"))) {
            oWins(0,1,2);
        }
        if((buttonsArray[3].getText().equals("O"))
                && (buttonsArray[4].getText().equals("O"))
                && (buttonsArray[5].getText().equals("O"))) {
            oWins(3,4,5);
        }
        if((buttonsArray[6].getText().equals("O"))
                && (buttonsArray[7].getText().equals("O"))
                && (buttonsArray[8].getText().equals("O"))) {
            oWins(6,7,8);
        }
        if((buttonsArray[0].getText().equals("O"))
                && (buttonsArray[3].getText().equals("O"))
                && (buttonsArray[6].getText().equals("O"))) {
            oWins(0,3,6);
        }
        if((buttonsArray[1].getText().equals("O"))
                && (buttonsArray[4].getText().equals("O"))
                && (buttonsArray[7].getText().equals("O"))) {
            oWins(1,4,7);
        }
        if((buttonsArray[2].getText().equals("O"))
                && (buttonsArray[5].getText().equals("O"))
                && (buttonsArray[8].getText().equals("O"))) {
            oWins(2,5,8);
        }
        if((buttonsArray[0].getText().equals("O"))
                && (buttonsArray[4].getText().equals("O"))
                && (buttonsArray[8].getText().equals("O"))) {
            oWins(0,4,8);
        }
        if((buttonsArray[2].getText().equals("O"))
                && (buttonsArray[4].getText().equals("O"))
                && (buttonsArray[6].getText().equals("O"))) {
            oWins(2,4,6);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 9; i++) {
            if(e.getSource() == buttonsArray[i]) {
                if(playerID == 1) {
                    if(buttonsArray[i].getText().equals(" ")) {
                        buttonsArray[i].setForeground(new Color(80, 22, 22, 255));
                        buttonsArray[i].setText("X");
                        buttonsArray[i].setFont(new Font("Segoe UI", Font.PLAIN, 30));
                        playerID = 2;


                        clientSideConnection.sendButton('X', i);

                        text.setText("0 turn");
                        check();
                    }

                } else {

                    if(buttonsArray[i].getText().equals(" ")) {
                        buttonsArray[i].setForeground(new Color(17, 17, 97));
                        buttonsArray[i].setText("O");
                        buttonsArray[i].setFont(new Font("Segoe UI", Font.PLAIN, 30));
                        playerID = 1;

                        clientSideConnection.sendButton('O', i);

                        text.setText("X turn");
                        check();
                    }
                }

            }
        }
    }

    public void connectToServer () {
        clientSideConnection = new ClientSideConnection();

    }

    public void xWins(int a, int b, int c) {
        buttonsArray[a].setBackground(new Color(154, 194, 255));
        buttonsArray[b].setBackground(new Color(154, 194, 255));
        buttonsArray[c].setBackground(new Color(154, 194, 255));

        for(int i = 0; i < 9; i++) {
            buttonsArray[i].setEnabled(false);
        }
        text.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttonsArray[a].setBackground(new Color(154, 194, 255));
        buttonsArray[b].setBackground(new Color(154, 194, 255));
        buttonsArray[c].setBackground(new Color(154, 194, 255));

        for(int i = 0; i < 9; i++) {
            buttonsArray[i].setEnabled(false);
        }
        text.setText("O wins");
    }
}
