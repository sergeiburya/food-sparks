package team.project.foodsparks.util;

public class ProductAmountConverter {
    private ProductAmountConverter() {
    }

    public static String convertProductAmount(Integer amount) {
        if (amount > 1000) {
            int kilos = amount / 1000;
            int grams = amount % 1000;
            return kilos + " кг " + grams + " г";
        } else {
            return amount + " г";
        }
    }
}
