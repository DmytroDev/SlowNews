package univer.controller;

import univer.model.entity.Feed;
import univer.service.NewsGeneratorRSS;
import univer.service.WeatherProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"", "/login", "/registration", "/news", "/show", "/archive", "/logout"})
public class PageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException{
        List<Feed> feeds = new NewsGeneratorRSS().createNewsList();
        this.getServletContext().setAttribute("newsList", feeds);
        WeatherProvider provider = new WeatherProvider();
        this.getServletContext().setAttribute("timezone", provider.getTimezone());
        this.getServletContext().setAttribute("temperature", provider.getTemperature());
        this.getServletContext().setAttribute("summary", provider.getSummary());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(req, resp);

    }
}
