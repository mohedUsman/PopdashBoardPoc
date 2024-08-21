package hitachi_genai.popDashBoard.enums;

public enum ConsumedUnit {
    //UNITS,UNITS/MONTH
 //   UNITS,UNITS_PER_MONTH,GB,GB_PER_MONTH,GB_SECONDS,HOURS,UNITS_PER_HOUR,UNITS_PER_DAY
    UNITS("UNITS"),
    UNITS_PER_MONTH("Units/Month"),
    GB("GB"),
    GB_PER_MONTH("GB/Month"),
    GB_SECONDS("GB Seconds"),
    HOURS("HOURS"),
    UNITS_PER_HOUR("Units/Hour"),
    UNITS_PER_DAY("Units/Day");
    private final String value;

    ConsumedUnit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static ConsumedUnit fromString(String value) {
        for (ConsumedUnit unit : ConsumedUnit.values()) {
            if (unit.value.equalsIgnoreCase(value)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }

}
