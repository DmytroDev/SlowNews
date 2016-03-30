package univer.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            /*req.setAttribute("error", "true");*/
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
            dispatcher.forward(req, resp);
    }

/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String passw = req.getParameter("password");
        String cPassw = req.getParameter("confirm-password");
        RequestDispatcher dispatcher = null;
        // TODO: delete line bellow later
        System.out.println(username + ":" + passw + " " +cPassw);

        if ( (passw != null) && (cPassw != null) && (passw.equals(cPassw))) {
            UsersContainer usersContainer = UsersContainer.getUsersContainer();
            List<User> users = usersContainer.getUserList();
            users.add(new User(username, passw));

            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/show-users.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "true");
            doGet(req, resp);

*//*            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
            dispatcher.forward(req, resp);*//*
        }
    }*/

}
