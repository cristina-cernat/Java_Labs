package Lab_3.Interfaces;

import java.time.LocalTime;
public interface Visitable {
    void setOpeningTime(LocalTime openingTime);
    void setClosingTime(LocalTime closingTime);

    LocalTime getOpeningTime();
    LocalTime getClosingTime();

    default void defaultSchedule(){
        LocalTime openingTime = LocalTime.of(8,0);
        LocalTime closingTime = LocalTime.of(12,0);
        setOpeningTime(openingTime);
        setClosingTime(closingTime);
    }

}
