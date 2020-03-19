package pl.coderslab.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class PersonDispatcher {

    public static final PersonService PERSON_SERVICE = new PersonService();

    public static String doGet(HttpServletRequest request, HttpServletResponse response, String address) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Set<PersonDto> persons = PERSON_SERVICE.findAll();
        request.setAttribute("persons", persons);

        address = "/WEB-INF/jsp/allPersonDetails.jsp";
        return address;

    }

}
