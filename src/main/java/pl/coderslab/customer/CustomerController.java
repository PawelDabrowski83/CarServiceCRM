package pl.coderslab.customer;

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

@WebServlet (name="CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {

    private static final String FORM_CUSTOMER = "/WEB-INF/jsp/formCustomers.jsp";
    private static final String SHOW_ALL_CUSTOMERS = "/WEB-INF/jsp/allCustomers.jsp";
    private static final String PREPARE_ALL_CUSTOMERS = "/customers?action=view";
    private static final ServiceInterface<PersonDto> PERSON_SERVICE = new PersonService();
    private static final ServiceInterface<CustomerDto> CUSTOMER_SERVICE = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int customerId = ParameterReaderService.getIdFromRequest(request, "id");
        String redir = FORM_CUSTOMER;

        if ("new".equals(action) | "edit".equals(action)) {
            Set<PersonDto> personDtos = PERSON_SERVICE.findAll();
            request.setAttribute("persons", personDtos);
        }

        switch (action) {
            case "view":
                Set<CustomerDto> dtos = CUSTOMER_SERVICE.findAll();
                request.setAttribute("customers", dtos);
                redir = SHOW_ALL_CUSTOMERS;
                break;
            case "edit":
                System.out.println();
                CustomerDto dto = CUSTOMER_SERVICE.read(customerId);
                request.setAttribute("customer", dto);
            case "new":
                request.setAttribute("action", action);
                break;
            case "delete":
                CUSTOMER_SERVICE.delete(customerId);
                response.sendRedirect(PREPARE_ALL_CUSTOMERS);
                return;
            default:
        }

        getServletContext().getRequestDispatcher(redir).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        int personId = ParameterReaderService.getIdFromRequest(request, "personId");
        CustomerDto dto = new CustomerDto();
        dto.setPersonalId(personId);

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
