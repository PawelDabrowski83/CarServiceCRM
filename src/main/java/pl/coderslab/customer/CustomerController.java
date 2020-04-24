package pl.coderslab.customer;

import pl.coderslab.commons.*;
import pl.coderslab.person.*;
import pl.coderslab.customer.CustomerValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet (name="CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {

    private static final String FORM_CUSTOMER = "/WEB-INF/jsp/formCustomers.jsp";
    private static final String SHOW_ALL_CUSTOMERS = "/WEB-INF/jsp/allCustomers.jsp";
    private static final String PREPARE_ALL_CUSTOMERS = "/customers?action=view";
    private static final PersonDaoInterface<PersonEntity> PERSON_DAO = new PersonDaoImpl();
    private static final MapperInterface<PersonDto, Person, PersonEntity> PERSON_MAPPER = new PersonMapper();
    private static final PersonServiceInterface<PersonDto> PERSON_SERVICE = new PersonService(PERSON_DAO, PERSON_MAPPER);
    private static final GenericDao<CustomerEntity> CUSTOMER_DAO = new CustomerDaoImpl();
    private static final MapperInterface<CustomerDto, Customer, CustomerEntity> CUSTOMER_MAPPER = new CustomerMapper(PERSON_DAO, PERSON_MAPPER);
    private static final ServiceInterface<CustomerDto> CUSTOMER_SERVICE = new CustomerService(CUSTOMER_DAO, CUSTOMER_MAPPER);
    private static final ValidatorInterface<CustomerDto> CUSTOMER_VALIDATOR = new CustomerValidator();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int customerId = ParameterReaderService.getIdFromRequest(request, "id");
        String redir = FORM_CUSTOMER;

        if ("new".equals(action) | "edit".equals(action)) {
            request.setAttribute("persons", PERSON_SERVICE.findUnmatchedCustomers());
        }

        switch (action) {
            case "view":
                Set<CustomerDto> dtos = CUSTOMER_SERVICE.findAll();
                request.setAttribute("customers", dtos);
                redir = SHOW_ALL_CUSTOMERS;
                break;
            case "edit":
                CustomerDto dto = CUSTOMER_SERVICE.read(customerId);
                request.setAttribute("customer", dto);
                request.setAttribute("person", PERSON_SERVICE.read(dto.getPersonalId()));
            case "new":
                request.setAttribute("action", action);
                break;
            case "delete":
                CUSTOMER_SERVICE.delete(customerId);
                response.sendRedirect(PREPARE_ALL_CUSTOMERS);
                return;
            default:
        }

        request.setAttribute("error", request.getParameter("error"));
        request.setAttribute("errorMessage", request.getParameter("errorMessage"));
        getServletContext().getRequestDispatcher(redir).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        int personId = ParameterReaderService.getIdFromRequest(request, "personId");
        CustomerDto dto = new CustomerDto();
        dto.setPersonalId(personId);

        String validateResult = CUSTOMER_VALIDATOR.validate(dto);
        if (!validateResult.isEmpty()) {
            request.setAttribute("error", true);
            request.setAttribute("errorMessage", validateResult);
            request.setAttribute("customer", dto);
            request.setAttribute("persons", PERSON_SERVICE.findUnmatchedCustomers());
            if ("edit".equals(action)) {
                request.setAttribute("action", "edit");
            } else {
                request.setAttribute("action", "new");
            }
            getServletContext().getRequestDispatcher(FORM_CUSTOMER).forward(request, response);
            return;
        } else {
            request.setAttribute("error", false);
        }

        if ("edit".equals(action)) {
            int customerId = ParameterReaderService.getIdFromRequest(request, "customerId");
            dto.setCustomerId(customerId);
            CUSTOMER_SERVICE.update(dto);
        } else {
            CUSTOMER_SERVICE.create(dto);
        }
        response.sendRedirect(PREPARE_ALL_CUSTOMERS);
    }

}
