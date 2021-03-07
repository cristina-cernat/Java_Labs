package Lab_3;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private final List<Location> nodes = new ArrayList<>();

    public City() {}
    public City(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getList() {
        return nodes;
    }

    public void addLocation(Location node) {
        this.nodes.add(node);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("name = ").append(name).append("\n").append("nodes =\n");
        for(Location element : nodes) {
            str.append(element.toString());
        }
        return str.toString();
    }
}
