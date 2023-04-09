package team.project.foodsparks.model;

public enum Complexity {
    EASY("Легкий рівень складності"),
    MEDIUM("Середній рівень складності"),
    HARD("Важкий рівень складності");

    private final String value;

    Complexity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
