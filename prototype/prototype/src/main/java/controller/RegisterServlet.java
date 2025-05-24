package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.User;

public class RegisterServlet extends HttpServlet {
    // Simulate a database (for demo only)
    private static final Map<String, User> userDatabase = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate inputs
        if (name == null || name.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("reg.html").forward(request, response);
            return;
        }

        // Check for duplicate email (simulated)
        if (userDatabase.containsKey(email)) {
            request.setAttribute("error", "Email already registered!");
            request.getRequestDispatcher("reg.html").forward(request, response);
            return;
        }

        // Create and store the user
        User user = new User(name, email, password);
        userDatabase.put(email, user);

        // Store user in session for success page
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // Redirect to success page
        response.sendRedirect("success.html");
    }
}