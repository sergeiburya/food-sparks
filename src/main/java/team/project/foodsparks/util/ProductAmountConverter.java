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

    public static void main(String[] args) {
        System.out.println(convertProductAmount(250));
        System.out.println(convertProductAmount(1450));
        System.out.println(convertProductAmount(6950));
        System.out.println(convertProductAmount(950));
        System.out.println(convertProductAmount(999));
        System.out.println(convertProductAmount(12250));
    }

}
