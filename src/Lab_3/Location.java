package Lab_3;

import Lab_3.Interfaces.Visitable;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location>{
    private String name;
    private final Map<Location, Integer> cost = new HashMap<>();

    public Location() {}

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("name = ").append(name).append("\n");

        // In case I want to display the cost of each node:
//        str.append("cost=");
//        for (Map.Entry<Location, Integer> entry : cost.entrySet()) {
//            str.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
//        }
        return str.toString();
    }

    @Override
    public int compareTo(Location other) {
        if (((Visitable) this).getOpeningTime() == null && ((Visitable) other).getOpeningTime() != null){
            return -1;
        }
        else if (((Visitable) this).getOpeningTime() != null && ((Visitable) other).getOpeningTime() == null){
            return 1;
        }
        else if (((Visitable) this).getOpeningTime() != null){
            int result = ((Visitable) this).getOpeningTime().compareTo(((Visitable) this).getOpeningTime());
            if (result != 0){
                return result;
            }
        }
        assert ((Visitable) other).getOpeningTime() != null;
        return ((Visitable) this).getOpeningTime().compareTo(((Visitable) other).getOpeningTime());

    }
}
