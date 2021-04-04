package Lab_7;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board(4);
        System.out.println(board.toString());
        game.setBoard(board);
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.start();
    }
}
