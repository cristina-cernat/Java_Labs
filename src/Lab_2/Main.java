package Lab_2;


import java.util.ArrayList;
import java.util.List;

import static Lab_2.SourceType.FACTORY;
import static Lab_2.SourceType.WAREHOUSE;

public class Main {
    public static void main(String[] args) {

        // Basic initializations

        Source s1 = new Source();
        s1.setName("S1");
        s1.setType(WAREHOUSE);
        Source s2 = new Source("S2", FACTORY);
        Source s3 = new Source("S3", FACTORY);


        Destination d1 = new Destination("D1");
        Destination d2 = new Destination("D2");
        Destination d3 = new Destination("D3");

        // Declare and initialize lists of sources and destinations

        List<Source> listOfSources = new ArrayList<>();
        List<Destination> listOfDestinations = new ArrayList<>();

        listOfSources.add(s1);
        listOfSources.add(s2);
        listOfSources.add(s3);

        listOfDestinations.add(d1);
        listOfDestinations.add(d2);
        listOfDestinations.add(d3);


        // cost matrix
        int[][] costMatrix = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };

        Problem pb = new Problem();
        pb.setCost(costMatrix);
        pb.setSources(listOfSources);
        pb.setDestinations(listOfDestinations);

        // demand + supply
        int[] supply = {10, 35, 25};
        int[] demand = {20, 25, 25};
        pb.setSupply(supply);
        pb.setDemand(demand);

        System.out.println(pb);

    }

}
