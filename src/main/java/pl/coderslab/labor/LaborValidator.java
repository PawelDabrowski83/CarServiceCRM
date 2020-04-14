package pl.coderslab.labor;

import pl.coderslab.commons.ValidatorInterface;

import java.time.LocalDate;

public class LaborValidator implements ValidatorInterface<LaborDto> {

    @Override
    public String validate(LaborDto laborDto) {

        StringBuilder builder = new StringBuilder();
        if (laborDto.getRegistrationDate() == null || laborDto.getRegistrationDate().isBefore(LocalDate.of(2020,1,1))) {
            builder.append("Registration date cannot be empty or before 2020.<br/>");
        }
        if (laborDto.getScheduledDate() == null || laborDto.getScheduledDate().isBefore(laborDto.getRegistrationDate())) {
            builder.append("Scheduled date cannot be empty or before Registration date.<br/>");
        }
        if (laborDto.getStartedDate() == null || laborDto.getStartedDate().isBefore(laborDto.getRegistrationDate())) {
            builder.append("Started date cannot be empty or before Registration date.<br/>");
        }
        if (laborDto.getEmployeeId() < 1) {
            builder.append("EmployeeId cannot be empty or lesser than 1.<br/>");
        }
        if (laborDto.getDescriptionIssue() == null || laborDto.getDescriptionIssue().isEmpty()) {
            builder.append("Description of the issue cannot be empty or null.<br/>");
        }
        if (laborDto.getDescriptionService() == null || laborDto.getDescriptionService().isEmpty()) {
            builder.append("Description of service cannot be empty or null.<br/>");
        }
        if (laborDto.getStatus() == null || laborDto.getStatus().isEmpty()) {
            builder.append("Status cannot be empty or null.<br/>");
        }
        if (laborDto.getVehicleId() < 1) {
            builder.append("VehicleId cannot be empty or lower than 1.<br/>");
        }
        if (laborDto.getCustomerCost() < 0) {
            builder.append("Customer cost cannot be empty or lower than 0.<br/>");
        }
        if (laborDto.getMaterialCost() < 0) {
            builder.append("Material cost cannot be empty or lower than 0.<br/>");
        }
        if (laborDto.getMhTotal() < 0) {
            builder.append("MH total cannot be empty or lower than 0.<br/>");
        }

        return builder.toString();
    }
}
