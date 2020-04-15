package pl.coderslab.car;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Car implements Comparable<Car>{

    private int carId;
    private String mark;
    private String model;
    private LocalDate productionYear;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public Car() {
    }

    public Car(int carId, String mark, String model, LocalDate productionYear, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.carId = carId;
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

    public Car(String mark, String model, LocalDate productionYear) {
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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

    public String getCarSignature() {
        StringBuilder builder = new StringBuilder();
        builder.append("(" + productionYear.getYear() + ")");
        if (mark == null || mark.trim().isEmpty()) {
            mark = "";
        } else {
            builder.append(" " + mark);
        }

        if (model == null || model.trim().isEmpty()) {
            model = "";
        } else {
            builder.append(" " + model);
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Car o) {
        int result = this.productionYear.compareTo(o.productionYear);
        if (result == 0) {
            result = this.mark.compareToIgnoreCase(o.mark);
        }
        if (result == 0) {
            result = this.model.compareToIgnoreCase(o.model);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", productionYear=" + productionYear.getYear() +
                ", created=" + created +
                ", updated=" + updated +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getModel(), car.getModel()) &&
                Objects.equals(getMark(), car.getMark()) &&
                getProductionYear().equals(car.getProductionYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getMark(), getProductionYear());
    }
}
