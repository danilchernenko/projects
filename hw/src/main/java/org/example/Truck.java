package org.example;

import java.util.Objects;

public class Truck extends Vehicle {

    private double capacity;

    public Truck(String make, String model, String yearOfManufacture, double cost, double capacity) {
        super(make, model, yearOfManufacture, cost);
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cant be less than 0 or be 0");
        }
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cant be less than 0 or be 0");
        }
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Double.compare(truck.capacity, capacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity);
    }

    @Override
    public int getNumberOfPassangers() {
        return 0;
    }

    public Engine getEngine() {
        return new Engine("-", 0);
    }

    @Override
    public String getEngineName() {
        return "-";
    }

    @Override
    public double getEngineCapacity() {
        return 0;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", yearOfManufacture='" + getYearOfManufacture() + '\'' +
                ", cost=" + getCost() +
                "capacity=" + capacity +
                '}';
    }
}
