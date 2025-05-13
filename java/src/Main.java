import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Enter the name of the object to be rented and the duration of the rental
        System.out.println("What do you want to rent?");
        String name = scanner.nextLine();
        System.out.println("Please enter the duration (for days)");
        float duration = scanner.nextFloat();

        //Create a new rentable
        Rentable rentable = new Rentable(name);
        System.out.println(rentable.getName());
        System.out.println(rentable.getRented());
        rentable.rent(duration);
    }
}