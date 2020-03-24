package pl.coderslab.Person;

import pl.coderslab.commons.DispatcherInfo;
import pl.coderslab.commons.UrlParameterInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class PersonDispatcher {

    public static final PersonService PERSON_SERVICE = new PersonService();
    private static final String VIEW_ALL_PERSONS = "/WEB-INF/jsp/allPersonDetails.jsp";
    private static final String PREPARE_VIEW_ALL_PERSONS = "/?action=managePersonDetails&ordnung=view";
    private static final String FORM_PERSON = "/WEB-INF/jsp/formPersonDetails.jsp";

    public static DispatcherInfo dispatch(HttpServletRequest request, HttpServletResponse response, DispatcherInfo dispatcherInfo) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UrlParameterInfo urlParameterInfo = (UrlParameterInfo) request.getAttribute("urlParameterInfo");
        String method = urlParameterInfo.getMethod();
        String action = urlParameterInfo.getAction();
        String ordnung = urlParameterInfo.getOrdnung();
        int id = urlParameterInfo.getId();

        PersonDto dto = new PersonDto();

        if ("GET".equals(method)) {
            switch (ordnung) {
                case "edit":
                    dto = PERSON_SERVICE.readPerson(id);
                    request.setAttribute("person", dto);
                    dispatcherInfo = new DispatcherInfo.Builder(false, FORM_PERSON).build();
                    break;
                case "delete":
                    PERSON_SERVICE.deletePerson(id);
                    dispatcherInfo = new DispatcherInfo.Builder(true, PREPARE_VIEW_ALL_PERSONS).build();
                    break;
                case "main":
                case "view":
                    Set<PersonDto> persons = PERSON_SERVICE.findAll();
                    request.setAttribute("persons", persons);
                    dispatcherInfo = new DispatcherInfo.Builder(false, VIEW_ALL_PERSONS).build();
                    break;
                default:
                    dispatcherInfo = new DispatcherInfo.Builder(false, FORM_PERSON).build();
            }
        } else { // POST
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String notes = request.getParameter("notes");
            String birthYear = request.getParameter("birthYear");
            String birthMonth = request.getParameter("birthMonth");
            String birthDay = request.getParameter("birthDay");
            String updated = request.getParameter("updated");

            dto.setFirstName(firstName);
            dto.setLastName(lastName);
            dto.setAddress(address);
            dto.setPhone(phone);
            dto.setNotes(notes);
            dto.setBirthYear(birthYear);
            dto.setBirthMonth(birthMonth);
            dto.setBirthDay(birthDay);

            if ("edit".equals(ordnung)) {
                dto.setId(id);
                dto.setUpdated(updated);
                PERSON_SERVICE.updatePerson(dto);
            } else {
                PERSON_SERVICE.createPerson(dto);
            }
            dispatcherInfo = new DispatcherInfo.Builder(true, PREPARE_VIEW_ALL_PERSONS).build();

        }

        return dispatcherInfo;

    }

}
