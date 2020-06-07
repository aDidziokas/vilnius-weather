package adidziokas.vilniusweather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VilniusWeatherApplication {

	private static final Logger log =
			LoggerFactory.getLogger(VilniusWeatherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VilniusWeatherApplication.class, args);

	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.defaultHeader("apikey",Secrets.getApiKey()).build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			HourlyTemp[] hourlyTemp = restTemplate.getForObject("https://api.climacell.co/v3/weather/forecast/hourly?lat=54.6891594&lon=25.2798004&fields=temp", HourlyTemp[].class);
			for (HourlyTemp hour: hourlyTemp)
			{
				System.out.println(hour.getTemp());
				System.out.println(hour.getObservationTime());
				log.info(hour.toString());
			}
		};
	}
}
