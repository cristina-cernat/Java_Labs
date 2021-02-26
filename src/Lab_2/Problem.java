package Lab_2;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Problem {
    private List<Source> sources = new ArrayList<>();
    private List<Destination> destinations = new ArrayList<>();
    private int[] supply;
    private int[] demand;
    private int[][] cost;

    // Getters + setters

    public void setSources(List<Source> sourcesInput) {
        this.sources = sourcesInput;
    }

    public void setDestinations(List<Destination> destinationsInput) {
        this.destinations = destinationsInput;

    }

    public void setCost(int[][] costMatrix) {
        int length = costMatrix.length;
        cost = new int[length][costMatrix[0].length];
        for (int i = 0; i < length; i++)
            System.arraycopy(costMatrix[i], 0, cost[i], 0, costMatrix[i].length);
    }

    // set supply, set demand
    public void setSupply(int[] supplyInput) {
        supply = new int[supplyInput.length];
        System.arraycopy(supplyInput, 0, this.supply, 0, supplyInput.length);
    }

    public void setDemand(int[] demandInput) {
        demand = new int[demandInput.length];
        System.arraycopy(demandInput, 0, this.demand, 0, demandInput.length);
    }

    @Override
    public String toString() {
        String outCost = "";

        for (int i = 0; i < cost.length; i++) {
            outCost += Arrays.toString(cost[i]) + "\n";
        }
        return "sources=" + sources.toString() + "\n" +
                "destinations=" + destinations.toString() + "\n" +
                "supply=" + Arrays.toString(supply) + "\n" +
                "demand=" + Arrays.toString(demand) + "\n" +
                "cost=" + "\n" + outCost;

    }
}
