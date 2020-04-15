package pl.coderslab.car;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CarEntity {

    private int carId;
    private String mark;
    private String model;
    private LocalDate productionYear;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public CarEntity() {
    }

    protected CarEntity(int carId, String mark, String model, LocalDate productionYear, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.carId = carId;
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
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
        return "CarEntity{" +
                "carId=" + carId +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear.getYear() +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarEntity)) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(getMark(), carEntity.getMark()) &&
                Objects.equals(getModel(), carEntity.getModel()) &&
                getProductionYear().equals(carEntity.getProductionYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMark(), getModel(), getProductionYear());
    }
}
