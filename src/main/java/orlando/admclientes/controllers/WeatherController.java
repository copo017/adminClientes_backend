package orlando.admclientes.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import orlando.admclientes.services.WeatherService;

import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public Map<String, Object> getWeather(@RequestParam String city) {
        return weatherService.getWeatherByCity(city, apiKey);
    }
}
