package Lab_3.Interfaces;

import java.time.Duration;
import java.time.LocalTime;
public interface Visitable {
    void setOpeningTime(LocalTime openingTime);
    void setClosingTime(LocalTime closingTime);

    LocalTime getOpeningTime();
    LocalTime getClosingTime();

    default void defaultSchedule(){
        LocalTime openingTime = LocalTime.of(9,30);
        LocalTime closingTime = LocalTime.of(20,0);
        setOpeningTime(openingTime);
        setClosingTime(closingTime);
    }

    static Duration getVisitingDuration(Visitable node){
        TemporaryNode location = new TemporaryNode();

        location.setOpeningTime(node.getOpeningTime());
        location.setClosingTime(node.getClosingTime());

        return Duration.between(location.getClosingTime(),location.getOpeningTime());

    }

    class TemporaryNode {
        private LocalTime openingTime, closingTime;

        public void setClosingTime(LocalTime closingTime) {
            this.closingTime = closingTime;
        }

        public void setOpeningTime(LocalTime openingTime) {
            this.openingTime = openingTime;
        }

        public LocalTime getClosingTime() {
            return closingTime;
        }

        public LocalTime getOpeningTime() {
            return openingTime;
        }


    }
}
