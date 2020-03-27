package pl.coderslab.Person;

import pl.coderslab.commons.ParameterReaderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet (name="PersonController", urlPatterns = "/managePersonDetails")
public class PersonController extends HttpServlet {

    private static final String PERSON_FORM = "/WEB-INF/jsp/formPersonDetails.jsp";
    private static final String SHOW_ALL_PERSONS = "/WEB-INF/jsp/allPersonDetails.jsp";
    private static final String PREP_ALL_PERSONS = "/managePersonDetails?action=view";
    private static final PersonService PERSON_SERVICE = new PersonService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int id = ParameterReaderService.getIdFromRequest(request);
        PersonDto dto = new PersonDto();

        switch (action) {
            case "view":
                Set<PersonDto> dtos = PERSON_SERVICE.findAll();
                request.setAttribute("persons", dtos);
                getServletContext().getRequestDispatcher(SHOW_ALL_PERSONS).forward(request, response);
                return;
            case "edit":
                dto = PERSON_SERVICE.read(id);
                request.setAttribute("person", dto);
                request.setAttribute("action", action);
                break;
            case "delete":
                PERSON_SERVICE.delete(id);
                response.sendRedirect(PREP_ALL_PERSONS);
                return;
            default:
        }
        getServletContext().getRequestDispatcher(PERSON_FORM).forward(request, response);



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int id = ParameterReaderService.getIdFromRequest(request);
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

        if ("edit".equals(action)) {
            dto.setId(id);
            PERSON_SERVICE.update(dto);
        } else {
            PERSON_SERVICE.create(dto);
        }
        response.sendRedirect(PREP_ALL_PERSONS);

    }
}
