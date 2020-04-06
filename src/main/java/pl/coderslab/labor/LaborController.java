package pl.coderslab.labor;

import pl.coderslab.commons.ParameterReaderService;
import pl.coderslab.commons.ServiceInterface;
import pl.coderslab.customer.CustomerDto;
import pl.coderslab.customer.CustomerService;
import pl.coderslab.employee.EmployeeDto;
import pl.coderslab.employee.EmployeeService;
import pl.coderslab.vehicle.VehicleDto;
import pl.coderslab.vehicle.VehicleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

@WebServlet (name="LaborController", urlPatterns = "/labors")
public class LaborController extends HttpServlet {

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String FORM_LABOR = "/WEB-INF/jsp/formLabors.jsp";
    private static final String PREPARE_ALL_LABORS = "/labors?action=view";
    private static final String SHOW_ALL_LABORS = "/WEB-INF/jsp/allLabors.jsp";
    private static final ServiceInterface<LaborDto> LABOR_SERVICE = new LaborService();
    private static final ServiceInterface<VehicleDto> VEHICLE_SERVICE = new VehicleService();
    private static final ServiceInterface<EmployeeDto> EMPLOYEE_SERVICE = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String action = request.getParameter("action");
        int laborId = ParameterReaderService.getIdFromRequest(request, "id");
        String redir = FORM_LABOR;

        if ("new".equals(action) | "edit".equals(action)) {
            Set<EmployeeDto> employeeDtos = EMPLOYEE_SERVICE.findAll();
            request.setAttribute("employees", employeeDtos);
            Set<VehicleDto> vehicleDtos = VEHICLE_SERVICE.findAll();
            request.setAttribute("vehicles", vehicleDtos);
            EnumSet<Labor.StatusEnum> enums = EnumSet.allOf(Labor.StatusEnum.class);
            request.setAttribute("statuses", enums);
        }

        switch (action) {
            case "view":
                Set<LaborDto> dtos = LABOR_SERVICE.findAll();
                request.setAttribute("labors", dtos);
                redir = SHOW_ALL_LABORS;
                break;
            case "delete":
                LABOR_SERVICE.delete(laborId);
                response.sendRedirect(PREPARE_ALL_LABORS);
                return;
            case "edit":
                LaborDto dto = LABOR_SERVICE.read(laborId);
                request.setAttribute("labor", dto);
            case "new":
                request.setAttribute("action", action);
            default:
        }
        getServletContext().getRequestDispatcher(redir).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String action = request.getParameter("action");
        int laborId = ParameterReaderService.getIdFromRequest(request, "laborId");
        LocalDate registrationDate = ParameterReaderService.parseLocalDate(request.getParameter("registrationDate"));
        LocalDate scheduledDate = ParameterReaderService.parseLocalDate(request.getParameter("scheduledDate"));
        LocalDate startedDate = ParameterReaderService.parseLocalDate(request.getParameter("startedDate"));
        LocalDate finishedDate = ParameterReaderService.parseLocalDate(request.getParameter("finishedDate"));
        int employeeId = ParameterReaderService.getIdFromRequest(request, "employeeId");
        String descriptionIssue = request.getParameter("descriptionIssue");
        String descriptionService = request.getParameter("descriptionService");
        String status = request.getParameter("status");
        int vehicleId = ParameterReaderService.getIdFromRequest(request, "vehicleId");
        double customerCost = ParameterReaderService.getDoubleFromRequest(request, "customerCost");
        double materialCost = ParameterReaderService.getDoubleFromRequest(request, "materialCost");
        int mhTotal = ParameterReaderService.getIdFromRequest(request, "mhTotal");

        LaborDto dto = new LaborDto();
        dto.setRegistrationDate(registrationDate);
        dto.setScheduledDate(scheduledDate);
        dto.setStartedDate(startedDate);
        dto.setFinishedDate(finishedDate);
        dto.setEmployeeId(employeeId);
        dto.setDescriptionIssue(descriptionIssue);
        dto.setDescriptionService(descriptionService);
        dto.setStatus(status);
        dto.setVehicleId(vehicleId);
        dto.setCustomerCost(customerCost);
        dto.setMaterialCost(materialCost);
        dto.setMhTotal(mhTotal);

        if ("edit".equals(action)) {
            dto.setLaborId(laborId);
            LABOR_SERVICE.update(dto);
        } else {
            LABOR_SERVICE.create(dto);
        }
        response.sendRedirect(PREPARE_ALL_LABORS);
    }
}
