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
import java.util.HashMap;
import java.util.List;

@WebServlet("/archive")
public class ArchiveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String)session.getAttribute("username");
        ArchiveContainer archiveContainer = ArchiveContainer.createArchiveContainer(userName);

        HashMap<String, List<News>> archive = archiveContainer.getUsersArchive();
        List<News> archiveList = archive.get(userName);
        req.setAttribute("archiveList", archiveList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/archive.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imagePath = req.getParameter("imagePath");
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        HttpSession session = req.getSession();
        String userName = (String)session.getAttribute("username");
        ArchiveContainer archiveContainer = ArchiveContainer.createArchiveContainer(userName);
        archiveContainer.addToArchive(new News(title, imagePath, description));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
        dispatcher.forward(req, resp);
    }
}
