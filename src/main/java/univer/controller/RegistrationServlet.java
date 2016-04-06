package univer.controller;

import org.apache.commons.codec.digest.DigestUtils;
import univer.model.User;
import univer.service.UsersContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
            dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassw = req.getParameter("confirm-password");
        RequestDispatcher dispatcher = null;

        if ( (!"".equals(username)) && (!"".equals(password)) && (!"".equals(confirmPassw)) && (password.equals(confirmPassw))) {
            UsersContainer usersContainer = UsersContainer.getUsersContainer();
            List<User> users = usersContainer.getUserList();
            users.add(new User(username, DigestUtils.sha256Hex(password)));
            req.setAttribute("users", users);
            req.getSession().setAttribute("username", username);
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "true");
            resp.sendRedirect("/registration");

        }
    }
}
