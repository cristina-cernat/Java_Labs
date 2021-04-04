package Lab_7;

public class Player implements Runnable{
    private String name;
    private Game game;
    private Graph graph;

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (game.hasEnded()) {

            while (!this.equals(game.getPlayerAtTurn()) && game.hasEnded()) {
                synchronized (game.getMutex()) {
                    try {
                        game.getMutex().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println(this.name + " turn:");

            if (game.hasEnded()) {
                try {
                    play();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                game.finishTurn(this);
            }
        }
    }

    private void play() throws InterruptedException {
            Board board = game.getBoard();

            if (board.isEmpty()) {
                return;
            }

            graph.add(board.extract());
            Thread.sleep(10);
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
