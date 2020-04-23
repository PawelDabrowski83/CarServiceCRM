package pl.coderslab.employee;

import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ValidatorInterface;
import pl.coderslab.person.*;
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
    private static final GenericDao<EmployeeEntity> EMPLOYEE_DAO = new EmployeeDaoImpl();
    private static final MapperInterface<EmployeeDto, Employee, EmployeeEntity> EMPLOYEE_MAPPER = new EmployeeMapper();
    private static final ServiceInterface<EmployeeDto> EMPLOYEE_SERVICE = new EmployeeService(EMPLOYEE_DAO, EMPLOYEE_MAPPER);
    private static final PersonDaoInterface<PersonEntity> PERSON_DAO = new PersonDaoImpl();
    private static final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER = new PersonMapper();
    private static final PersonServiceInterface<PersonDto> PERSON_SERVICE = new PersonService(PERSON_DAO, PERSON_MAPPER);
    private static final String EMPLOYEE_ID = "employeeId";
    private static final ValidatorInterface<EmployeeDto> EMPLOYEE_VALIDATOR = new EmployeeValidator();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = ParameterReaderService.getIdFromRequest(request, "id");
        String action = request.getParameter("action");
        String redir = EMPLOYEE_FORM;

//        if ("edit".equals(action) | "new".equals(action)) {
//        }

        System.out.println("(employee ACTION: " + action);

        switch (action) {
            case "view":
                Set<EmployeeDto> dtos = EMPLOYEE_SERVICE.findAll();
                request.setAttribute("employees", dtos);
                redir = SHOW_ALL_EMPLOYEES;
                break;
            case "delete":
                EMPLOYEE_SERVICE.delete(id);
                response.sendRedirect(PREPARE_ALL_EMPLOYEES);
                return;
            case "edit":
                EmployeeDto employeeDto = EMPLOYEE_SERVICE.read(id);
                request.setAttribute("employee", employeeDto);
                request.setAttribute("person", PERSON_SERVICE.read(employeeDto.getPersonId()));
            case "new":
                request.setAttribute("persons", PERSON_SERVICE.findUnmatchedEmployees());
                request.setAttribute("action", action);
            default:
        }

        request.setAttribute("error", request.getParameter("error"));
        request.setAttribute("errorMessage", request.getParameter("errorMessage"));

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
        dto.setFullname(PERSON_SERVICE.read(dto.getPersonId()).getFullname());

        String validateResult = EMPLOYEE_VALIDATOR.validate(dto);
        if (!validateResult.isEmpty()) {
            request.setAttribute("error", true);
            request.setAttribute("errorMessage", validateResult);
            if ("edit".equals(action)) {
                request.setAttribute("action", "edit");
                dto.setEmployeeId(id);
            } else {
                request.setAttribute("action", "new");
            }
            request.setAttribute("employee", dto);
            request.setAttribute("person", PERSON_SERVICE.read(dto.getPersonId()));
            request.setAttribute("persons", PERSON_SERVICE.findUnmatchedEmployees());
            getServletContext().getRequestDispatcher(EMPLOYEE_FORM).forward(request, response);
            return;
        } else {
            request.setAttribute("error", false);
        }

        if ("edit".equals(action)) {
            dto.setEmployeeId(id);
            EMPLOYEE_SERVICE.update(dto);
        } else {
            EMPLOYEE_SERVICE.create(dto);
        }
        response.sendRedirect(PREPARE_ALL_EMPLOYEES);
    }

}
