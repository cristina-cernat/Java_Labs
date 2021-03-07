package Lab_3;

import Lab_3.Interfaces.Visitable;

import java.time.LocalTime;

public class Hotel extends Location implements Visitable {
    private LocalTime openingTime, closingTime;

    public Hotel() {
        Visitable.super.defaultSchedule();
    }
    public Hotel(String name) {
        super(name);
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


    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.getName()).append("\n");
        str.append("openingTime = ").append(openingTime).append(", closingTime = ").append(closingTime).append("\n");
        return str.toString();
    }
}
