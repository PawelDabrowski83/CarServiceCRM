package pl.coderslab.car;

import pl.coderslab.commons.ValidatorInterface;

import java.util.regex.Pattern;

public class CarValidator implements ValidatorInterface<CarDto> {

    private static final Pattern PRODUCTION_YEAR_PATTERN = Pattern.compile("^19\\d{2}$|^20[0-2]\\d{1}$");

    @Override
    public String validate(CarDto carDto) {
        StringBuilder builder = new StringBuilder();
        if (carDto.getMark() == null || carDto.getMark().isEmpty()) {
            builder.append("Mark cannot be empty. <br/>" + System.lineSeparator());
        }
        if (carDto.getModel() == null || carDto.getModel().isEmpty()) {
            builder.append("Model cannot be empty. <br/>" + System.lineSeparator());
        }
        if (!PRODUCTION_YEAR_PATTERN.matcher(String.valueOf(carDto.getProductionYear())).matches()) {
            builder.append("Wrong year format or year outside of range 1900-202x <br/>" + System.lineSeparator());
        }
        return builder.toString();
    }
}
