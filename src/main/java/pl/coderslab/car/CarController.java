package pl.coderslab.car;

import pl.coderslab.commons.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet (name="CarController", urlPatterns = "/cars")
public class CarController extends HttpServlet {

    private static final String FORM_CAR = "/WEB-INF/jsp/formCars.jsp";
    private static final String SHOW_ALL_CARS = "/WEB-INF/jsp/allCars.jsp";
    private static final String PREPARE_ALL_CARS = "/cars?action=view";
    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final MapperInterface<CarDto, Car, CarEntity> CAR_MAPPER = new CarMapper();
    private static final GenericDao<CarEntity> CAR_DAO = new CarDaoImpl();
    private static final ServiceInterface<CarDto> CAR_SERVICE = new CarService(CAR_DAO, CAR_MAPPER);
    private static final ValidatorInterface<CarDto> CAR_VALIDATOR = new CarValidator();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String action = request.getParameter("action");
        int carId = ParameterReaderService.getIdFromRequest(request, "id");
        String redir = FORM_CAR;

        switch (action) {
            case "view":
                Set<CarDto> dtos = CAR_SERVICE.findAll();
                request.setAttribute("cars", dtos);
                redir = SHOW_ALL_CARS;
                break;
            case "delete":
                CAR_SERVICE.delete(carId);
                response.sendRedirect(PREPARE_ALL_CARS);
                return;
            case "edit":
                CarDto dto = CAR_SERVICE.read(carId);
                request.setAttribute("car", dto);
            case "new":
                request.setAttribute("action", action);
                break;
            default:
        }

        String error = request.getParameter("error");
        String errorMessage = request.getParameter("errorMessage");
        request.setAttribute("error", error);
        request.setAttribute("errorMessage", errorMessage);

        getServletContext().getRequestDispatcher(redir).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String action = request.getParameter("action");
        int carId = ParameterReaderService.getIdFromRequest(request, "carId");

        String mark = request.getParameter("mark");
        String model = request.getParameter("model");
        int productionYear = ParameterReaderService.getIdFromRequest(request, "productionYear");

        CarDto dto = new CarDto();
        dto.setMark(mark);
        dto.setModel(model);
        dto.setProductionYear(productionYear);

        String validateResult = CAR_VALIDATOR.validate(dto);
        if (!validateResult.isEmpty()) {
            request.setAttribute("error", true);
            request.setAttribute("errorMessage", validateResult);
            request.setAttribute("car", dto);
            if ("edit".equals(action)) {
                request.setAttribute("action", "edit");
            }
            getServletContext().getRequestDispatcher(FORM_CAR).forward(request, response);
            return;
        } else {
            request.setAttribute("error", false);
        }

        if ("edit".equals(action)) {
            dto.setCarId(carId);
            CAR_SERVICE.update(dto);
        } else {
            CAR_SERVICE.create(dto);
        }
        response.sendRedirect(PREPARE_ALL_CARS);
    }
}
