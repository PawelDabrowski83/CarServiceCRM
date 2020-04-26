package pl.coderslab.vehicle;

import pl.coderslab.car.*;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ServiceInterface;
import pl.coderslab.customer.*;

public class VehicleMapper implements MapperInterface<VehicleDto, Vehicle, VehicleEntity> {

    private final MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER;
    private final MapperInterface<CustomerDto, Customer, CustomerEntity> CUSTOMER_MAPPER;
    private final ServiceInterface<CarDto> CAR_SERVICE;
    private final ServiceInterface<CustomerDto> CUSTOMER_SERVICE;

    public VehicleMapper(MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER,
                         MapperInterface<CustomerDto, Customer, CustomerEntity> CUSTOMER_MAPPER,
                         ServiceInterface<CarDto> CAR_SERVICE,
                         ServiceInterface<CustomerDto> CUSTOMER_SERVICE) {
        this.CAR_MAPPER = CAR_MAPPER;
        this.CUSTOMER_MAPPER = CUSTOMER_MAPPER;
        this.CAR_SERVICE = CAR_SERVICE;
        this.CUSTOMER_SERVICE = CUSTOMER_SERVICE;
    }

    @Override
    public VehicleDto mapServiceToDto(Vehicle vehicle) {
        VehicleDto dto = new VehicleDto();
        dto.setVehicleId(vehicle.getVehicleId());
        dto.setCarId(vehicle.getCar().getCarId());
        dto.setCarSignature(vehicle.getCarSignature());
        dto.setRegistryPlate(vehicle.getRegistryPlate());
        dto.setNextInspection(vehicle.getNextInspection());
        dto.setOwnerId(vehicle.getOwner().getCustomerId());
        dto.setOwnerFullname(vehicle.getOwnerFullname());
        dto.setColor(vehicle.getColor());
        dto.setNotes(vehicle.getNotes());
        return dto;
    }

    @Override
    public Vehicle mapDtoToService(VehicleDto dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        vehicle.setCar(CAR_MAPPER.mapDtoToService(CAR_SERVICE.read(dto.getCarId())));
        vehicle.setRegistryPlate(dto.getRegistryPlate());
        vehicle.setNextInspection(dto.getNextInspection());
        vehicle.setOwner(CUSTOMER_MAPPER.mapDtoToService(CUSTOMER_SERVICE.read(dto.getOwnerId())));
        vehicle.setColor(dto.getColor());
        vehicle.setNotes(dto.getNotes());
        return vehicle;
    }

    @Override
    public VehicleEntity mapServiceToEntity(Vehicle vehicle) {
        VehicleEntity entity = new VehicleEntity();
        entity.setVehicleId(vehicle.getVehicleId());
        entity.setCarId(vehicle.getCar().getCarId());
        entity.setRegistryPlate(vehicle.getRegistryPlate());
        entity.setNextInspection(vehicle.getNextInspection());
        entity.setOwnerId(vehicle.getOwnerCustomerId());
        entity.setColor(vehicle.getColor());
        entity.setNotes(vehicle.getNotes());
        return entity;
    }

    @Override
    public Vehicle mapEntityToService(VehicleEntity entity) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(entity.getVehicleId());
        vehicle.setCar(CAR_MAPPER.mapDtoToService(CAR_SERVICE.read(entity.getCarId())));
        vehicle.setRegistryPlate(entity.getRegistryPlate());
        vehicle.setNextInspection(entity.getNextInspection());
        vehicle.setOwner(CUSTOMER_MAPPER.mapDtoToService(CUSTOMER_SERVICE.read(entity.getOwnerId())));
        vehicle.setColor(entity.getColor());
        vehicle.setNotes(entity.getNotes());
        vehicle.setCreated(entity.getCreated());
        vehicle.setUpdated(entity.getUpdated());
        vehicle.setActive(entity.isActive());
        return vehicle;
    }
}
