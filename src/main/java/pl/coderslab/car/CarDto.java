package pl.coderslab.car;

import java.time.LocalDateTime;
import java.time.Year;

public class CarDto implements Comparable<CarDto>{

    private int carId;
    private String model;
    private String mark;
    private int productionYear;

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

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public int compareTo(CarDto o) {
        int result = Integer.compare(this.productionYear, o.productionYear);
        if (result == 0) {
            result = this.mark.compareToIgnoreCase(o.mark);
        }
        if (result == 0) {
            result = this.model.compareToIgnoreCase(o.model);
        }
        return result;
    }
}
