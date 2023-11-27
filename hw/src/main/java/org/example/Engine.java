package org.example;

import java.util.Objects;

public class Engine {
    private String name;
    private double engineCapacity;

    public Engine(String name, double engineCapacity) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cant be empty");
        }
        this.name = name;
        if (engineCapacity < 0.8) {
            throw new IllegalArgumentException("Engine Capacity cant be less than 0.8");
        }
        this.engineCapacity = engineCapacity;
    }

    public Engine(Engine engine) {
        if (engine == null) {
            throw new NullPointerException("Engine is null");
        }
        name = engine.name;
        engineCapacity = engine.engineCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Double.compare(engine.engineCapacity, engineCapacity) == 0 && Objects.equals(name, engine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, engineCapacity);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
