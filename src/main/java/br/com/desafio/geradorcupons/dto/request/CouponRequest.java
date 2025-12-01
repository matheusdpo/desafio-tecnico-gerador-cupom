package br.com.desafio.geradorcupons.dto.request;

import java.time.LocalDate;

public class CouponRequest {
    private String code;
    private String description;
    private double discountValue;
    private LocalDate expirationDate;
    private Boolean published;

    public CouponRequest() {
    }

    public CouponRequest(String code, double discountValue, LocalDate expirationDate, boolean published) {
        this.code = code;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }
}
