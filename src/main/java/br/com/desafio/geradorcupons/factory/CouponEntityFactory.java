package br.com.desafio.geradorcupons.factory;

import br.com.desafio.geradorcupons.dto.CouponRequest;
import br.com.desafio.geradorcupons.entity.CouponEntity;

import java.time.LocalDateTime;

public class CouponEntityFactory {

    public static CouponEntity createFrom(CouponRequest couponRequest) {
        return new CouponEntity.Builder()
                .code(couponRequest.getCode())
                .description(couponRequest.getDescription())
                .discountValue(couponRequest.getDiscountValue())
                .expirationDate(couponRequest.getExpirationDate())
                .published(couponRequest.getPublished())
                .couponDeleted(false)
                .build();
    }

    public static CouponEntity createFrom(CouponEntity couponEntity) {
        return new CouponEntity.Builder()
                .id(couponEntity.getId())
                .code(couponEntity.getCode())
                .description(couponEntity.getDescription())
                .discountValue(couponEntity.getDiscountValue())
                .expirationDate(couponEntity.getExpirationDate())
                .published(couponEntity.isPublished())
                .couponDeleted(true)
                .createdAt(couponEntity.getCreatedAt())
                .deletedAt(LocalDateTime.now())
                .build();
    }
}
