package org.example;

import java.util.Scanner;

public class Main {

    private static final int MAX_CARS = 20;
    private static final int MAX_CUSTOMERS = 20;

    static Car[] cars = new Car[MAX_CARS];
    static Customer[] customers = new Customer[MAX_CUSTOMERS];

    static int numberOfCars = 0;
    static int numberOfCustomers = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("      WELCOME TO SPEEDWAY RENTALS");

        int choice;

        do {
            System.out.println("       SPEEDWAY RENTALS SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Regular Car");
            System.out.println("2. Add Luxury Car");
            System.out.println("3. Add Customer");
            System.out.println("4. Display All Cars");
            System.out.println("5. Display Available Cars");
            System.out.println("6. Rent a Car");
            System.out.println("7. Return a Car");
            System.out.println("8. Search Car by ID");
            System.out.println("9. Search Car by Brand");
            System.out.println("10. Display All Customers");
            System.out.println("0. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addRegularCar(scanner);
                    break;

                case 2:
                    addLuxuryCar(scanner);
                    break;

                case 3:
                    addCustomer(scanner);
                    break;

                case 4:
                    displayAllCars();
                    break;

                case 5:
                    displayAvailableCars();
                    break;

                case 6:
                    rentCar(scanner);
                    break;

                case 7:
                    returnCar(scanner);
                    break;

                case 8:
                    searchCarById(scanner);
                    break;

                case 9:
                    searchCarByBrand(scanner);
                    break;

                case 10:
                    displayAllCustomers();
                    break;

                case 0:
                    System.out.println("\n========================================");
                    System.out.println("Thank you for using Speedway Rentals!");
                    System.out.println("Total Cars: " + Car.getCarCount());
                    System.out.println("Total Customers: " + Customer.getCount());
                    System.out.println("Total Income: " + Customer.getTotalIncome());
                    System.out.println("========================================");
                    break;

                default:
                    System.out.println("Error: Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }



    public static boolean isCarIdUsed(int id) {

        for (int i = 0; i < numberOfCars; i++) {

            if (cars[i].getId() == id) {
                return true;
            }
        }

        return false;
    }


    public static boolean isCustomerIdUsed(int id) {

        for (int i = 0; i < numberOfCustomers; i++) {

            if (customers[i].getId() == id) {
                return true;
            }
        }

        return false;
    }


    public static Car findCarById(int id) {

        for (int i = 0; i < numberOfCars; i++) {

            if (cars[i].getId() == id) {
                return cars[i];
            }
        }

        return null;
    }


    public static Customer findCustomerById(int id) {

        for (int i = 0; i < numberOfCustomers; i++) {

            if (customers[i].getId() == id) {
                return customers[i];
            }
        }

        return null;
    }

    // 1. ADD REGULAR CAR

    public static void addRegularCar(Scanner scanner) {

        if (numberOfCars >= MAX_CARS) {
            System.out.println("Error: The car fleet is full.");
            return;
        }

        System.out.print("Enter Car ID: ");
        int id = scanner.nextInt();

        if (isCarIdUsed(id)) {
            System.out.println(
                    "Error: Car ID " + id + " is already used."
            );
            return;
        }

        scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        if (year < 1990 || year > 2026) {
            System.out.println(
                    "Error: Manufacturing year must be between 1990 and 2026."
            );
            return;
        }

        System.out.print("Enter Price Per Day: ");
        double pricePerDay = scanner.nextDouble();

        if (pricePerDay <= 0) {
            System.out.println(
                    "Error: Price per day must be greater than zero."
            );
            return;
        }

        cars[numberOfCars] =
                new Car(id,
                        brand,
                        model, year,
                        pricePerDay
                );

        numberOfCars++;

        System.out.println(
                "Regular car added successfully. Car ID: " + id
        );
    }

    // 2. ADD LUXURY CAR

    public static void addLuxuryCar(Scanner scanner) {

        if (numberOfCars >= MAX_CARS) {
            System.out.println("Error: The car fleet is full.");
            return;
        }

        System.out.print("Enter Car ID: ");
        int id = scanner.nextInt();

        if (isCarIdUsed(id)) {
            System.out.println(
                    "Error: Car ID " + id + " is already used."
            );
            return;
        }

        scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        if (year < 1990 || year > 2026) {
            System.out.println(
                    "Error: Manufacturing year must be between 1990 and 2026."
            );
            return;
        }

        System.out.print("Enter Price Per Day: ");
        double pricePerDay = scanner.nextDouble();

        if (pricePerDay <= 0) {
            System.out.println(
                    "Error: Price per day must be greater than zero."
            );
            return;
        }

        System.out.print("Enter Insurance Fee: ");
        double insuranceFee = scanner.nextDouble();

        if (insuranceFee < 0) {
            System.out.println(
                    "Error: Insurance fee cannot be negative."
            );
            return;
        }

        cars[numberOfCars] =
                new LuxuryCar(
                        id,
                        brand,
                        model,
                        year,
                        pricePerDay,
                        insuranceFee
                );

        numberOfCars++;

        System.out.println(
                "Luxury car added successfully. Car ID: " + id
        );
    }


    // 3. ADD CUSTOMER


    public static void addCustomer(Scanner scanner) {

        if (numberOfCustomers >= MAX_CUSTOMERS) {
            System.out.println(
                    "Error: The customer array is full."
            );
            return;
        }

        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();

        if (isCustomerIdUsed(id)) {
            System.out.println(
                    "Error: Customer ID " + id + " is already used."
            );
            return;
        }

        scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Customer Phone: ");
        String phone = scanner.nextLine();

        customers[numberOfCustomers] =
                new Customer(id, name, phone);

        numberOfCustomers++;

        System.out.println(
                "Customer added successfully: "
                        + name
                        + " (ID: "
                        + id
                        + ")"
        );
    }

    // 4. DISPLAY ALL CARS

    public static void displayAllCars() {

        if (numberOfCars == 0) {
            System.out.println("The fleet is empty.");
            return;
        }

        System.out.println("\n============ ALL CARS ============");

        for (int i = 0; i < numberOfCars; i++) {

            Car car = cars[i];

            System.out.println("Car " + (i + 1));
            System.out.println("ID: " + car.getId());
            System.out.println("Brand: " + car.getBrand());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year: " + car.getYear());
            System.out.println(
                    "Price Per Day: " + car.getPricePerDay()
            );
            System.out.println(
                    "Available: " + car.isAvailable()
            );

            System.out.println("------------------------------------");
        }
    }

    // 5. DISPLAY AVAILABLE CARS

    public static void displayAvailableCars() {

        if (numberOfCars == 0) {
            System.out.println("The fleet is empty.");
            return;
        }

        boolean found = false;
        int availableCount = 0;

        System.out.println("\n============ AVAILABLE CARS ============");

        for (int i = 0; i < numberOfCars; i++) {

            Car car = cars[i];

            if (car.isAvailable()) {

                found = true;
                availableCount++;

                System.out.println(
                        "Car " + (i + 1)
                );
                System.out.println(
                        "ID: " + car.getId()
                );
                System.out.println(
                        "Brand: " + car.getBrand()
                );
                System.out.println(
                        "Model: " + car.getModel()
                );
                System.out.println(
                        "Year: " + car.getYear()
                );
                System.out.println(
                        "Price Per Day: "
                                + car.getPricePerDay()
                );

                System.out.println(
                        "------------------------------------"
                );
            }
        }

        if (!found) {

            System.out.println(
                    "There are no available cars."
            );

        } else {

            System.out.println(
                    "Total Available Cars: "
                            + availableCount
            );
        }
    }

    //6. RENT CAR

    public static void rentCar(Scanner scanner) {

        // 1. Get Customer ID
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();

        Customer customer = findCustomerById(customerId);

        if (customer == null) {
            System.out.println("Error: Customer not found.");
            return;
        }

        // 2. Check if customer already has a car
        if (customer.getRentedCarId() != -1) {
            System.out.println(
                    "Error: Customer " + customer.getName()
                            + " already has a car."
            );
            return;
        }

        // 3. Get Car ID
        System.out.print("Enter Car ID: ");
        int carId = scanner.nextInt();

        Car car = findCarById(carId);

        if (car == null) {
            System.out.println("Error: Car not found.");
            return;
        }

        // 4. Check if car is available
        if (!car.isAvailable()) {
            System.out.println(
                    "Error: Car ID " + carId + " is already rented."
            );
            return;
        }

        // 5. Get number of days
        System.out.print("Enter Number of Days: ");
        int days = scanner.nextInt();

        if (days <= 0) {
            System.out.println(
                    "Error: Number of rental days must be greater than zero."
            );
            return;
        }

        // 6. Check luxury car minimum rental period
        if (car instanceof LuxuryCar) {

            LuxuryCar luxuryCar = (LuxuryCar) car;

            if (days < luxuryCar.getMinNumOfRentalDays()) {

                System.out.println(
                        "Error: A luxury car must be rented for at least "
                                + luxuryCar.getMinNumOfRentalDays()
                                + " days."
                );

                return;
            }
        }

        // 7. Calculate rental cost
        double totalCost = car.calculateRentalCost(days);

        // 8. Update car and customer
        car.rent();

        customer.rentCar(
                car.getId(),
                days,
                totalCost
        );

        // Receipt
        System.out.println("\n========================================");
        System.out.println("           RENTAL RECEIPT");
        System.out.println("========================================");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car: " + car.getBrand() + " " + car.getModel());
        System.out.println("Number of Days: " + days);
        System.out.println("Price Per Day: " + car.getPricePerDay());

        if (car instanceof LuxuryCar) {
            LuxuryCar luxuryCar = (LuxuryCar) car;

            System.out.println(
                    "Insurance Fee: " + luxuryCar.getInsuranceFee()
            );
        }

        System.out.println("Tax Rate: " + (car.getTaxRate() * 100) + "%");
        System.out.println("----------------------------------------");
        System.out.println("Final Cost: " + totalCost);
        System.out.println("========================================");

        System.out.println("Car rented successfully.");
    }
    //7. RETURN CAR
    public static void returnCar(Scanner scanner) {

        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();

        // Find customer
        Customer customer = findCustomerById(customerId);

        if (customer == null) {
            System.out.println("Error: Customer not found.");
            return;
        }

        // Check if customer has a car
        if (customer.getRentedCarId() == -1) {
            System.out.println(
                    "Error: Customer " + customer.getName()
                            + " does not currently have a car."
            );
            return;
        }

        // Find the rented car
        int carId = customer.getRentedCarId();

        Car car = findCarById(carId);

        if (car == null) {
            System.out.println(
                    "Error: The rented car could not be found."
            );
            return;
        }

        // Make car available
        car.returnCar();

        // Clear customer's rental information
        customer.returnCar();

        System.out.println("\n========================================");
        System.out.println("           CAR RETURNED");
        System.out.println("========================================");
        System.out.println(
                "Customer: " + customer.getName()
        );
        System.out.println(
                "Returned Car: "
                        + car.getBrand()
                        + " "
                        + car.getModel()
        );
        System.out.println(
                "Car ID: " + car.getId()
        );
        System.out.println("========================================");

        System.out.println("Car returned successfully.");
    }

    // SEARCH BY CAR ID.
    public static void searchCarById(Scanner scanner) {

        System.out.print("Enter Car ID: ");
        int id = scanner.nextInt();

        Car car = findCarById(id);

        if (car == null) {
            System.out.println("Error: Car not found.");
            return;
        }

        System.out.println("\n========== CAR DETAILS ==========");
        System.out.println("ID: " + car.getId());
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price Per Day: " + car.getPricePerDay());
        System.out.println("Available: " + car.isAvailable());

        if (car instanceof LuxuryCar) {

            LuxuryCar luxuryCar = (LuxuryCar) car;

            System.out.println("Type: Luxury Car");
            System.out.println(
                    "Insurance Fee: "
                            + luxuryCar.getInsuranceFee()
            );
            System.out.println(
                    "Minimum Rental Days: "
                            + luxuryCar.getMinNumOfRentalDays()
            );

        } else {

            System.out.println("Type: Regular Car");
        }

        System.out.println("=================================");
    }

    // SEARCH CAR BY BRAND.
    public static void searchCarByBrand(Scanner scanner) {

        scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        int matchCount = 0;

        System.out.println("\n========== SEARCH RESULTS ==========");

        for (int i = 0; i < numberOfCars; i++) {

            Car car = cars[i];

            if (car.getBrand().equalsIgnoreCase(brand)) {

                matchCount++;

                System.out.println("Car " + matchCount);
                System.out.println("ID: " + car.getId());
                System.out.println("Brand: " + car.getBrand());
                System.out.println("Model: " + car.getModel());
                System.out.println("Year: " + car.getYear());
                System.out.println(
                        "Price Per Day: "
                                + car.getPricePerDay()
                );
                System.out.println(
                        "Available: "
                                + car.isAvailable()
                );

                System.out.println("-----------------------------------");
            }
        }

        if (matchCount == 0) {

            System.out.println(
                    "No cars found for brand: " + brand
            );

        } else {

            System.out.println(
                    "Number of matches: " + matchCount
            );
        }
    }

    // DISPLAY ALL CUSTOMERS.
    public static void displayAllCustomers() {

        if (numberOfCustomers == 0) {
            System.out.println("There are no customers.");
            return;
        }

        System.out.println("\n========== ALL CUSTOMERS ==========");

        for (int i = 0; i < numberOfCustomers; i++) {

            Customer customer = customers[i];

            System.out.println("Customer " + (i + 1));
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Phone: " + customer.getPhone());

            if (customer.getRentedCarId() == -1) {

                System.out.println("Current Car: None");

            } else {

                Car car = findCarById(
                        customer.getRentedCarId()
                );

                if (car != null) {

                    System.out.println(
                            "Current Car: "
                                    + car.getBrand()
                                    + " "
                                    + car.getModel()
                                    + " (ID: "
                                    + car.getId()
                                    + ")"
                    );

                    System.out.println(
                            "Rental Days: "
                                    + customer.getNumOfRentedDays()
                    );
                }
            }

            System.out.println("-----------------------------------");
        }
    }
}