package pl.coderslab.car;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Car implements Comparable<Car>{

    protected static final String YEAR_PLACEHOLDER = "";
    protected static final String MARK_PLACEHOLDER = "";
    protected static final String MODEL_PLACEHOLDER = "";
    protected static final String CAR_SIGNATURE_SEPARATOR = " ";

    private int carId;
    private String mark;
    private String model;
    private LocalDate productionYear;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

    public Car() {
    }

    protected Car(int carId, String mark, String model, LocalDate productionYear, LocalDateTime created, LocalDateTime updated, boolean active) {
        this.carId = carId;
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.created = created;
        this.updated = updated;
        this.active = active;
    }

    protected Car(String mark, String model, LocalDate productionYear) {
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
        if (productionYear != null && productionYear.getYear() > 1800) {
            builder.append("(" + productionYear.getYear() + ")");
        } else {
            builder.append(YEAR_PLACEHOLDER);
        }

        if (mark != null && !mark.trim().isEmpty()) {
            builder.append(CAR_SIGNATURE_SEPARATOR);
            builder.append(mark);
            builder.append(CAR_SIGNATURE_SEPARATOR);
        } else {
            if (!(CAR_SIGNATURE_SEPARATOR + MARK_PLACEHOLDER + CAR_SIGNATURE_SEPARATOR).trim().isEmpty()) {
                // condition is always false for now, but may be different when CAR_SIGNATURE_SEPARATOR or
                // MARK_PLACEHOLDER are not empty
                builder.append(CAR_SIGNATURE_SEPARATOR + MARK_PLACEHOLDER + CAR_SIGNATURE_SEPARATOR);
            } else {
                builder.append(CAR_SIGNATURE_SEPARATOR);
            }
        }

        if (model != null && !model.trim().isEmpty()) {
            builder.append(model);
        } else {
            builder.append(MODEL_PLACEHOLDER);
        }

        return builder.toString().trim();
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
