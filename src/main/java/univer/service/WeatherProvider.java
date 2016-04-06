package univer.service;

import org.json.JSONObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherProvider {

    private String timezone;
    private int temperature;
    private String summary;


    public WeatherProvider() {
        getWeather();
    }

    public void getWeather() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.forecast.io").
                path("/forecast/ccc9e70f9fbe7b36c2ceea0201205811/50.450100,30.523400");
        String json = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        JSONObject obj = new JSONObject(json);
        this.timezone = obj.getString("timezone");  //getJSONObject("timezone").getDouble("temperature");
        this.temperature = (int)((obj.getJSONObject("currently").getDouble("temperature") - 32 )/1.8) ;
        this.summary = obj.getJSONObject("currently").getString("summary");
    }

    public String getTimezone() {
        return timezone;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getSummary() {
        return summary;
    }
}

