package Lab_3;

import Lab_3.Interfaces.Classifiable;
import Lab_3.Interfaces.Payable;
import Lab_3.Interfaces.Visitable;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable, Classifiable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    private String rank;

    public Museum() {
        Visitable.super.defaultSchedule();
    }

    public Museum(String rank) {
        this.rank = rank;
        Visitable.super.defaultSchedule();
    }

    public Museum(String name, String rank) {
        super(name);
        this.rank = rank;
        Visitable.super.defaultSchedule();
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
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.getName()).append("\n");
        str.append("openingTime = ").append(openingTime).append(", closingTime = ").append(closingTime).append("\n")
                .append("ticketPrice = ").append(ticketPrice).append(", rank = ").append(rank).append("\n");
        return str.toString();
    }
}
