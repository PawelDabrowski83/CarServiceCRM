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

    private static final String INDEX_JSP = "/index.jsp";
    private static DispatcherInstance dispatcherInstance = new DispatcherInstance.Builder(false, INDEX_JSP).build();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatchAll(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatchAll(request, response);
    }

    private void dispatchAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        request.setAttribute("method", request.getMethod());
        request.setAttribute("ordnung", request.getParameter("ordnung"));


        if ("managePersonDetails".equals(action)) {
            dispatcherInstance = PersonDispatcher.dispatch(request, response, dispatcherInstance);
        }

        if (dispatcherInstance.isSendRedirect()) {
            response.sendRedirect(dispatcherInstance.getRedirURL());
        } else {
            getServletContext().getRequestDispatcher(dispatcherInstance.getRedirURL()).forward(request, response);
        }
    }
}
