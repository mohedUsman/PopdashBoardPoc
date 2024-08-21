package hitachi_genai.popDashBoard.enums;

public enum ChargeFrequency {


    USAGE_BASED("Usage-Based"),
    MONTHLY("MONTHLY"),
    QUARTERLY("QUARTERLY"),
    YEARLY("YEARLY"),
    ONE_TIME("ONE_TIME"),
    OTHER("OTHER");
    private final String value;

    ChargeFrequency(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static ChargeFrequency fromString(String value) {
        for (ChargeFrequency frequency : ChargeFrequency.values()) {
            if (frequency.value.equalsIgnoreCase(value)) {
                return frequency;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
