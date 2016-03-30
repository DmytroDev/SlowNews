package univer.controller;

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

@WebServlet("/show")
public class ShowUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersContainer usersContainer = UsersContainer.getUsersContainer();
        List<User> users = usersContainer.getUserList();
        req.setAttribute("users", users);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/show-users.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String passw = req.getParameter("password");
        String cPassw = req.getParameter("confirm-password");
        RequestDispatcher dispatcher = null;

        if ( (passw != null) && (cPassw != null) && (passw.equals(cPassw))) {
            UsersContainer usersContainer = UsersContainer.getUsersContainer();
            List<User> users = usersContainer.getUserList();
            users.add(new User(username, passw));
            req.setAttribute("users", users);
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/show-users.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "true");
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
            dispatcher.forward(req, resp);

        }
    }

}
