package adidziokas.vilniusweather;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class ObservationTime {
    private OffsetDateTime value;

    @JsonProperty("value")
    public OffsetDateTime getValue() { return value; }
    @JsonProperty("value")
    public void setValue(OffsetDateTime value) { this.value = value; }

    @Override
    public String toString()
    {
        return value.toString();
    }

}
