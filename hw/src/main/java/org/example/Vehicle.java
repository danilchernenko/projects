package org.example;

import java.util.Objects;

public abstract class Vehicle {

    private String make;
    private String model;
    private String yearOfManufacture;
    private double cost;

    public Vehicle(String make, String model, String yearOfManufacture, double cost) {
        if (make.isEmpty()) {
            throw new IllegalArgumentException("Make cant be empty");
        }
        this.make = make;
        if (model.isEmpty()) {
            throw new IllegalArgumentException("Model cant be empty");
        }
        this.model = model;
        if (yearOfManufacture.isEmpty()) {
            throw new IllegalArgumentException("Year of manufacture cant be empty");
        }
        this.yearOfManufacture = yearOfManufacture;
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cant be less than 0");
        }
        this.cost = cost;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if (make.isEmpty()) {
            throw new IllegalArgumentException("Make cant be empty");
        }
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.isEmpty()) {
            throw new IllegalArgumentException("Model cant be empty");
        }
        this.model = model;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        if (yearOfManufacture.isEmpty()) {
            throw new IllegalArgumentException("Year of manufacture cant be empty");
        }
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cant be less than 0");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.cost, cost) == 0 &&
                Objects.equals(make, vehicle.make)
                && Objects.equals(model, vehicle.model)
                && Objects.equals(yearOfManufacture, vehicle.yearOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, yearOfManufacture, cost);
    }


    public abstract int getNumberOfPassangers();

    public abstract Engine getEngine();

    public abstract String getEngineName();

    public abstract double getEngineCapacity();

    public abstract double getCapacity();

}

