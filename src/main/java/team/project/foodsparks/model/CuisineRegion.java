package team.project.foodsparks.model;

public enum CuisineRegion {
    EAST("East"),
    WEST("West"),
    NORTH("North"),
    SOUTH("South");

    public String value;

    CuisineRegion(String value) {
        this.value = value;
    }
}
