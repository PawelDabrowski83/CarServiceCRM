package pl.coderslab.car;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Car implements Comparable<Car>{

    private int carId;
    private String model;
    private String mark;
    private LocalDate productionYear;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean active;

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
}
