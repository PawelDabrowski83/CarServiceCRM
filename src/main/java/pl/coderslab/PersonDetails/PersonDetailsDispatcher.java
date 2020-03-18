package pl.coderslab.PersonDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonDetailsDispatcher {

    public static String doGet(HttpServletRequest request, HttpServletResponse response, String address) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        return address;

    }

}
