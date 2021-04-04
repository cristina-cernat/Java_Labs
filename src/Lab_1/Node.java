package Lab_1;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final List<Node> children = new ArrayList<>();
    private Node parent;
    static int node = 0;

    public void setParent(Node parent) {
        this.parent = parent;
    }
    public Node getParent() {
        return parent;
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return children;
    }


    static void generateTree(Node tree, int level) {
        if (((int) (Math.random() * 10 % 2)) != 0) {
            Node Child = new Node();
            Child.setParent(tree);
            tree.addChild(Child);
            generateTree(Child, level + 1);
        }
        else {
            if(tree.getParent() != null)
                generateTree(tree.getParent(), level - 1);
        }
    }

    public static void printTree(Node tree, int level, String indent, boolean last) {
        System.out.println(indent + "+- " + "node" + node);
        indent += last ? "   " : "|  ";
        List<Node> temporaryChildren = tree.getChildren();

        for (int i = 0; i < tree.getChildren().size(); i++)
        {
            node++;
            printTree(temporaryChildren.get(i), level + 1, indent, i == tree.getChildren().size() - 1);
        }
    }

}
