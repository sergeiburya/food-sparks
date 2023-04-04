package team.project.foodsparks.model;

public enum DishType {
    DESSERT("Десерт"),
    SOUP("Перші страви"),
    MAIN_DISH("Основна страва"),
    PASTRY("Випічка"),
    APPETIZER("Закуска");

    private final String value;

    DishType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
