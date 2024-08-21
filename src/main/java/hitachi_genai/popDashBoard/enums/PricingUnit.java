package hitachi_genai.popDashBoard.enums;

public enum PricingUnit {
    //UNITS,UNITS_PER_DAY,UNITS_PER_HOUR,UNITS_PER_MONTH,GB,GB_PER_MONTH,GB_SECONDS,HOURS
    UNITS("UNITS"),
    UNITS_PER_DAY("Units/Day"),
    UNITS_PER_HOUR("Units/Hour"),
    UNITS_PER_MONTH("Units/Month"),
    GB("GB"),
    GB_PER_MONTH("GB/Month"),
    GB_SECONDS("GB Seconds"),
    HOURS("HOURS");
    private final String value;

    PricingUnit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static PricingUnit fromString(String value) {
        for (PricingUnit unit : PricingUnit.values()) {
            if (unit.value.equalsIgnoreCase(value)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
