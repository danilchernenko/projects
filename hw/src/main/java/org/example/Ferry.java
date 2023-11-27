package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Ferry {

    private String name, type, SpecialNumber, flag;
    private ArrayList<Vehicle> vehicles;

    public Ferry(String name, String type, String specialNumber, String flag, ArrayList<Vehicle> vehicles) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cant be empty");
        }
        this.name = name;
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Type cant be empty");
        }
        this.type = type;
        if (specialNumber.isEmpty()) {
            throw new IllegalArgumentException("Make cant be empty");
        }
        this.SpecialNumber = specialNumber;
        if (flag.isEmpty()) {
            throw new IllegalArgumentException("Make cant be empty");
        }
        this.flag = flag;
        if (vehicles == null) {
            throw new NullPointerException("Vehicle cant be null");
        }
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cant be empty");
        }
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Type cant be empty");
        }
        this.type = type;
    }

    public String getSpecialNumber() {
        return SpecialNumber;
    }

    public void setSpecialNumber(String specialNumber) {
        if (specialNumber.isEmpty()) {
            throw new IllegalArgumentException("Make cant be empty");
        }
        SpecialNumber = specialNumber;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        if (flag.isEmpty()) {
            throw new IllegalArgumentException("Make cant be empty");
        }
        this.flag = flag;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null) {
            throw new NullPointerException("Vehicle cant be null");
        }
        this.vehicles = new ArrayList<Vehicle>(vehicles);
    }

    public void newVehicle(Vehicle vehicle) {

        if (vehicle == null)
            throw new NullPointerException("Error: object cant be null");
        this.vehicles.add(vehicle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferry ferry = (Ferry) o;
        return Objects.equals(name, ferry.name) && Objects.equals(type, ferry.type) && Objects.equals(SpecialNumber, ferry.SpecialNumber) && Objects.equals(flag, ferry.flag) && Objects.equals(vehicles, ferry.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, SpecialNumber, flag, vehicles);
    }

    @Override
    public String toString() {
        return "Ferry{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", SpecialNumber='" + SpecialNumber + '\'' +
                ", flag='" + flag + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
