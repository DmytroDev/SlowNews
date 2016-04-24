package univer.controller;

import univer.model.dao.NewsDAO;
import univer.model.entity.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/view/archive")
public class ArchiveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userID = (int) session.getAttribute("userID");
        List<News> archiveList = new NewsDAO().getNewsListByUserID(userID);
        req.setAttribute("archiveList", archiveList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/archive.jsp");
        dispatcher.forward(req, resp);
    }

}
