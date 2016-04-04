package univer.controller;

import univer.model.News;
import univer.model.User;
import univer.service.NewsGenerator;
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

// forward from login jsp
@WebServlet("/news")
public class NewsServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        List<News> newsList = new NewsGenerator().createNewsList();
        this.getServletContext().setAttribute("newsList", newsList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
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
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
            dispatcher.forward(req,resp);
        } else {
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
            req.setAttribute("isValid", "false");
            dispatcher.forward(req,resp);
        }
    }

    private boolean isCredentialsValid(String login, String password, List <User> users){
        if ( (login == "") || (password == "") ) {
            return false;
        }
        boolean isValid = false;
        for (User user : users) {
            if ( login.equals(user.getLogin()) ){
                if (password.equals(user.getPassword())){
                    isValid = true;
                    return isValid;
                }
            }
        }
        return isValid;
    }

}
