package br.com.desafio.geradorcupons.entity;

import br.com.desafio.geradorcupons.enums.StatusCouponEnum;
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

    @Column(name = "code", length = 6, nullable = false, unique = true)
    private String code;

    @Column(name = "description", length = 64, nullable = false)
    private String description;

    @DecimalMin(value = "0.5")
    @Column(name = "discount_value", nullable = false)
    private double discountValue;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "published", nullable = false)
    private boolean published = false;

    @Enumerated
    @Column(name = "status", nullable = false)
    private StatusCouponEnum status = StatusCouponEnum.ACTIVE;

    @Column(name = "redeemed", nullable = false)
    private boolean redeemed = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public CouponEntity() {
    }

    private CouponEntity(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.description = builder.description;
        this.discountValue = builder.discountValue;
        this.expirationDate = builder.expirationDate;
        this.published = builder.published;
        this.status = builder.statusCouponEnum;
        this.createdAt = builder.createdAt;
        this.deletedAt = builder.deletedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRedeemed() {
        return redeemed;
    }

    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }

    public StatusCouponEnum getStatus() {
        return status;
    }

    public void setStatus(StatusCouponEnum status) {
        this.status = status;
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

    public static class Builder {

        private Long id;
        private String code;
        private String description;
        private double discountValue;
        private LocalDate expirationDate;
        private boolean published = false;
        private StatusCouponEnum statusCouponEnum;
        private boolean redeemed;
        private LocalDateTime createdAt = LocalDateTime.now();
        private LocalDateTime deletedAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder discountValue(double discountValue) {
            this.discountValue = discountValue;
            return this;
        }

        public Builder expirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder published(boolean published) {
            this.published = published;
            return this;
        }

        public Builder status(StatusCouponEnum statusCouponEnum) {
            this.statusCouponEnum = statusCouponEnum;
            return this;
        }

        public Builder redeemed(boolean redeemed) {
            this.redeemed = redeemed;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder deletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public CouponEntity build() {
            return new CouponEntity(this);
        }
    }
}
