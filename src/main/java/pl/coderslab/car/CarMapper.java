package pl.coderslab.car;

import pl.coderslab.commons.MapperInterface;

import java.time.DateTimeException;
import java.time.LocalDate;

public class CarMapper implements MapperInterface<CarDto, Car, CarEntity> {

    @Override
    public CarDto mapServiceToDto(Car car) {
        CarDto dto = new CarDto();
        dto.setCarId(car.getCarId());
        dto.setModel(car.getModel());
        dto.setMark(car.getMark());
        try {
            dto.setProductionYear(car.getProductionYear().getYear());
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Invalid production year with: " + car.getProductionYear());
        }
        dto.setCarSignature(car.getCarSignature());
        return dto;
    }

    @Override
    public Car mapDtoToService(CarDto dto) {
        Car car = new Car();
        car.setCarId(dto.getCarId());
        car.setModel(dto.getModel());
        car.setMark(dto.getMark());
        try {
            car.setProductionYear(LocalDate.of(dto.getProductionYear(), 1, 1));
        } catch (DateTimeException e) {
            e.printStackTrace();
            System.out.println("Unable to parse year with: " + dto.getProductionYear());
        }
        return car;
    }

    @Override
    public CarEntity mapServiceToEntity(Car car) {
        CarEntity entity = new CarEntity();
        entity.setCarId(car.getCarId());
        entity.setModel(car.getModel());
        entity.setMark(car.getMark());
        entity.setProductionYear(car.getProductionYear());
        return entity;
    }

    @Override
    public Car mapEntityToService(CarEntity entity) {
        Car car = new Car();
        car.setCarId(entity.getCarId());
        car.setModel(entity.getModel());
        car.setMark(entity.getMark());
        car.setProductionYear(entity.getProductionYear());
        car.setCreated(entity.getCreated());
        car.setUpdated(entity.getUpdated());
        car.setActive(entity.isActive());
        return car;
    }
}
