package pl.coderslab.vehicle;

import pl.coderslab.commons.ValidatorInterface;

import java.time.LocalDate;

public class VehicleValidator implements ValidatorInterface<VehicleDto> {

    protected static final String INVALID_CAR_ID = "CarId cannot be empty or lower than 1.<br/>";
    protected static final String INVALID_REGISTRY_PLATE = "Registry plate cannot be empty.<br/>";
    protected static final String INVALID_OWNER_ID = "OwnerId cannot be empty or lower than 1.<br/>";
    protected static final String INVALID_NEXT_INSPECTION = "Next Inspection cannot be null or date in past.<br/>";

    @Override
    public String validate(VehicleDto vehicleDto) {

        StringBuilder builder = new StringBuilder();
        if (vehicleDto.getCarId() < 1) {
            builder.append(INVALID_CAR_ID);
        }
        if (vehicleDto.getRegistryPlate() == null || vehicleDto.getRegistryPlate().trim().isEmpty()) {
            builder.append(INVALID_REGISTRY_PLATE);
        }
        if (vehicleDto.getOwnerId() < 1) {
            builder.append(INVALID_OWNER_ID);
        }
        if (vehicleDto.getNextInspection() == null || vehicleDto.getNextInspection().isBefore(LocalDate.now())) {
            builder.append(INVALID_NEXT_INSPECTION);
        }

        return builder.toString();
    }
}
