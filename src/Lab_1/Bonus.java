package Lab_1;

public class Bonus {
    public static void main(String[] args) {
        Node initNode = new Node();
        Node.generateTree(initNode, 1);
        Node.printTree(initNode, 0, "", true);
    }
}
