package org.example;

import java.util.Objects;

public class Car extends Vehicle {

    private int numberOfPassangers;
    private Engine engine;

    public Car(String make, String model, String yearOfManufacture, double cost, int numberOfPassangers, Engine engine) {
        super(make, model, yearOfManufacture, cost);
        if (numberOfPassangers < 0) {
            throw new IllegalArgumentException("Number of passengers cant be less than 0");
        }
        this.numberOfPassangers = numberOfPassangers;
        if (engine == null) {
            throw new NullPointerException("Engine is null");
        }
        this.engine = new Engine(engine);
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }

    public void setNumberOfPassangers(int numberOfPassangers) {
        if (numberOfPassangers < 0) {
            throw new IllegalArgumentException("Number of passengers cant be less than 0");
        }
        this.numberOfPassangers = numberOfPassangers;
    }

    public Engine getEngine() {
        return new Engine(engine);
    }

    @Override
    public double getCapacity() {
        return 0;
    }

    public String getEngineName() {
        return engine.getName();
    }

    public double getEngineCapacity() {
        return engine.getEngineCapacity();
    }

    public void setEngine(String name, double capacity) {
        if (engine == null) {
            throw new NullPointerException("Engine is null");
        }

        this.engine = new Engine(name, capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return numberOfPassangers == car.numberOfPassangers && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPassangers, engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", yearOfManufacture='" + getYearOfManufacture() + '\'' +
                ", cost=" + getCost() +
                "numberOfPassangers=" + numberOfPassangers +
                ", engine='" + engine + '\'' +
                '}';
    }

}
