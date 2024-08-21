package hitachi_genai.popDashBoard.enums;

public enum ServiceCategory {

    AI_AND_MACHINE_LEARNING("AI AND MACHINE LEARNING"),
    COMPUTE("COMPUTE"),
    DEVELOPER_TOOLS("DEVELOPER TOOLS"),
    MANAGEMENT_AND_GOVERNANCE("MANAGEMENT AND GOVERNANCE"),
    NETWORKING("NETWORKING"),
    SECURITY("SECURITY"),
    STORAGE("STORAGE"),
    WEB("WEB"),
    OTHER("OTHER");

    private String category;

    ServiceCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.category;
    }

    public static ServiceCategory fromString(String category) {
        for (ServiceCategory serviceCategory : ServiceCategory.values()) {
            if (serviceCategory.category.equalsIgnoreCase(category)) {
                return serviceCategory;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + category);
    }
}
