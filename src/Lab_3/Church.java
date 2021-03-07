package Lab_3;

import Lab_3.Interfaces.Classifiable;
import Lab_3.Interfaces.Visitable;

import java.time.LocalTime;

public class Church extends Location implements Visitable, Classifiable {
    private String rank;

    public Church() {
        Visitable.super.defaultSchedule();
    }

    public Church(String rank) {
        this.rank = rank;
        Visitable.super.defaultSchedule();
    }

    public Church(String name, String rank) {
        super(name);
        this.rank = rank;
        Visitable.super.defaultSchedule();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String getRank() {
        return this.rank;
    }

    @Override
    public void setOpeningTime(LocalTime openingTime) {

    }

    @Override
    public void setClosingTime(LocalTime closingTime) {

    }

    @Override
    public LocalTime getOpeningTime() {
        return null;
    }

    @Override
    public LocalTime getClosingTime() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.getName()).append("\n");
        str.append("rank = ").append(rank).append("\n");
        return str.toString();
    }
}
