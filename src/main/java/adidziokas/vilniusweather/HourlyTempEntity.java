package adidziokas.vilniusweather;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class HourlyTempEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHourData;

    private OffsetDateTime hourCalled;
    @Column(unique = true)
    private OffsetDateTime hourProvided;

    private String temperature;

    public Integer getIdHourData()
    {
        return idHourData;
    }
    public void setIdHourData(Integer idHourData)
    {
        this.idHourData = idHourData;
    }
    public OffsetDateTime getHourCalled()
    {
        return hourCalled;
    }
    public void setHourCalled(OffsetDateTime hourCalled)
    {
        this.hourCalled = hourCalled;
    }

    public OffsetDateTime getHourProvided() {
        return hourProvided;
    }

    public void setHourProvided(OffsetDateTime hourProvided) {
        this.hourProvided = hourProvided;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }
}
