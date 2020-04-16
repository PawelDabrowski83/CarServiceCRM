package pl.coderslab.vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class VehicleEntity {

    private int vehicleId;
    private int carId;
    private int ownerId;
    private String registryPlate;
    private LocalDate nextInspection;
    private String color;
    private String notes;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public VehicleEntity() {
    }

    protected VehicleEntity(int vehicleId, int carId, int ownerId, String registryPlate, LocalDate nextInspection, String color, String notes, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.vehicleId = vehicleId;
        this.carId = carId;
        this.ownerId = ownerId;
        this.registryPlate = registryPlate;
        this.nextInspection = nextInspection;
        this.color = color;
        this.notes = notes;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "vehicleId=" + vehicleId +
                ", carId=" + carId +
                ", ownerId=" + ownerId +
                ", registryPlate='" + registryPlate + '\'' +
                ", nextInspection=" + nextInspection +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleEntity)) return false;
        VehicleEntity that = (VehicleEntity) o;
        return getCarId() == that.getCarId() &&
                getOwnerId() == that.getOwnerId() &&
                getRegistryPlate().equals(that.getRegistryPlate()) &&
                getNextInspection().equals(that.getNextInspection()) &&
                getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getOwnerId(), getRegistryPlate(), getNextInspection(), getColor());
    }
}
