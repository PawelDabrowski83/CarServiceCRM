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
    private static DispatcherInfo dispatcherInfo = new DispatcherInfo.Builder(false, INDEX_JSP).build();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatchAll(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatchAll(request, response);
    }

    private void dispatchAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getMethod();
        String action = request.getParameter("action");
        String ordnung = request.getParameter("ordnung");
        String id = request.getParameter("id");

        UrlParameterInfo urlParameterInfo = new UrlParameterInfo.Builder(method, action, ordnung, id).build();
        request.setAttribute("urlParameterInfo", urlParameterInfo);
        if ("managePersonDetails".equals(action)) {
            dispatcherInfo = PersonDispatcher.dispatch(request, response, dispatcherInfo);
        }

        if (dispatcherInfo.isSendRedirect()) {
            response.sendRedirect(dispatcherInfo.getRedirURL());
        } else {
            getServletContext().getRequestDispatcher(dispatcherInfo.getRedirURL()).forward(request, response);
        }
    }
}
