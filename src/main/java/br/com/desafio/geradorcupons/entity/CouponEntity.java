package br.com.desafio.geradorcupons.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "coupons")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "promo_code", length = 6, nullable = false)
    private String promoCode;

    @DecimalMin(value = "0.5")
    @Column(name = "discount_value", nullable = false)
    private double discountValue;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "is_coupon_valid", nullable = false)
    private boolean isCouponValid;

    @Column(name = "is_coupon_deleted", nullable = false)
    private boolean isCouponDeleted = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public CouponEntity() {
    }

    public CouponEntity(Long id, String promoCode, double discountValue, LocalDate expirationDate, boolean isCouponValid, boolean isCouponDeleted, LocalDateTime createdAt, LocalDateTime deletedAt) {
        this.id = id;
        this.promoCode = promoCode;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.isCouponValid = isCouponValid;
        this.isCouponDeleted = isCouponDeleted;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return isCouponValid;
    }

    public void setCouponValid(boolean couponValid) {
        isCouponValid = couponValid;
    }

    public boolean isCouponDeleted() {
        return isCouponDeleted;
    }

    public void setCouponDeleted(boolean couponDeleted) {
        isCouponDeleted = couponDeleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
