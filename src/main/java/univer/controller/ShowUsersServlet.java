package univer.controller;

import univer.model.dao.UserDAO;
import univer.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view/show")
public class ShowUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = users = new UserDAO().getAll();
        req.setAttribute("users", users);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/show-users.jsp");
        dispatcher.forward(req, resp);
    }

}
