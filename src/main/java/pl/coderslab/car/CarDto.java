package pl.coderslab.car;

import java.util.Objects;

public class CarDto implements Comparable<CarDto>{

    private int carId;
    private String mark;
    private String model;
    private int productionYear;
    private String carSignature;

    public CarDto() {
    }

    protected CarDto(int carId, String mark, String model, int productionYear, String carSignature) {
        this.carId = carId;
        this.mark = mark;
        this.model = model;
        this.productionYear = productionYear;
        this.carSignature = carSignature;
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

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getCarSignature() {
        return carSignature;
    }

    public void setCarSignature(String carSignature) {
        this.carSignature = carSignature;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarDto)) return false;
        CarDto carDto = (CarDto) o;
        return getProductionYear() == carDto.getProductionYear() &&
                Objects.equals(getMark(), carDto.getMark()) &&
                Objects.equals(getModel(), carDto.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMark(), getModel(), getProductionYear());
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "carId=" + carId +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", carSignature='" + carSignature + '\'' +
                '}';
    }
}
