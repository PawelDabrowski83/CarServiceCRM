package pl.coderslab.vehicle;

import pl.coderslab.car.*;
import pl.coderslab.commons.MapperInterface;
import pl.coderslab.commons.ParameterReaderService;
import pl.coderslab.commons.ServiceInterface;
import pl.coderslab.customer.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Set;

@WebServlet (name="VehicleController", urlPatterns = "/vehicles")
public class VehicleController extends HttpServlet {

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String FORM_VEHICLE = "/WEB-INF/jsp/formVehicles.jsp";
    private static final String SHOW_ALL_VEHICLES = "/WEB-INF/jsp/allVehicles.jsp";
    private static final String PREPARE_ALL_VEHICLES = "/vehicles?action=view";
    private static final ServiceInterface<CarDto> CAR_SERVICE = new CarService();
    private static final MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER = new CarMapper();
    private static final ServiceInterface<CustomerDto> CUSTOMER_SERVICE = new CustomerService();
    private static final MapperInterface<CustomerDto, Customer, CustomerEntity> CUSTOMER_MAPPER = new CustomerMapper();
    private static final ServiceInterface<VehicleDto> VEHICLE_SERVICE = new VehicleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String action = request.getParameter("action");
        int vehicleId = ParameterReaderService.getIdFromRequest(request, "id");
        String redir = FORM_VEHICLE;

        if ("edit".equals(action) | "new".equals(action)) {
            Set<CarDto> carDtos = CAR_SERVICE.findAll();
            Set<CustomerDto> customerDtos = CUSTOMER_SERVICE.findAll();
            request.setAttribute("cars", carDtos);
            request.setAttribute("customers", customerDtos);
        }

        switch (action) {
            case "view":
                Set<VehicleDto> dtos = VEHICLE_SERVICE.findAll();
                request.setAttribute("vehicles", dtos);
                redir = SHOW_ALL_VEHICLES;
                break;
            case "delete":
                VEHICLE_SERVICE.delete(vehicleId);
                response.sendRedirect(PREPARE_ALL_VEHICLES);
                return;
            case "edit":
                VehicleDto dto = VEHICLE_SERVICE.read(vehicleId);
                request.setAttribute("vehicle", dto);
            case "new":
                request.setAttribute("action", action);
                break;
            default:
        }
        getServletContext().getRequestDispatcher(redir).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String action = request.getParameter("action");
        int vehicleId = ParameterReaderService.getIdFromRequest(request, "vehicleId");

        int carId = ParameterReaderService.getIdFromRequest(request, "carId");
        String registryPlate = request.getParameter("registryPlate");
        String color = request.getParameter("color");
        String notes = request.getParameter("notes");
        String nextInspectionAsString = request.getParameter("nextInspection");
        int ownerId = ParameterReaderService.getIdFromRequest(request, "ownerId");

        VehicleDto dto = new VehicleDto();
        dto.setCarId(carId);
        dto.setOwnerId(ownerId);
        dto.setRegistryPlate(registryPlate);
        dto.setColor(color);
        dto.setNotes(notes);
        try {
            dto.setNextInspection(LocalDate.parse(nextInspectionAsString));
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            dto.setNextInspection(LocalDate.of(1,1,1));
        }

        if ("edit".equals(action)) {
            dto.setVehicleId(vehicleId);
            VEHICLE_SERVICE.update(dto);
        } else {
            VEHICLE_SERVICE.create(dto);
        }

        response.sendRedirect(PREPARE_ALL_VEHICLES);
    }
}
