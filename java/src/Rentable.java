import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rentable {
    public String name;
    private Boolean rented;
    private float duration;

    public Rentable(String name) {
        this.name = name;
        this.rented = false;
        this.duration = 0;
    }

    public String getName() {
        return name;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Please, enter a name");
        }
        this.name = name;
    }

    public void rent(float duration) {
        if(duration <= 0) {
            throw new IllegalArgumentException("Please, enter a positive duration");
        } else {
            if (!this.rented) {
                this.rented = true;
                this.duration = duration;
                System.out.println("You rented a " + this.name + " for " + duration + " days.");
                System.out.println("The rental will be terminated until " + countDays(duration));
            } else {
                System.out.println("This item is already rented");
            }
        }
    }

    private LocalDate countDays(float duration) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime newDate = now.plusSeconds((long)(duration * 24 * 60 * 60));
        return newDate.toLocalDate();
    }

    public String getAvailability() {
        if (rented) {
            return "This item will be available on: " + countDays(duration);
        } else {
            return "This item is currently available.";
        }
    }

    @Override
    public String toString() {
        return "Rentable{" +
                "name='" + name + '\'' +
                ", rented=" + rented +
                ", duration=" + duration +
                '}';
    }
}
