package univer.controller;

import org.apache.commons.codec.digest.DigestUtils;
import univer.model.dao.DAOException;
import univer.model.dao.UserDAO;
import univer.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/view/registration")
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
            try {
                new UserDAO().saveOrUpdate( new User(username, DigestUtils.sha256Hex(password)));
            } catch (DAOException e) {
                e.printStackTrace();
            }
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            User user = new UserDAO().getUserByLoginAndPassword(username, password);
            session.setAttribute("userID", user.getId());
            session.setAttribute("isValid", "true");
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "true");
            resp.sendRedirect("/view/registration");

        }
    }
}
