package univer.controller;

import univer.service.WeatherProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateweather")
public class UpdateWeatherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        WeatherProvider provider = new WeatherProvider();
        writer.print("Timezone: " + provider.getTimezone() +
                ", Temperature: " + provider.getTemperature() +
                ", Summary: " + provider.getSummary());

    }
}
