package adidziokas.vilniusweather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
@EnableScheduling
public class VilniusWeatherApplication {

	private static final Logger log =
			LoggerFactory.getLogger(VilniusWeatherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VilniusWeatherApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.defaultHeader("apikey", Secrets.getApiKey()).build();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8081");
			}
		};
	}


				//@Bean
	/*public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			HourlyTemp[] hourlyTemp = restTemplate.getForObject("https://api.climacell.co/v3/weather/forecast/hourly?lat=54.6891594&lon=25.2798004&fields=temp", HourlyTemp[].class);
		};
	}*/

}
