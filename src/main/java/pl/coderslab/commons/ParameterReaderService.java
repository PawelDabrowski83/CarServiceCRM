package pl.coderslab.commons;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParameterReaderService {

    public static int getIdFromRequest (HttpServletRequest request, String idName) {
        int id = 0;
        String idAsString = request.getParameter(idName);
        try {
            id = Integer.parseInt(idAsString);
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Extraction unsuccessful with id "+ idAsString);
        }
        return id;
    }

    public static Timestamp convertLocalDateToTimestamp(LocalDate localDate) {
        return Timestamp.valueOf(LocalDateTime.of(localDate, LocalTime.NOON));
    }

    public static LocalDate convertTimestampToLocalDate(Timestamp timestamp) {
        return timestamp.toLocalDateTime().toLocalDate();
    }
}
