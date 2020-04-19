package pl.coderslab.experimental;

import pl.coderslab.commons.ParameterReaderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name="RestCustomerController", urlPatterns = "/rest/customer")
public class RestCustomerController extends HttpServlet {

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String SHOW_ONE = "/WEB-INF/jsp/showCustomer.jsp";
    private static final String SHOW_ALL = "/WEB-INF/jsp/showAllCustomers.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        int id = ParameterReaderService.getIdFromRequest(req, "id");
        String redir;

        if (id == 0) {
            redir = SHOW_ONE;
            // get all
        } else {
            redir = SHOW_ALL;
            // get 1
        }
        getServletContext().getRequestDispatcher(redir).forward(req, resp);
    }
}
