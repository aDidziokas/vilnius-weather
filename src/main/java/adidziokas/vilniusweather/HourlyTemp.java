package adidziokas.vilniusweather;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyTemp {
    private double lon;
    private double lat;
    private Temp temp;
    private ObservationTime observationTime;

    @JsonProperty("lon")
    public double getLon() { return lon; }
    @JsonProperty("lon")
    public void setLon(double value) { this.lon = value; }

    @JsonProperty("lat")
    public double getLat() { return lat; }
    @JsonProperty("lat")
    public void setLat(double value) { this.lat = value; }

    @JsonProperty("temp")
    public Temp getTemp() { return temp; }
    @JsonProperty("temp")
    public void setTemp(Temp value) { this.temp = value; }

    @JsonProperty("observation_time")
    public ObservationTime getObservationTime() { return observationTime; }
    @JsonProperty("observation_time")
    public void setObservationTime(ObservationTime value) { this.observationTime = value; }

    @Override
    public String toString()
    {
        return "Time = "+ observationTime +", Temp  = "+ temp;
    }
}
