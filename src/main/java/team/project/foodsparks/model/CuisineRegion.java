package team.project.foodsparks.model;

public enum CuisineRegion {
    EAST("East"),
    WEST("West"),
    NORTH("North"),
    SOUTH("South");

    private String value;

    CuisineRegion(String value) {
        this.value = value;
    }
}
