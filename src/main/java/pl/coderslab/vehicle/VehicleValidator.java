package pl.coderslab.vehicle;

import pl.coderslab.commons.ValidatorInterface;

import java.time.LocalDate;

public class VehicleValidator implements ValidatorInterface<VehicleDto> {

    @Override
    public String validate(VehicleDto vehicleDto) {

        StringBuilder builder = new StringBuilder();
        if (vehicleDto.getCarId() < 1) {
            builder.append("VehicleId cannot be empty or lower than 1.<br/>");
        }
        if (vehicleDto.getRegistryPlate() == null || vehicleDto.getRegistryPlate().isEmpty()) {
            builder.append("Registry plate cannot be empty.<br/>");
        }
        if (vehicleDto.getOwnerId() < 1) {
            builder.append("OwnerId cannot be empty or lower than 1.<br/>");
        }
        if (vehicleDto.getNextInspection() == null || vehicleDto.getNextInspection().isBefore(LocalDate.now())) {
            builder.append("Next Inspection cannot be null or date in past.<br/>");
        }

        return builder.toString();
    }
}
