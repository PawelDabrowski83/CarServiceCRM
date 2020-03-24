package pl.coderslab.commons;

import javax.servlet.http.HttpServletRequest;

public class ParameterReaderService {

    public static int getIdFromRequest (HttpServletRequest request) {
        int id = 0;
        String idAsString = request.getParameter("id");
        try {
            id = Integer.parseInt(idAsString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Extraction unsuccessful with id "+ idAsString);
        }
        return id;
    }
}
