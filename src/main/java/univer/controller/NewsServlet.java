package univer.controller;

import univer.model.News;
import univer.model.User;
import univer.service.NewsCreationHelper;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NewsCreationHelper helper = new NewsCreationHelper();
        List<News> newsList = helper.createNewsList();
        req.setAttribute("newsList", newsList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        List <User> users = UsersContainer.getUsersContainer().getUserList();
        if (UsersContainer.getUsersContainer().contains(username)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", username);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
        dispatcher.forward(req,resp);
    }
}
