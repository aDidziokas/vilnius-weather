package adidziokas.vilniusweather;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    @Autowired
    private HourlyTempRepository hourlyTempRepository;

    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.defaultHeader("apikey", Secrets.getApiKey()).build();
    }

    @Scheduled(fixedRate = 3600000)
    //@Scheduled(fixedRate = 360)
    public void addToDB()
    {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        HourlyTemp[] hourlyTemp = restTemplate.getForObject("https://api.climacell.co/v3/weather/forecast/hourly?lat=54.6891594&lon=25.2798004&fields=temp", HourlyTemp[].class);
        Iterable<HourlyTempEntity> hourlyTempEntities = hourlyTempRepository.findAll();
        Boolean exists = false;
        for (HourlyTemp hour: hourlyTemp) {
            HourlyTempEntity h = new HourlyTempEntity();
            h.setHourCalled(OffsetDateTime.now());
            h.setHourProvided(hour.getObservationTime().getValue());
            h.setTemperature(hour.getTemp().toString());
            for (HourlyTempEntity hourlyTempEntity: hourlyTempEntities) {
                if(h.getHourProvided() == hourlyTempEntity.getHourProvided())
                {
                    exists = true;
                }
            }
            if(!exists)
            hourlyTempRepository.save(h);
        }
    }
}
