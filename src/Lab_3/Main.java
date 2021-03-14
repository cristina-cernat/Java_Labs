package Lab_3;

import Lab_3.Interfaces.Visitable;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        City c1 = new City("Iasi");

        Hotel v1 = new Hotel("Hotel 1");
        Museum v2 = new Museum("Museum 1","A");
        Museum v3 = new Museum("Museum 2","B");
        Church v4 = new Church("Church 1","A");
        Church v5 = new Church("Church 2","B");
        Restaurant v6 = new Restaurant("Restaurant 1");

        c1.addLocation(v1);
        c1.addLocation(v2);
        c1.addLocation(v3);
        c1.addLocation(v4);
        c1.addLocation(v5);
        c1.addLocation(v6);

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v3.setCost(v2, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v5.setCost(v4, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        v2.setOpeningTime(LocalTime.of(9, 30));
        v2.setClosingTime(LocalTime.parse("17:00"));
        v4.setOpeningTime(LocalTime.of(8, 30));

        System.out.println(c1);

        System.out.println("Locations that are Visitable but not Payable:");
        c1.printVisitable();

        System.out.println("Duration of the Hotel 1 is:");
        System.out.println(Visitable.getVisitingDuration(v1));

        PriorityQueue<Location> preferenceList = new PriorityQueue<>();
        preferenceList.add(v1);
        preferenceList.add(v3);
//        preferenceList.add(v5);
//        preferenceList.add(v2);
//        preferenceList.add(v4);
//        preferenceList.add(v6);

        TravelPlan travelPlan = new TravelPlan(c1, preferenceList);
        System.out.println("TRAVEL PLAN:");
        System.out.println(travelPlan);

    }
}
