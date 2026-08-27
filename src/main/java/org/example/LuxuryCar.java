package org.example;

public class LuxuryCar extends Car {

    private final double insuranceFee;

    private static final int MIN_NUM_OF_RENTAL_DAYS = 3;


    public LuxuryCar(
            int id,
            String brand,
            String model,
            int year,
            double pricePerDay,
            double insuranceFee
    ) {

        super(
                id,
                brand,
                model,
                year,
                pricePerDay
        );

        this.insuranceFee = insuranceFee;
    }


    public double getInsuranceFee() {
        return insuranceFee;
    }

    public int getMinNumOfRentalDays() {
        return MIN_NUM_OF_RENTAL_DAYS;
    }


    @Override
    public double calculateRentalCost(int days) {

        double subtotal =
                getPricePerDay() * days;

        double totalBeforeTax =
                subtotal + insuranceFee;

        double tax =
                totalBeforeTax * getTaxRate();

        return totalBeforeTax + tax;
    }
}