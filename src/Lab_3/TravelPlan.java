package Lab_3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TravelPlan {
    private City city;
    private PriorityQueue<Location> preferenceList = new PriorityQueue<>();

    public TravelPlan() {}

    public TravelPlan(City city, PriorityQueue<Location> preferenceList) {
        this.city = city;
        this.preferenceList = preferenceList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public PriorityQueue<Location> getPreferenceList() {
        return preferenceList;
    }

    public void setPreferenceList(PriorityQueue<Location> preferenceList) {
        this.preferenceList = preferenceList;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("name = ").append(city.getName()).append("\n").append("preferred locations =\n");
        for(Location element : getPreferenceList()) {
            str.append(element.toString());
        }
        return str.toString();
    }



}
