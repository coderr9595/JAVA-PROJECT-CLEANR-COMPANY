//overall project has done using java in this we also uses File handling and Exception handling...



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

// -------------------------------------------------------------------------------------------

public class CleaningCompanySystem {
    private ArrayList<Cleaner> cleaners;

    public CleaningCompanySystem() {
        cleaners = new ArrayList<Cleaner>();
    }

    public static void main(String[] args) throws IOException {
        CleaningCompanySystem obj = new CleaningCompanySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Cleaning Company System =====");
            System.out.println("1. Add Cleaner");
            System.out.println("2. List Cleaners");
            System.out.println("3. Assign Job");
            System.out.println("4. List Jobs Assigned to Cleaner");
            System.out.println("5. show report data");
            System.out.println("6. Exit");
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
                case 4:
                    obj.listJobsAssigned();
                    break;
                case 5:
                    obj.report();
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void addCleaner() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = " ";
        int id = 0;
        String location = " ";
        System.out.print("Enter name of cleaner: ");
        try {
            name = scanner.nextLine();
        } catch (Exception a) {
            System.out.println("i need a string input !!" + a);
        }

        System.out.print("Enter ID of cleaner: ");
        try {
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception b) {
            System.out.println("i need a  Integer input !!" + b);

        }

        System.out.print("Enter location of cleaner: ");

            location = scanner.nextLine();



        Cleaner cleaner = new Cleaner(name, id, location);
        cleaners.add(cleaner);

        char name_arry[] = name.toCharArray();
        String id_data = String.valueOf(id);
        char id_array[] = id_data.toCharArray();
        char location_array[] = location.toCharArray();

        // File f1 = new File("javaproject.txt");
        FileOutputStream f1 = new FileOutputStream("javaproject.txt", true);

        for (int i = 0; i < name.length(); i++) {
            f1.write(name_arry[i]);
        }
        for (int i = 0; i < id_data.length(); i++) {
            f1.write(id_array[i]);
        }

        for (int i = 0; i < location.length(); i++) {
            f1.write(location_array[i]);
        }
        f1.close();

        System.out.println("Cleaner added successfully... ");

    }

    public void report() throws IOException {
        int i;
        FileInputStream f1 = new FileInputStream("javaproject.txt");
        do {
            i = f1.read();
            if (i != -1) {
                System.out.print((char) i);
            }

        } while (i != -1);

    }

    public void listCleaners() {
        if (cleaners.isEmpty()) {
            System.out.println("No cleaners in the system");
            return;
        } else {
            System.out.println("List of cleaners:");
            for (Cleaner cleaner : cleaners) {
                System.out.println(
                        "Name: " + cleaner.getName() + ", ID: " + cleaner.getId() + ", Location: "
                                + cleaner.getLocation());
            }
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

    public void listJobsAssigned() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ID of cleaner: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cleaner cleaner = findCleanerById(id);
        if (cleaner == null) {
            System.out.println("Cleaner with ID " + id + " not found");
            return;
        }

        ArrayList<String> jobsAssigned = cleaner.getJobsAssigned();
        if (jobsAssigned.isEmpty()) {
            System.out.println("No jobs assigned to cleaner with ID " + id);
            return;
        }

        System.out.println("List of jobs assigned to cleaner with ID " + id);
        for (String job : jobsAssigned) {
            System.out.println(job);
        }
    }

}
