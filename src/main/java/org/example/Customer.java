package org.example;

public class Customer {

    private int id;
    private String name;
    private String phone;

    private int rentedCarId;
    private int numOfRentedDays;

    private double totalPaid;

    private static int count;
    private static double totalIncome;


    public Customer(
            int id,
            String name,
            String phone
    ) {

        this.id = id;
        this.name = name;
        this.phone = phone;

        this.rentedCarId = -1;
        this.numOfRentedDays = 0;
        this.totalPaid = 0;

        count++;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getRentedCarId() {
        return rentedCarId;
    }

    public int getNumOfRentedDays() {
        return numOfRentedDays;
    }

    public double getTotalPaid() {
        return totalPaid;
    }



    public static int getCount() {
        return count;
    }

    public static double getTotalIncome() {
        return totalIncome;
    }


    // Rent

    public void rentCar(
            int carId,
            int days,
            double cost
    ) {

        this.rentedCarId = carId;
        this.numOfRentedDays = days;

        this.totalPaid += cost;

        totalIncome += cost;
    }


    // Return

    public void returnCar() {

        this.rentedCarId = -1;
        this.numOfRentedDays = 0;
    }
}