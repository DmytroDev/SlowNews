package univer.controller;

import univer.model.News;
import univer.service.NewsCreationHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
}
