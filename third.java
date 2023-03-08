import java.util.*;

class Cleaner {
    private String name;
    private int id;
    private String location;
    private ArrayList<String> jobsAssigned;

    public Cleaner(String name, int id, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.jobsAssigned = new ArrayList<String>();
    }
public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void assignJob(String job) {
        jobsAssigned.add(job);
    }

    public ArrayList<String> getJobsAssigned() {
        return jobsAssigned;
    }
}

public class CleaningCompanySystem {
    private ArrayList<Cleaner> cleaners;

    public CleaningCompanySystem() {
        cleaners = new ArrayList<Cleaner>();
    }
  public static void main(String[] args) {
        CleaningCompanySystem obj = new CleaningCompanySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Cleaning Company System =====");
            System.out.println("1. Add Cleaner");
            System.out.println("2. List Cleaners");
            System.out.println("3. Assign Job");
            System.out.println("4. List Jobs Assigned to Cleaner");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
         

            switch (choice) {
                case 1:
                    obj.addCleaner();
                    break;
                case 2:
                    obj.listCleaners();
                    break;
                case 3:
                    obj.assignJob();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
  }
  public void addCleaner() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name of cleaner: ");
        String name = scanner.nextLine();

        System.out.print("Enter ID of cleaner: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter location of cleaner: ");
        String location = scanner.nextLine();

        Cleaner cleaner = new Cleaner(name, id, location);
        cleaners.add(cleaner);

        System.out.println("Cleaner added successfully");
    }
  public void listCleaners() {
        if (cleaners.isEmpty()) {
            System.out.println("No cleaners in the system");
            return;
        }

        System.out.println("List of cleaners:");
        for (Cleaner cleaner : cleaners) {
            System.out.println("Name: " + cleaner.getName() + ", ID: " + cleaner.getId() + ", Location: " + cleaner.getLocation());
        }
    }
  
  public void assignJob() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ID of cleaner: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cleaner cleaner = findCleanerById(id);
        if (cleaner == null) {
            System.out.println("Cleaner with ID " + id + " not found");
            return;
        }

        System.out.print("Enter job to assign to cleaner: ");
        String job = scanner.nextLine();
        cleaner.assignJob(job);

        System.out.println("Job assigned to cleaner successfully");
    }
   private Cleaner findCleanerById(int id) {
        for (Cleaner cleaner : cleaners) {
            if (cleaner.getId() == id) {
                return cleaner;
            }
        }

        return null;
    }
  
}
