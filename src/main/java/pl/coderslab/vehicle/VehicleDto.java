package pl.coderslab.vehicle;

import java.time.LocalDate;
import java.util.Objects;

public class VehicleDto implements Comparable<VehicleDto> {

    private int vehicleId;
    private int carId;
    private int ownerId;
    private String registryPlate;
    private LocalDate nextInspection;
    private String color;
    private String notes;
    private String ownerFullname;
    private String carSignature;

    public VehicleDto() {
    }

    protected VehicleDto(int vehicleId, int carId, int ownerId, String registryPlate, LocalDate nextInspection, String color, String notes, String ownerFullname, String carSignature) {
        this.vehicleId = vehicleId;
        this.carId = carId;
        this.ownerId = ownerId;
        this.registryPlate = registryPlate;
        this.nextInspection = nextInspection;
        this.color = color;
        this.notes = notes;
        this.ownerFullname = ownerFullname;
        this.carSignature = carSignature;
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

    public String getOwnerFullname() {
        return ownerFullname;
    }

    public void setOwnerFullname(String ownerFullname) {
        this.ownerFullname = ownerFullname;
    }

    public String getCarSignature() {
        return carSignature;
    }

    public void setCarSignature(String carSignature) {
        this.carSignature = carSignature;
    }

    @Override
    public int compareTo(VehicleDto o) {
        int result = this.carSignature.compareToIgnoreCase(o.carSignature);
        if (result == 0) {
            result = this.registryPlate.compareToIgnoreCase(o.registryPlate);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleDto)) return false;
        VehicleDto that = (VehicleDto) o;
        return getCarId() == that.getCarId() &&
                getOwnerId() == that.getOwnerId() &&
                getRegistryPlate().equals(that.getRegistryPlate()) &&
                getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getOwnerId(), getRegistryPlate(), getColor());
    }
}
