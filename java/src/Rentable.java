import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rentable {
    public String name;
    private Boolean rented = false;

    public Rentable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new  IllegalArgumentException("Please, enter a name");
        }
        this.name = name;
    }

    public void rent(float duration) {
        if(duration <= 0) {
            throw  new IllegalArgumentException("Please, enter a positive duration");
        }
        else {
            if (this.rented == false) {
                this.rented = true;
                System.out.println("You rented a " + this.name + " for " + duration + " days.");
            } else {
                System.out.println("This item is already rented");
            }
        }
        LocalDate availableDate = countDays(duration);
        System.out.println("The rental will be terminated until "+availableDate);
    }

    private LocalDate countDays(float duration) {
        LocalDateTime now = LocalDateTime.now();
        int aDayToHours = 24;
        int anHourToMinutes = 60;
        int aMinuteToSeconds = 60;
        LocalDateTime newDate = now.plusSeconds((long)(duration*aDayToHours*anHourToMinutes*aMinuteToSeconds));
        return newDate.toLocalDate();
    }

    @Override
    public String toString() {
        return "Rentable{" +
                "name='" + name + '\'' +
                ", rented=" + rented +
                '}';
    }
}
