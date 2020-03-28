package pl.coderslab.commons;

import javax.servlet.http.HttpServletRequest;

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
}
