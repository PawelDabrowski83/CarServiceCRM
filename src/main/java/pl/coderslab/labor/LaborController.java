package pl.coderslab.labor;

import pl.coderslab.commons.*;
import pl.coderslab.customer.CustomerDto;
import pl.coderslab.customer.CustomerService;
import pl.coderslab.employee.*;
import pl.coderslab.vehicle.*;

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
    private static final GenericDao<LaborEntity> LABOR_DAO = new LaborDaoImpl();
    private static final MapperInterface<LaborDto, Labor, LaborEntity> LABOR_MAPPER = new LaborMapper();
    private static final ServiceInterface<LaborDto> LABOR_SERVICE = new LaborService(LABOR_DAO, LABOR_MAPPER);
    private static final GenericDao<VehicleEntity> VEHICLE_DAO = new VehicleDaoImpl();
    private static final MapperInterface<VehicleDto, Vehicle, VehicleEntity> VEHICLE_MAPPER = new VehicleMapper();
    private static final ServiceInterface<VehicleDto> VEHICLE_SERVICE = new VehicleService(VEHICLE_DAO, VEHICLE_MAPPER);
    private static final GenericDao<EmployeeEntity> EMPLOYEE_DAO = new EmployeeDaoImpl();
    private static final MapperInterface<EmployeeDto, Employee, EmployeeEntity> EMPLOYEE_MAPPER = new EmployeeMapper();
    private static final ServiceInterface<EmployeeDto> EMPLOYEE_SERVICE = new EmployeeService(EMPLOYEE_DAO, EMPLOYEE_MAPPER);
    private static final ValidatorInterface<LaborDto> LABOR_VALIDATOR = new LaborValidator();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String action = request.getParameter("action");
        int laborId = ParameterReaderService.getIdFromRequest(request, "id");
        String redir = FORM_LABOR;

        if ("new".equals(action) | "edit".equals(action)) {
            request.setAttribute("employees", EMPLOYEE_SERVICE.findAll());
            request.setAttribute("vehicles", VEHICLE_SERVICE.findAll());
//            EnumSet<Labor.StatusEnum> enums = EnumSet.allOf(Labor.StatusEnum.class);
            request.setAttribute("statuses", EnumSet.allOf(Labor.StatusEnum.class));
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

        request.setAttribute("error", request.getParameter("error"));
        request.setAttribute("errorMessage", request.getParameter("errorMessage"));

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
        dto.setEmployeeFullname(EMPLOYEE_SERVICE.read(employeeId).getFullname());
        dto.setDescriptionIssue(descriptionIssue);
        dto.setDescriptionService(descriptionService);
        dto.setStatus(status);
        dto.setVehicleId(vehicleId);
        dto.setVehicleSignature(VEHICLE_SERVICE.read(vehicleId).getCarSignature());
        dto.setCustomerCost(customerCost);
        dto.setMaterialCost(materialCost);
        dto.setMhTotal(mhTotal);

        String validateResult = LABOR_VALIDATOR.validate(dto);
        if (!validateResult.isEmpty()) {
            request.setAttribute("error", true);
            request.setAttribute("errorMessage", validateResult);
            request.setAttribute("labor", dto);
            request.setAttribute("employees", EMPLOYEE_SERVICE.findAll());
            request.setAttribute("vehicles", VEHICLE_SERVICE.findAll());
            request.setAttribute("statuses", EnumSet.allOf(Labor.StatusEnum.class));
            if ("edit".equals(action)) {
                request.setAttribute("action", "edit");
            } else {
                request.setAttribute("action", "new");
            }
            getServletContext().getRequestDispatcher(FORM_LABOR).forward(request, response);
            return;
        } else {
            request.setAttribute("error", false);
        }

        if ("edit".equals(action)) {
            dto.setLaborId(laborId);
            LABOR_SERVICE.update(dto);
        } else {
            LABOR_SERVICE.create(dto);
        }
        response.sendRedirect(PREPARE_ALL_LABORS);
    }
}
