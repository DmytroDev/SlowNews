package univer.controller;

import org.apache.commons.codec.digest.DigestUtils;
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
import java.util.List;

@WebServlet("/view/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("username", "guest");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<User> users = new UserDAO().getAll();
        HttpSession session = req.getSession();
        if ( isCredentialsValid(username, password, users) ) {
            session.setAttribute("username", username);
            User user = new UserDAO().getUserByLoginAndPassword(username, password);
            session.setAttribute("userID", user.getId());
            session.setAttribute("isValid", "true");
            resp.sendRedirect("/view/news");
        } else {
            session.setAttribute("isValid", "false");
            resp.sendRedirect("/view/login");
        }
    }


    private boolean isCredentialsValid(String login, String password, List<User> users){
        if ( (login == "") || (password == "") ) {
            return false;
        }
        boolean isValid = false;
        for (User user : users) {
            if ( login.equals(user.getUsername()) ){
                if (DigestUtils.sha256Hex(password).equals(user.getPassword())){
                    isValid = true;
                    return isValid;
                }
            }
        }
        return isValid;
    }
}
