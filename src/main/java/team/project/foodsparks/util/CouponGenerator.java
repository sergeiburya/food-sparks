package team.project.foodsparks.util;

import java.security.SecureRandom;
import java.util.Random;

public class CouponGenerator {
    private CouponGenerator() {
    }

    public static String createRandomCode() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < 9; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString().toUpperCase();
    }
}
