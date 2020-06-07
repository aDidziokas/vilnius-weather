package adidziokas.vilniusweather;

import com.fasterxml.jackson.annotation.*;

public class Temp {
    private double value;
    private Units units;

    @JsonProperty("value")
    public double getValue() { return value; }
    @JsonProperty("value")
    public void setValue(double value) { this.value = value; }

    @JsonProperty("units")
    public Units getUnits() { return units; }
    @JsonProperty("units")
    public void setUnits(Units value) { this.units = value; }

    @Override
    public String toString()
    {
        return getValue()+units.toString();
    }
}
