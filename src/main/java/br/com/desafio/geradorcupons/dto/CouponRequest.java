package br.com.desafio.geradorcupons.dto;

import java.time.LocalDate;

public class CouponRequest {
    private String promoCode;
    private double discountValue;
    private LocalDate expirationDate;
    private Boolean couponValid;

    public CouponRequest() {
    }

    public CouponRequest(String promoCode, double discountValue, LocalDate expirationDate, boolean couponValid) {
        this.promoCode = promoCode;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.couponValid = couponValid;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isCouponValid() {
        return couponValid;
    }

    public void setCouponValid(boolean couponValid) {
        this.couponValid = couponValid;
    }

    @Override
    public String toString() {
        return "CouponRequest{" +
                "promoCode='" + promoCode + '\'' +
                ", discountValue=" + discountValue +
                ", expirationDate=" + expirationDate +
                ", isCouponValid=" + couponValid +
                '}';
    }
}
