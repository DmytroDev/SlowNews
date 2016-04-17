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
        List <User> users = UsersContainer.getUsersContainer().getUserList();

        RequestDispatcher dispatcher = null;
        if ( isCredentialsValid(username, password, users) ) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("/view/news");
        } else {
            req.setAttribute("isValid", "false");
            resp.sendRedirect("/view/login");
        }
    }


    private boolean isCredentialsValid(String login, String password, List<User> users){
        if ( (login == "") || (password == "") ) {
            return false;
        }
        boolean isValid = false;
        for (User user : users) {
            if ( login.equals(user.getLogin()) ){
                if (DigestUtils.sha256Hex(password).equals(user.getPassword())){
                    isValid = true;
                    return isValid;
                }
            }
        }
        return isValid;
    }
}
