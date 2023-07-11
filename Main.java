import java.util.*;

class CarManagementSystem {
    private Map<String, Integer> carSales;

    public CarManagementSystem() {
        carSales = new HashMap<>();
    }

    public void addSale(String carModel) {
        carSales.put(carModel, carSales.getOrDefault(carModel, 0) + 1);
        System.out.println("Car sale added successfully!");
    }

    public void showTopSellingCar() {
        System.out.println("Top Selling Car Model");
        System.out.println("----------------------");
        if (carSales.isEmpty()) {
            System.out.println("No sales recorded.");
            System.out.println("----------------------");
            return;
        }
        int maxSales = 0;
        String topCarModel = "";
        for (Map.Entry<String, Integer> entry : carSales.entrySet()) {
            String carModel = entry.getKey();
            int salesCount = entry.getValue();
            System.out.println("Car Model: " + carModel + ", Sales Count: " + salesCount);
            if (salesCount > maxSales) {
                maxSales = salesCount;
                topCarModel = carModel;
            }
        }
        System.out.println("Top Selling Car Model: " + topCarModel);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarManagementSystem system = new CarManagementSystem();

        boolean exit = false;
        while (!exit) {
            System.out.println("Car Management System");
            System.out.println("-----------------------");
            System.out.println("1. Add Car Sale");
            System.out.println("2. Show Top Selling Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Car Model: ");
                    String carModel = scanner.nextLine();
                    system.addSale(carModel);
                    break;

                case 2:
                    system.showTopSellingCar();
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
