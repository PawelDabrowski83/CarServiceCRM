package pl.coderslab.employee;

import pl.coderslab.person.PersonDto;
import pl.coderslab.person.PersonService;
import pl.coderslab.commons.ParameterReaderService;
import pl.coderslab.commons.ServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet (name = "EmployeeController", urlPatterns = "/employees")
public class EmployeeController extends HttpServlet {

    private static final String EMPLOYEE_FORM = "/WEB-INF/jsp/formEmployees.jsp";
    private static final String SHOW_ALL_EMPLOYEES = "/WEB-INF/jsp/allEmployees.jsp";
    private static final String PREPARE_ALL_EMPLOYEES = "/employees?action=view";
    private static final ServiceInterface<EmployeeDto> EMPLOYEE_SERVICE = new EmployeeService();
    private static final ServiceInterface<PersonDto> PERSON_SERVICE = new PersonService();
    private static final String EMPLOYEE_ID = "employeeId";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = ParameterReaderService.getIdFromRequest(request, EMPLOYEE_ID);
        String action = request.getParameter("action");
        String redir = EMPLOYEE_FORM;

        if ("edit".equals(action) | "new".equals(action)) {
            Set<PersonDto> personDtos = PERSON_SERVICE.findAll();
            request.setAttribute("persons", personDtos);
        }

        switch (action) {
            case "view":
                Set<EmployeeDto> dtos = EMPLOYEE_SERVICE.findAll();
                request.setAttribute("employees", dtos);
                redir = SHOW_ALL_EMPLOYEES;
                break;
            case "edit":
                request.setAttribute("employee", EMPLOYEE_SERVICE.read(id));
                request.setAttribute("action", action);
                break;
            case "delete":
                EMPLOYEE_SERVICE.delete(id);
                response.sendRedirect(PREPARE_ALL_EMPLOYEES);
                return;
            default:
                request.setAttribute("action", "new");
        }
        getServletContext().getRequestDispatcher(redir).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = ParameterReaderService.getIdFromRequest(request, EMPLOYEE_ID);
        String action = request.getParameter("action");

        double mhCost;
        try {
            mhCost = Double.parseDouble(request.getParameter("mhCost"));
        } catch (NumberFormatException e) {
            mhCost = 0;
        }
        int personalId;
        try {
            personalId = Integer.parseInt(request.getParameter("personId"));
        } catch (NumberFormatException e) {
            personalId = 0;
        }

        EmployeeDto dto = new EmployeeDto();
        dto.setPersonId(personalId);
        dto.setMhCost(mhCost);

        if ("edit".equals(action)) {
            dto.setEmployeeId(id);
            EMPLOYEE_SERVICE.update(dto);
        } else {
            EMPLOYEE_SERVICE.create(dto);
        }
        response.sendRedirect(PREPARE_ALL_EMPLOYEES);
    }

}
