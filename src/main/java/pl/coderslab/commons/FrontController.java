package pl.coderslab.commons;

import pl.coderslab.Person.PersonDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FrontController", urlPatterns = "/")
public class FrontController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String address = "/index.jsp";
        System.out.println("ACTION: " + action);
        if ("managePersonDetails".equals(action)) {
            address = PersonDispatcher.doGet(request, response, address);
            System.out.println("NOW!");
        }
        getServletContext().getRequestDispatcher(address).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
