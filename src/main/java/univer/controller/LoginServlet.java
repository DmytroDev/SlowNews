package univer.controller;

import org.apache.commons.codec.digest.DigestUtils;
import univer.model.Feed;
import univer.model.User;
import univer.service.NewsGeneratorRSS;
import univer.service.UsersContainer;
import univer.service.WeatherProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        List <Feed> feeds = new NewsGeneratorRSS().createNewsList();
        this.getServletContext().setAttribute("newsList", feeds);
        WeatherProvider provider = new WeatherProvider();
        this.getServletContext().setAttribute("timezone", provider.getTimezone());
        this.getServletContext().setAttribute("temperature", provider.getTemperature());
        this.getServletContext().setAttribute("summary", provider.getSummary());
/*        List<News> newsList = new NewsGenerator().createNewsList();
        this.getServletContext().setAttribute("newsList", newsList);*/
    }

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
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/news.jsp");
            dispatcher.forward(req,resp);
        } else {
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
            req.setAttribute("isValid", "false");
            dispatcher.forward(req,resp);
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
