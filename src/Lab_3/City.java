package Lab_3;

import Lab_3.Interfaces.Payable;
import Lab_3.Interfaces.Visitable;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Location> getNodes() {
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

    /**
     * <p>This method displays the locations that are visitable and not payable
     */
    public void printVisitable() {

        List<Location> temp = new ArrayList<>();
        for(Location location : nodes) {
            if(location instanceof Visitable && !(location instanceof Payable)) {
                temp.add(location);
            }
        }
        Collections.sort(temp);

        for(Location l : temp) {
            System.out.println(l);
        }

    }



}
