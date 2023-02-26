import java.util.*;
class Cleaner {
    String name;
    String location;
   List<String> assignedJobs;
  public Cleaner(String name, String location) {
        this.name = name;
        this.location = location;
    this.assignedJobs = new ArrayList<>();
    }
}
public class CleaningCompanySystem {
    private static List<Cleaner> cleaners = new ArrayList<>()
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add a cleaner");
            System.out.println("2. Assign a job to a cleaner");
            System.out.println("3. Display jobs assigned to a cleaner");
            System.out.println("4. List all cleaners");
            System.out.println("5. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addCleaner(scanner);
                    break;
            }
           private static void addCleaner(Scanner scanner) {
        System.out.println("Enter cleaner name:");
        String name = scanner.next();
        System.out.println("Enter cleaner location:");
        String location = scanner.next();
        cleaners.add(new Cleaner(name, location));
        System.out.println("Cleaner added successfully");
    }
        }
