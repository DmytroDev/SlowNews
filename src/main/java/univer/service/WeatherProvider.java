package univer.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherProvider {

    public static void main(String[] args) {
        WeatherProvider weatherProvider = new WeatherProvider();
        System.out.println(weatherProvider.getWeather());
    }

    public String getWeather(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.forecast.io").
                path("/forecast/ccc9e70f9fbe7b36c2ceea0201205811/50.450100,30.523400");

        String weather = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        return weather;
    }
}
