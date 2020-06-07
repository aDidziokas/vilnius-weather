package adidziokas.vilniusweather;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Units {
    C;

    @JsonValue
    public String toValue() {
        switch (this) {
            case C: return "C";
        }
        return null;
    }

    @JsonCreator
    public static Units forValue(String value) throws IOException {
        if (value.equals("C")) return C;
        throw new IOException("Cannot deserialize Units");
    }
}
