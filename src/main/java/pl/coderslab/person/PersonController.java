package pl.coderslab.person;

import pl.coderslab.commons.ParameterReaderService;
import pl.coderslab.commons.ValidatorInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet (name="PersonController", urlPatterns = "/managePersonDetails")
public class PersonController extends HttpServlet {

    private static final String PERSON_PATH = "/managePersonDetails";
    private static final String PERSON_FORM = "/WEB-INF/jsp/formPersonDetails.jsp";
    private static final String SHOW_ALL_PERSONS = "/WEB-INF/jsp/allPersonDetails.jsp";
    private static final String PREP_ALL_PERSONS = PERSON_PATH + "?action=view";
    private static final PersonService PERSON_SERVICE = new PersonService();
    private static final ValidatorInterface<PersonDto> PERSON_VALIDATOR = new PersonValidator();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int id = ParameterReaderService.getIdFromRequest(request, "id");

        switch (action) {
            case "view":
                Set<PersonDto> dtos = PERSON_SERVICE.findAll();
                request.setAttribute("persons", dtos);
                getServletContext().getRequestDispatcher(SHOW_ALL_PERSONS).forward(request, response);
                return;
            case "edit":
                PersonDto dto = PERSON_SERVICE.read(id);
                request.setAttribute("person", dto);
                request.setAttribute("action", "edit");
                break;
            case "delete":
                PERSON_SERVICE.delete(id);
                response.sendRedirect(PREP_ALL_PERSONS);
                return;
            default:
        }

        String error = request.getParameter("error");
        String errorMessage = request.getParameter("errorMessage");
        request.setAttribute("error", error);
        request.setAttribute("errorMessage", errorMessage);

        getServletContext().getRequestDispatcher(PERSON_FORM).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int id = ParameterReaderService.getIdFromRequest(request, "id");
        PersonDto dto = new PersonDto();
        String updated = request.getParameter("updated");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String notes = request.getParameter("notes");
        String birthYear = request.getParameter("birthYear");
        String birthMonth = request.getParameter("birthMonth");
        String birthDay = request.getParameter("birthDay");

        dto.setUpdated(updated);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setAddress(address);
        dto.setPhone(phone);
        dto.setNotes(notes);
        dto.setBirthYear(birthYear);
        dto.setBirthMonth(birthMonth);
        dto.setBirthDay(birthDay);

        String validateResult = PERSON_VALIDATOR.validate(dto);

        if (!validateResult.isEmpty()) {
            request.setAttribute("error", true);
            request.setAttribute("errorMessage", validateResult);
            if ("edit".equals(action)) {
                request.setAttribute("person", dto);
                request.setAttribute("action", "edit");
            };
            getServletContext().getRequestDispatcher(PERSON_FORM).forward(request, response);
            return;
        } else {
            request.setAttribute("error", false);
        }

        if ("edit".equals(action)) {
            dto.setId(id);
            PERSON_SERVICE.update(dto);
        } else {
            PERSON_SERVICE.create(dto);
        }
        response.sendRedirect(PREP_ALL_PERSONS);
    }

}
