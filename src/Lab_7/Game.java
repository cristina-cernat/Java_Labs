package Lab_7;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private final List<Player> players = new ArrayList<>();
    private boolean hasEnded = true;
    private int playerTurn = 0;
    private final Object mutex = new Object();


    public void addPlayer(Player player) {
        this.players.add(player);
        player.setGame(this);
    }


    public boolean hasEnded() {
        return !hasEnded && !board.isEmpty();
    }

    public Player getPlayerAtTurn() {
        if (playerTurn < 0){
            return null;
        }

        return players.get(playerTurn);
    }

    public Object getMutex() {
        return mutex;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void finishTurn(Player player) {
        if (!players.get(playerTurn).equals(player)) {
            throw new RuntimeException("Now it's not your turn...");
        }
    }

    public void start() {
        hasEnded = false;
        playerTurn = -1;

        Thread[] threads = new Thread[players.size()];

        for (int i = 0; i < players.size(); ++i){
            players.get(i).setGraph(new Graph(board.getSize()));

            threads[i] = new Thread(players.get(i));
            threads[i].start();
        }

        playerTurn = 0;

        synchronized (getMutex()) {
            getMutex().notifyAll();
        }

        try {
            for (int i = 0; i < players.size(); ++i) {
                threads[i].join();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        endGame();
    }

    private void endGame() {
        hasEnded = true;
        System.exit(0);
    }
}
