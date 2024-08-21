package hitachi_genai.popDashBoard.enums;

public enum RegionName {
    EAST_US("EAST US"),
    EAST_US_2("EAST US 2"),
    GLOBAL("GLOBAL"),
    NORTH_CENTRAL_US("NORTH CENTRAL US"),
    SOUTH_CENTRAL_US("SOUTH CENTRAL US"),
    WEST_US("WEST US");

    private final String value;

    RegionName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static RegionName fromString(String value) {
        for (RegionName region : RegionName.values()) {
            if (region.value.equalsIgnoreCase(value)) {
                return region;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
