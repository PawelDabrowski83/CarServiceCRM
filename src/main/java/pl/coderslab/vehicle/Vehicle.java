package pl.coderslab.vehicle;

import pl.coderslab.car.Car;
import pl.coderslab.customer.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Vehicle implements Comparable<Vehicle>{

    protected static final String REGISTRYPLATE_PLACEHOLDER = "";
    protected static final String CARSIGNATURE_PLACEHOLDER = "";
    protected static final String OWNER_PLACEHOLDER = "";

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

    public Vehicle() {
    }

    protected Vehicle(int vehicleId, Car car, Customer owner, String registryPlate, LocalDate nextInspection, String color, String notes, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.vehicleId = vehicleId;
        this.car = car;
        this.owner = owner;
        this.registryPlate = registryPlate;
        this.nextInspection = nextInspection;
        this.color = color;
        this.notes = notes;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

    protected Vehicle(Car car, String registryPlate) {
        this.car = car;
        this.registryPlate = registryPlate;
    }

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
        StringBuilder builder = new StringBuilder();
        if (car == null || car.getCarSignature() == null || car.getCarSignature().isEmpty()) {
            builder.append(CARSIGNATURE_PLACEHOLDER);
        } else {
            builder.append(car.getCarSignature());
        }
        builder.append(" ");
        if (registryPlate == null || registryPlate.trim().isEmpty()) {
            builder.append(REGISTRYPLATE_PLACEHOLDER);
        } else {
            builder.append(registryPlate);
        }
        return builder.toString().trim();
    }

    public String getOwnerFullname() {
        StringBuilder builder = new StringBuilder();
        if (owner != null && owner.getPerson() != null && owner.getPerson().getFullname() != null) {
            builder.append(owner.getPerson().getFullname());
        } else {
            builder.append(OWNER_PLACEHOLDER);
        }
        return builder.toString().trim();
    }

    public int getOwnerCustomerId() {
        int result = 0;
        if (owner != null) {
            result = owner.getCustomerId();
        }
        return result;
    }

    @Override
    public int compareTo(Vehicle o) {
        int result = 0;
        if (this.car != null && o.car != null) {
            result = this.car.compareTo(o.car);
        }
        if (result == 0 && this.owner != null && o.owner != null) {
            result = this.owner.compareTo(o.owner);
        }
        if (result == 0 && this.registryPlate != null && o.registryPlate != null) {
            result = this.registryPlate.compareToIgnoreCase(o.registryPlate);
        }
        if (result == 0 && this.nextInspection != null && o.nextInspection != null) {
            result = this.nextInspection.compareTo(o.nextInspection);
        }
        if (result == 0 && this.color != null || o.color != null) {
            result = this.color.compareToIgnoreCase(o.color);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getCar().equals(vehicle.getCar()) &&
                getOwner().equals(vehicle.getOwner()) &&
                getRegistryPlate().equals(vehicle.getRegistryPlate()) &&
                getNextInspection().equals(vehicle.getNextInspection()) &&
                getColor().equals(vehicle.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCar(), getOwner(), getRegistryPlate(), getNextInspection(), getColor());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", car=" + car +
                ", owner=" + owner +
                ", registryPlate='" + registryPlate + '\'' +
                ", nextInspection=" + nextInspection +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }
}
