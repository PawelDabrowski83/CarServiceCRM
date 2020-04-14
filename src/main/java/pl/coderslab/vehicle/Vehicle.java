package pl.coderslab.vehicle;

import pl.coderslab.car.Car;
import pl.coderslab.customer.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vehicle {

    private int vehicleId;
    private Car car;
    private Customer owner;
    private String registryPlate;
    private LocalDate nextInspection;
    private String color;
    private String notes;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public String getRegistryPlate() {
        return registryPlate;
    }

    public void setRegistryPlate(String registryPlate) {
        this.registryPlate = registryPlate;
    }

    public LocalDate getNextInspection() {
        return nextInspection;
    }

    public void setNextInspection(LocalDate nextInspection) {
        this.nextInspection = nextInspection;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCarSignature() {
        return this.car.getCarSignature() + " " + this.registryPlate;
    }

}
