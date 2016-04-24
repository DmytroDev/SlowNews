package univer.controller;

import univer.model.dao.NewsDAO;
import univer.model.dao.UserDAO;
import univer.model.entity.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/view/news")
public class NewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = (req.getParameter("description")).trim();
        description = (description.length() > 1000) ? description.substring(0, 1000) + " ..." : description;

        String imagePath = req.getParameter("imagePath");

        HttpSession session = req.getSession();
        int userID = (int) session.getAttribute("userID");
        News news = new News(title, description, imagePath);
        news.setUser( new UserDAO().get(userID));
        new NewsDAO().saveOrUpdate(news);
        resp.sendRedirect("/view/news");
    }

}
