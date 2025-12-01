package br.com.desafio.geradorcupons.utils;

public class CouponUtils {

    public static int SIZE_COUPON = 6;

    public static String formatCouponCode(String promoCode) {
        StringBuilder promoCodeWithoutSpecialChars = new StringBuilder(removeSpecialChars(promoCode));
        int sizeCode = promoCodeWithoutSpecialChars.length();

        if (sizeCode < SIZE_COUPON) {
            int resto = SIZE_COUPON - sizeCode;

            for (int i = resto; i < SIZE_COUPON; i++) {
                promoCodeWithoutSpecialChars.append("0");
            }

            return promoCodeWithoutSpecialChars.toString();
        }

        return promoCodeWithoutSpecialChars.toString();
    }

    public static String removeSpecialChars(String promoCode) {
        return promoCode.replaceAll("[^A-Za-z0-9]", "").trim();
    }
}
