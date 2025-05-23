package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.User;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(name, email, password);

        response.setContentType("text/html");
        response.getWriter().println("<h1>Registration Successful!</h1>");
        response.getWriter().println("<p>Welcome, " + user.getName() + "!</p>");
    }
}
