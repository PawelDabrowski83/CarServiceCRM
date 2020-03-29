package pl.coderslab.car;

import pl.coderslab.commons.MapperInterface;

import java.time.Year;

public class CarMapper implements MapperInterface<CarDto, Car, CarEntity> {

    @Override
    public CarDto mapServiceToDto(Car car) {
        CarDto dto = new CarDto();
        dto.setCarId(car.getCarId());
        dto.setModel(car.getModel());
        dto.setMark(car.getMark());
        try {
            dto.setProductionYear(Integer.parseInt(car.getProductionYear().toString()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid production year with: " + car.getProductionYear());
        }
        return dto;
    }

    @Override
    public Car mapDtoToService(CarDto dto) {
        Car car = new Car();
        car.setCarId(dto.getCarId());
        car.setModel(dto.getModel());
        car.setMark(dto.getMark());
        try {
            car.setProductionYear(Year.parse(dto.getProductionYear());
        }

        return null;
    }

    @Override
    public CarEntity mapServiceToEntity(Car car) {
        return null;
    }

    @Override
    public Car mapEntityToService(CarEntity entity) {
        return null;
    }
}
