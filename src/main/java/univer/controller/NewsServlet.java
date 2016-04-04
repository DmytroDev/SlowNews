package univer.controller;

import univer.model.News;
import univer.service.ArchiveContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// forward from login jsp
@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imagePath = req.getParameter("imagePath");
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("username");
        ArchiveContainer archiveContainer = ArchiveContainer.createArchiveContainer();
        archiveContainer.addToArchive(userName, new News(title, imagePath, description));
        resp.sendRedirect("/news");
    }

}
