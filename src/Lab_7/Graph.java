package Lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    private List<Token> tokens;
    private int nodesNumber;

    public Graph(int graphSize) {
        nodesNumber = graphSize;
        tokens = new ArrayList<>();
    }

    public void addToken(Token token)
    {
        tokens.add(token);
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void swap(int firstToken, int secondToken) {
        Collections.swap(tokens, firstToken, secondToken);
    }

    public void add(Token extract) {
        tokens.add(extract);
    }

    public Token removeToken(int tokenNumber) {
        Token token = tokens.get(tokenNumber);
        tokens.remove(token);

        return token;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n").append("size = ").append(nodesNumber).append(" x ").append(nodesNumber - 1).append("\n");
        for(Token t : tokens) {

            str.append(t.toString());

        }

        return  str.toString();
    }

//    @Override
//    public String toString() {
//        return  "nodes number " + nodesNumber +
//                "tokens= {" + tokens + "}";
//    }
}
