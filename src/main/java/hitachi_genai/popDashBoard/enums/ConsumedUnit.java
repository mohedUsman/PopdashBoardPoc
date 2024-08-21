package hitachi_genai.popDashBoard.enums;

public enum ConsumedUnit {
    //UNITS,UNITS/MONTH
 //   UNITS,UNITS_PER_MONTH,GB,GB_PER_MONTH,GB_SECONDS,HOURS,UNITS_PER_HOUR,UNITS_PER_DAY
    UNITS("UNITS"),
    UNITS_PER_MONTH("units/month"),
    GB("GB"),
    GB_PER_MONTH("GB/month"),
    GB_SECONDS("GB Seconds"),
    HOURS("HOURS"),
    UNITS_PER_HOUR("units/hour"),
    UNITS_PER_DAY("units/day");
    private final String value;

    ConsumedUnit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
