package org.example;

public class Car {

    private final int id;
    private final String brand;
    private final String model;
    private final int year;

    private double pricePerDay;
    private boolean isAvailable;

    private static int carCount;

    private static final double TAX_RATE = 0.14;


    public Car(
            int id,
            String brand,
            String model,
            int year,
            double pricePerDay
    ) {

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;

        carCount++;
    }


    public Car(
            int id,
            String brand,
            String model,
            int year
    ) {

        this(
                id,
                brand,
                model,
                year,
                0.0
        );
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public static int getCarCount() {
        return carCount;
    }

    public double getTaxRate() {
        return TAX_RATE;
    }




    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }



    public double calculateRentalCost(int days) {

        double subtotal = pricePerDay * days;

        double tax = subtotal * TAX_RATE;

        return subtotal + tax;
    }
}