package server;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/vulnerableLogin")
public class VulnerableLoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public VulnerableLoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("Username");
        String password = request.getParameter("password");

        UserDAO userDao = new UserDAO();
        boolean isVulnerable = true;

        try {
            User user = userDao.checkLogin(email, password, isVulnerable);
            String destPage = "VulnerableForm.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "home.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
