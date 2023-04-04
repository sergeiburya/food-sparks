package team.project.foodsparks.util;

public class CookingTimeConverter {
    private CookingTimeConverter() {
    }

    public static String convertCookingTime(Integer minutesAmount) {
        int hours = minutesAmount / 60;
        int minutes = minutesAmount % 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (hours > 0) {
            stringBuilder.append(hours);
            stringBuilder.append("г.");
            stringBuilder.append(" ");
        }
        stringBuilder.append(minutes);
        stringBuilder.append("хв.");
        return stringBuilder.toString();
    }
}
