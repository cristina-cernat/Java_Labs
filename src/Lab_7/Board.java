package Lab_7;

public class Board {
    private final Graph graph;
    private int size;

    public Board(int graphSize) {
        size = graphSize;
        graph = new Graph(graphSize);

        initCompleteGraph();
        shuffleTokens();
    }

    public Graph getGraph() {
        return graph;
    }

    public int getSize() {
        return size;
    }

    private void initCompleteGraph() {
        for (int first = 1; first <= size; first++)
            for (int second = first + 1; second <= size; second++) {
                Token e = new Token(first, second);
                graph.addToken(e);
            }
    }


    private void shuffleTokens() {
        int shuffleNumber = graph.getTokens().size()/2;

        for (int i = 0; i < shuffleNumber; i++) {
            int firstRandomToken = RandomGenerator.getRandomInt(size);
            int secondRandomToken = RandomGenerator.getRandomInt(size);

            graph.swap(firstRandomToken, secondRandomToken);
        }
    }

    public synchronized Token extract() {
        int tokenNumber = RandomGenerator.getRandomInt(graph.getTokens().size());

        Token token = graph.removeToken(tokenNumber);
        System.out.println("Extracted token with the pair (" + token.getFirst() + ", " + token.getSecond() + ").");
        return token;
    }

    public boolean isEmpty() {
        return graph.getTokens().isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Board").append(graph.toString()).append("\n");
        return str.toString();
    }
}
