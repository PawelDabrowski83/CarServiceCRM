package pl.coderslab.car;

import pl.coderslab.commons.ValidatorInterface;

import java.util.regex.Pattern;

public class CarValidator implements ValidatorInterface<CarDto> {

    protected static final Pattern PRODUCTION_YEAR_PATTERN = Pattern.compile("^19\\d{2}$|^20[0-2]\\d{1}$");
    protected static final String INVALID_MARK = "Mark cannot be empty. <br/>" + System.lineSeparator();
    protected static final String INVALID_MODEL =  "Model cannot be empty. <br/>" + System.lineSeparator();
    protected static final String INVALID_PRODYEAR = "Wrong year format or year outside of range 1900-202x <br/>" + System.lineSeparator();

    @Override
    public String validate(CarDto carDto) {
        StringBuilder builder = new StringBuilder();
        if (carDto.getMark() == null || carDto.getMark().trim().isEmpty()) {
            builder.append(INVALID_MARK);
        }
        if (carDto.getModel() == null || carDto.getModel().trim().isEmpty()) {
            builder.append(INVALID_MODEL);
        }
        if (!PRODUCTION_YEAR_PATTERN.matcher(String.valueOf(carDto.getProductionYear())).matches()) {
            builder.append(INVALID_PRODYEAR);
        }
        return builder.toString();
    }
}
