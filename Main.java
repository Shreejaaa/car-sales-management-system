import java.util.*;

class Car 
{
    private String model;
    private String brand;
    private int year;

    public Car(String model, String brand, int year)
    {
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public String getModel() 
    {
        return model;
    }

    public String getBrand() 
    {
        return brand;
    }

    public int getYear() 
    {
        return year;
    }

    public String toString() 
    {
        return "Car " + model + " " + brand + " " + year;
    }
}

class CarSales 
{
    private ArrayList<Car> cars;

    public CarSales() 
    {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) 
    {
        cars.add(car);
    }

    public Car getTopSellingCar() 
    {
        int maxSales = 0;
        Car topCar = null;
        for (Car car : cars) {
            int salesCount = car.getYear();
            if (salesCount > maxSales) {
                maxSales = salesCount;
                topCar = car;
            }
        }
        return topCar;
    }
}

class UserInput 
{
    private Scanner scanner;

    public UserInput() 
    {
        scanner = new Scanner(System.in);
    }

    public String getInput(String command) 
    {
        System.out.print(command);
        return scanner.nextLine();
    }

    public int getIntInput(String command) 
    {
        String input = getInput(command);
        return Integer.parseInt(input);
    }
}

class Main 
{
    public static void main(String[] args) 
    {
        UserInput input = new UserInput();
        CarSales sales = new CarSales();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n\n\t-----------------------");
            System.out.println("\tCar Management System");
            System.out.println("\t-----------------------\n");
            System.out.println("1. Add Car Sale");
            System.out.println("2. Show Top Selling Car");
            System.out.println("3. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = input.getIntInput("");

            switch (choice) {
                case 1:
                    String model = input.getInput("Enter Car Model: ");
                    String brand = input.getInput("Enter Car brand: ");
                    int year = input.getIntInput("Enter Car Year: ");
                    Car car = new Car(model, brand, year);
                    sales.addCar(car);
                    break;

                case 2:
                    Car topCar = sales.getTopSellingCar();
                    System.out.println("\nTop Selling Car:" + topCar );
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
