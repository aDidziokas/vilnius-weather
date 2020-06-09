package adidziokas.vilniusweather;

import org.springframework.data.repository.CrudRepository;
import adidziokas.vilniusweather.HourlyTempEntity;

public interface HourlyTempRepository extends CrudRepository<HourlyTempEntity, Integer> {

}
