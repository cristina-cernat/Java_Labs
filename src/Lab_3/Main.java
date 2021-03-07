package Lab_3;

import java.time.LocalTime;

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

        System.out.println(c1);

    }
}
