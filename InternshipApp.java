import java.util.*;

public class InternshipApp {
    static ArrayList<Application> apps = new ArrayList<>();
    static Scanner sc = new Scanner(System.in)

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add  2. View All  3. Filter  4. Update Status  5. Delete  6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addApplication();
                case 2 -> viewAll();
                case 3 -> filterByStatus();
                case 4 -> updateStatus();
                case 5 -> deleteApplication();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid!");
            }
        }
    }

    static void addApplication() {
        System.out.print("Company Name: ");
        String company = sc.nextLine();
        System.out.print("Role: ");
        String role = sc.nextLine();
        Date date = new Date();
        apps.add(new Application(company, role, "Applied", date));
        System.out.println("Added.");
    }

    static void viewAll() {
        if (apps.isEmpty()) {
            System.out.println("No applications yet.");
            return;
        }
        apps.sort(Comparator.comparing(a -> a.dateApplied));
        Collections.reverse(apps);
        for (Application a : apps) System.out.println(a);
    }

    static void filterByStatus() {
        System.out.print("Enter status (Applied / Interview / Selected / Rejected): ");
        String status = sc.nextLine();
        for (Application a : apps) {
            if (a.status.equalsIgnoreCase(status)) {
                System.out.println(a);
            }
        }
    }

    static void updateStatus() {
        System.out.print("Enter company name to update: ");
        String company = sc.nextLine();
        for (Application a : apps) {
            if (a.companyName.equalsIgnoreCase(company)) {
                System.out.print("New status: ");
                a.status = sc.nextLine();
                System.out.println("Updated.");
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void deleteApplication() {
        System.out.print("Enter company to delete: ");
        String company = sc.nextLine();
        apps.removeIf(a -> a.companyName.equalsIgnoreCase(company));
        System.out.println("Deleted if existed.");
    }
}



