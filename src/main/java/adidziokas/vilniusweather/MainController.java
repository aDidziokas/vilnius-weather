package adidziokas.vilniusweather;

import org.hibernate.sql.ordering.antlr.OrderingSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.*;
@CrossOrigin
@Controller
@RequestMapping(path="/vilnius-weather")
public class MainController {

    @Autowired
    private HourlyTempRepository hourlyTempRepository;

    //@CrossOrigin(origins = "http://127.0.0.1:8081/")
    @GetMapping(path="/all")
    public @ResponseBody Iterable<HourlyTempEntity> getAllData()
    {
        return hourlyTempRepository.findAll();
    }
    //@CrossOrigin(origins = "http://127.0.0.1:8081/")
    @GetMapping(path="/now")
    public @ResponseBody HourlyTempEntity getLatestData()
    {
        Iterable<HourlyTempEntity> hourlyTempEntities = hourlyTempRepository.findAll();
        OffsetDateTime now = OffsetDateTime.now();

        List<HourlyTempEntity> entityList = new ArrayList<HourlyTempEntity>();
        hourlyTempEntities.forEach(entityList::add);
        Collections.sort(entityList, new Comparator<HourlyTempEntity>() {
            @Override
            public int compare(HourlyTempEntity o1, HourlyTempEntity o2) {
                return  o2.getHourProvided().compareTo(o1.getHourProvided());
            }
        });

        for (HourlyTempEntity ent: entityList) {

            int x = ent.getHourProvided().compareTo(now);
            if(x == -1)
            {
                return ent;
            }
        }
        return entityList.get(0);
    }
}
